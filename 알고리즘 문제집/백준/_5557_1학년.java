import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 5557 - 1학년
 * 문제유형 : DP
 * 난이도 : GOLD 5
 * 풀이시간 : 2시간
 */
public class Main {
    static int n;
    static int[] arr;
    static long[][] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new long[n][21];

        for (long[] arr : dp)
            Arrays.fill(arr, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = dfs(0, arr[0]);
        System.out.println(answer);
    }

    public static long dfs(int idx, int sum) {
        if (sum < 0 || sum > 20)
            return 0;

        if (idx == n) {
//            System.out.println(idx + " " + sum);
            return 1;
        }

        if (idx == n - 2) {
            return (sum == arr[n - 1]) ? 1 : 0;
        }

        if (dp[idx][sum] != -1)
            return dp[idx][sum];


        return dp[idx][sum] = dfs(idx + 1, sum - arr[idx + 1]) + dfs(idx + 1, sum + arr[idx + 1]);
    }
}