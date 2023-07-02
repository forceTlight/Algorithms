package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1890 - 점프
 * 문제유형 : DP
 * 난이도 : Silver 1
 * 풀이시간 : 1시간
 */
public class _1890_점프 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0)
                    continue;
                int[][] tmp = {{i + arr[i][j], j}, {i, j + arr[i][j]}};

                for(int k = 0; k < 2; k++){
                    int a = tmp[k][0];
                    int b = tmp[k][1];

                    if(a >= 0 && a < n && b >= 0 && b < n){
                        dp[a][b] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}