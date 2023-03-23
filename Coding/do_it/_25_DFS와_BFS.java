package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _25_DFS와_BFS {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] arr;
    static int n;
    static int m;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        // 번호가 작은 것부터 방문하기 위해 정렬하기
        for(int i = 1; i <= n; i++)
            Collections.sort(adj[i]);

        visited = new boolean[n+1];
        dfs(v);
        System.out.println(sb);

        visited = new boolean[n+1];
        sb.setLength(0);

        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int node){
        visited[node] = true;
        sb.append(node + " ");

        for(int n : adj[node]){
            if(!visited[n]){
                dfs(n);
            }
        }
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int v = q.poll();
            sb.append(v + " ");

            for(int n : adj[v]){
                if(!visited[n]){
                    visited[n] = true;
                    q.offer(n);
                }
            }
        }
    }
}