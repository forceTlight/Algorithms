import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static Integer[][] dp;
    static int[] weightArr;
    static int[] valueArr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new Integer[n][k + 1];

        weightArr = new int[n];
        valueArr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weightArr[i] = w;
            valueArr[i] = v;
        }

        long answer = dfs(n - 1, k);
        System.out.println(answer);
    }

    public static int dfs(int idx, int weight) {
        if (idx < 0)
            return 0;

        if (dp[idx][weight] != null)
            return dp[idx][weight];

        if (weight - weightArr[idx] < 0) {
            dp[idx][weight] = dfs(idx - 1, weight);
        } else {
            dp[idx][weight] = Math.max(dfs(idx - 1, weight - weightArr[idx]) + valueArr[idx]
                    , dfs(idx - 1, weight));
        }

        return dp[idx][weight];
    }
}