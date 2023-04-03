package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_경우의_수_메모이제이션 {
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n+1][m+1];

        dfs(n, m);
        System.out.println(dp[n][m]);
    }
    public static int dfs(int n, int r){
        if(dp[n][r] > 0)
            return dp[n][r];

        if(n == r || r == 0)
            return 1;

        return dp[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }
}