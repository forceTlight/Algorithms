package 인프런.dfs;

import java.util.*;
import java.io.*;

public class 미로_탐색_DFS {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int cnt = 0;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[7][7];
        visited = new boolean[7][7];
        for(int i = 0; i < 7; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 7; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        dfs(0, 0);

        System.out.println(cnt);
    }

    public static void dfs(int x, int y){
        if(x == 6 && y == 6){
            cnt++;
            return;
        }

        for(int i = 0; i < 4; i++){
            int a = x + dx[i];
            int b = y + dy[i];

            if(a >= 0 && a < 7 && b >= 0 && b < 7 && arr[a][b] == 0){
                if(!visited[a][b]){
                    visited[a][b] = true;
                    dfs(a, b);
                    visited[a][b] = false;
                }
            }
        }
    }
}