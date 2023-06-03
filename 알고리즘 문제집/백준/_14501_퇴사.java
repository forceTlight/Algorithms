package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14501_퇴사 {
    static int n;
    static int max = Integer.MIN_VALUE;
    static int[] day;
    static int[] money;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        day = new int[n];
        money = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            day[i] = Integer.parseInt(input[0]);
            money[i] = Integer.parseInt(input[1]);
        }

        // process
        dfs(0, 0);

        System.out.println(max);
    }

    // 재귀
    public static void dfs(int i, int sum) {
        if (i >= n) {
            if (sum > max)
                max = sum;
            return;
        }

        if (i + day[i] <= n)
            dfs(i + day[i], sum + money[i]);
        else
            dfs(i + day[i], sum);

        dfs(i + 1, sum);
    }
}
