package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _21921_블로그 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int lt = 0;
        int rt = 0;

        int sum = 0;
        while(rt < x){
            sum += arr[rt++];
        }

        treeMap.put(sum, 1);

        for(int i = rt; i < arr.length; i++){
            sum = sum - arr[lt] + arr[i];
            lt++;
            treeMap.put(sum, treeMap.getOrDefault(sum, 0 ) + 1);
        }

        if(treeMap.lastKey() == 0){
            System.out.println("SAD");
        }else{
            System.out.println(treeMap.lastKey());
            System.out.println(treeMap.get(treeMap.lastKey()));
        }
    }
}