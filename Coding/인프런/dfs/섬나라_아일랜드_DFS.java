package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬나라_아일랜드_DFS {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[] ddx = {-1, -1, 1, 1}; // 대각선
    static int[] ddy = {-1, 1, -1, 1}; // 대각선
    static int answer = 0;
    static boolean[][] visited;
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
    public static void dfs(int x, int y){
        // 상, 하, 좌, 우
        for(int i = 0; i < 4; i++){
            int a = x + dx[i];
            int b = y + dy[i];

            if(a >= 0 && a < n && b >= 0 && b < n){
                if(!visited[a][b] && arr[a][b] == 1){
                    visited[a][b] = true;
                    dfs(a, b);
                }
            }
        }

        // 대각선
        for(int i = 0; i < 4; i++){
            int a = x + ddx[i];
            int b = y + ddy[i];

            if(a >= 0 && a < n && b >= 0 && b < n){
                if(!visited[a][b] && arr[a][b] == 1){
                    visited[a][b] = true;
                    dfs(a, b);
                }
            }
        }
    }
}
