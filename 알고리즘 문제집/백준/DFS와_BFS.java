package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와_BFS {
    public static int[][] arr;
    public static boolean[] visited;
    public static int n;
    public static int m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // dfs
        visited = new boolean[n+1];
        dfs(v, 0);

        System.out.println();

        // bfs
        visited = new boolean[n+1];
        bfs(v);
    }
    public static void dfs(int v, int depth){
        if(depth == m){
            return;
        }
        if(depth == 0){
            System.out.print(v + " ");
            visited[v] = true;
            dfs(v, depth + 1);
        }

        for(int i = 1; i < arr.length; i++) {
            if (arr[v][i] == 1 && !visited[i]) {
                visited[i] = true;
                System.out.print(i + " ");
                dfs(i, depth + 1);
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        System.out.print(v + " ");
        while(!q.isEmpty()){
            int n = q.poll();
            for(int i = 1; i < arr.length; i++){
                if(arr[n][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}