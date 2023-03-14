package 인프런;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_길이_연속_부분수열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int lt = 0; int rt;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(rt = 0; rt < n; rt++){
            if(arr[rt] == 0)
                cnt++;

            if(cnt > m){
                max = Math.max(rt - lt, max);

                while(arr[lt] != 0){
                    lt++;
                }
                lt++;
                cnt--;
            }
        }

        System.out.println(max);
    }
}