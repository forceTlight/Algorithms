package 인프런;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속_부분수열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // process
        int cnt = 0;
        int lt = 0;
        int rt;
        int sum = 0;
        for (rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];

            if(sum >= m){
                while(lt <= rt && sum >= m){
                    if(sum == m)
                        cnt++;

                    sum -= arr[lt];
                    lt++;
                }
            }
        }
        System.out.println(cnt);
    }
}