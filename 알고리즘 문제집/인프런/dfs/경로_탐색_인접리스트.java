package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경로_탐색_인접리스트 {
    static int n;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < n+1; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
        }

        visited[1] = true;
        dfs(1);
    }

    public static void dfs(int node){
        if(node == n){
            for(int i = 1; i < visited.length; i++){
                if(visited[i])
                    System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int n : adj[node]){
            if(!visited[n]){
                visited[n] = true;
                dfs(n);
                visited[n] = false;
            }
        }
    }
}