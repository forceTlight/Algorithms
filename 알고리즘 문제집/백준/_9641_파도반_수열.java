package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 파도반 수열
 * 문제유형 : DP
 * 난이도 : SILVER 3
 * 풀이시간 : 30분
 */
public class _9641_파도반_수열 {
    static long[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new long[n + 1];

            System.out.println(padovan(n));
        }
    }

    public static long padovan(int n) {
        if (n == 1 || n == 2 || n == 3)
            return 1;

        if(dp[n] != 0)
            return dp[n];

        return dp[n] = padovan(n - 3) + padovan(n - 2);
    }
}