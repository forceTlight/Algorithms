package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 계단 오르기
 * 문제유형 : DP
 * 난이도 : SILVER 3
 * 풀이시간 : 30분
 */
public class _2579_계단_오르기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            score[i] = num;
        }

        dp[1] = score[1];

        if(n >= 2)
            dp[2] = score[1] + score[2];

        for(int i = 3; i <= n; i++){
            dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}