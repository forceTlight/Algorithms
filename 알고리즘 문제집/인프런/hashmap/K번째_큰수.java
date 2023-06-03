package 인프런.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class K번째_큰수 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    int sum = arr[i] + arr[j] + arr[k];
                    treeSet.add(sum);
                }
            }
        }

        int cnt = 0;
        int answer = -1;
        for(int i : treeSet){
            cnt++;
            if(cnt == m)
                answer = i;
        }

        System.out.println(answer);
    }
}