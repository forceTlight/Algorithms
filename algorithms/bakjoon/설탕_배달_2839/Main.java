import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        int answer = solution(n);
        if(answer == 0)
            answer = -1;
        System.out.println(answer);
    }

    public static int solution(int n) {
        if(n >= 3){
            dp[3] = 1;
        }
        if(n >= 5){
            dp[5] = 1;
        }

        for (int i = 6; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if(dp[i-3] != 0 && dp[i-5] != 0){
                    dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
                }
            }
        }
        return dp[n];
    }
}

