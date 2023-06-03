package 인프런.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프_최단거리_BFS {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] distance;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int a : adj[node]) {
                if (!visited[a]) {
                    visited[a] = true;
                    distance[a] = distance[node] + 1;
                    q.offer(a);
                }
            }
        }

        for(int i = 2; i <= n;   i++){
            System.out.println(i + " " + distance[i]);
        }
    }
}