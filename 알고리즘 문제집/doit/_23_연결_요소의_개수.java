package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _23_연결_요소의_개수 {
    static int n;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b); // 인접 리스트 이므로 양쪽에 추가
            adj[b].add(a);
        }

        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i);
                answer ++;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int node){
        ArrayList<Integer> nodeList = adj[node];
        for(int a : nodeList){
            if(!visited[a]){
                visited[a] = true;
                dfs(a);
            }
        }
    }
}
