package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501_퇴사_백트래킹 {
    static class Meeting {
        int weight;
        int value;

        public Meeting(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static Meeting[] adj;
    static boolean[] visited;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new Meeting[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adj[i] = new Meeting(weight, value);
        }

        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int idx, int day, int sum) {
        if (n == depth) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = idx; i < n; i++) {
            if (day == 0) {
                // 선택 하거나, 안하거나
                dfs(depth + 1, i + 1, 0, sum);
                if (i + adj[i].weight <= n)
                    sum += adj[i].value;

                dfs(depth + 1, i + 1, adj[i].weight - 1, sum);
            } else {
                dfs(depth + 1, i + 1, day - 1, sum);
            }
        }
    }
}