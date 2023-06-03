import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int red = 0;
    static final int green = 1;
    static final int blue = 2;

    static int dp[][];
    static int cost[][];
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n][3];
        cost = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][red] = cost[0][red];
        dp[0][green] = cost[0][green];
        dp[0][blue] = cost[0][blue];

        System.out.println(Math.min(solution(n-1, red), Math.min(solution(n-1, blue),solution(n-1, green))));
    }
    public static int solution(int n, int color){
        if(dp[n][color] == 0){
            if(color == red){
                dp[n][red] = Math.min(solution(n-1, blue), solution(n-1, green)) + cost[n][red];
            }else if(color == green){
                dp[n][green] = Math.min(solution(n-1, red), solution(n-1, blue)) + cost[n][green];
            }else if(color == blue){
                dp[n][blue] = Math.min(solution(n-1, red), solution(n-1, green)) + cost[n][blue];
            }
        }
        return dp[n][color];
    }
}
