package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분집합 {
    static int n;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        dfs(0);
    }
    public static void dfs(int m){
        if(m == n){
            for(int i = 0; i < visited.length; i++){
                if(visited[i])
                    System.out.print(i+1 + " ");
            }
            System.out.println();
            return;
        }

        visited[m] = true;
        dfs(m+1);
        visited[m] = false;
        dfs(m+1);
    }
}