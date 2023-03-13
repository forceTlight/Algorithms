package 인프런;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 연속된_자연수의_합 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n/2+1];

        for(int i = 0; i < arr.length; i++)
            arr[i] = i+1;

        int lt = 0; int rt;
        int sum = 0;
        int cnt = 0;
        for(rt = 0; rt < arr.length; rt++){
            sum += arr[rt];

            while(sum >= n && lt <= rt){
                if(sum == n)
                    cnt++;

                sum -= arr[lt];
                lt++;
            }
        }

        System.out.println(cnt);
    }
}