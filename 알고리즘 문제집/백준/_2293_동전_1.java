package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2293_동전_1 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        dp[0] = 1;
        int[] arr = new int[n];
        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n; i++){
            int coin = arr[i];
            for(int j = coin; j <= k; j++){
                dp[j] += dp[j - coin];
            }
        }

        System.out.println(dp[k]);
    }
}