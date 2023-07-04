import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1495 - 기타리스트
 * 문제유형 : DP
 * 난이도 : Silver 1
 * 풀이시간 : 2시간
 */
public class Main{
    static int n;
    static int s;
    static int m;
    static int[] arr;
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken()); // 시작 볼륨
        m = Integer.parseInt(st.nextToken()); // MAX 볼륨

        arr = new int[n];
        dp = new int[m + 1][n];

        for(int[] dpArr : dp){
            Arrays.fill(dpArr, -2);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(s, 0));
    }

    public static int dfs(int sum, int idx){
        if(sum < 0 || sum > m)
            return -1;

        if(idx == n)
            return sum;

        if(dp[sum][idx] != -2)
            return dp[sum][idx];

        return dp[sum][idx] = Math.max(dfs( sum + arr[idx], idx + 1), dfs(sum - arr[idx], idx + 1));
    }
}