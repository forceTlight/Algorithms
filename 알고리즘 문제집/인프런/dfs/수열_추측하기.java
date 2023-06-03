package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열_추측하기 {
    static int[][] dp;
    static int[] arr;
    static boolean[] visited;
    static int[] p;
    static int n;
    static int m;
    static boolean flag = false;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n+1][n+1];
        arr = new int[n];
        visited = new boolean[n+1];
        p = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = combi(n-1, n-1-i);
        }

        dfs(0, 0);
    }
    public static void dfs(int depth, int sum){
        if(flag)
            return;
        if(sum > m)
            return;
        if(depth == n) {
            if (sum == m) {
                flag = true;
                for (int i = 0; i < n; i++) {
                    System.out.print(p[i] + " ");
                }
                return;
            }
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]) {
                visited[i] = true;
                p[depth] = i;
                dfs(depth+1, sum + arr[depth] * p[depth]);
                visited[i] = false;
            }
        }
    }

    public static int combi(int n, int r){
        if(dp[n][r] != 0)
            return dp[n][r];

        if(n == r || r == 0){
            return dp[n][r] = 1;
        }

        return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}