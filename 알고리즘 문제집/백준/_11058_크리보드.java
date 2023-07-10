package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 11058 - 크리보드
 * 문제유형 : DP
 * 난이도 : GOLD 5
 * 풀이시간 : 2시간
 */
public class _11058_크리보드 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[101];

        for (int i = 1; i <= 6; i++)
            dp[i] = i;

        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 3; j <= i - 3; j++) {
                dp[i] = Math.max(dp[j] * (i - j - 1), dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}