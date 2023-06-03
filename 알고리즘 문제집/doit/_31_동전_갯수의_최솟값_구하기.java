package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31_동전_갯수의_최솟값_구하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] <= k){
                cnt += k / arr[i];
                k = k % arr[i];
            }
        }

        System.out.println(cnt);
    }
}