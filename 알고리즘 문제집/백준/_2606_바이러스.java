package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 2606 - 바이러스
 * 문제유형 : DFS
 * 난이도 : Silver 3
 * 풀이시간 : 5분
 */
public class _2606_바이러스 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    public static void dfs(int node){
        for(int n : adj[node]){
            if(!visited[n]){
                answer++;
                visited[n] = true;
                dfs(n);
            }
        }
    }
}