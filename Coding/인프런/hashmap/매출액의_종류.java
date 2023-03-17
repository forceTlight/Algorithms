package 인프런.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 매출액의_종류 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(i == k-1){
                flag = true;
            }
            if(i >= k){
                if(map.get(arr[i-k]) == 1)
                    map.remove(arr[i-k]);
                else
                    map.put(arr[i-k], map.get(arr[i-k]) - 1);
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if(flag)
                System.out.print(map.size() + " ");
        }
    }
}