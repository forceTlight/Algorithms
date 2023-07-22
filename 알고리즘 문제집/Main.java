import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[][] dp;
    static int[][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1][3];
            arr = new int[n + 1][3];
            for(int[] d : dp)
                Arrays.fill(d, -1);

            for(int j = 1; j <= 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= n; k++){
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[1][2] = arr[1][2];

            sb.append(Math.max(getScore(n, 1), getScore(n, 2))).append("\n");
        }
        System.out.println(sb);
    }

    public static int getScore(int col, int low){
        if(col <= 1 || dp[col][low] != -1)
            return dp[col][low];

        int nextLow = low == 1? 2 : 1;
        return dp[col][low] = Math.max(getScore(col - 1, nextLow), getScore(col - 2, nextLow)) + arr[col][low];
    }
}