package 인프런.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_BFS {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;
    static boolean[][] visited;
    static int[][] day;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        day = new int[n][m];

        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1){
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        if(q.isEmpty()){
            System.out.println(0);
            return;
        }

        int answer = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int d = day[x][y];

            for(int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];

                if(a >= 0 && a < n && b >= 0 && b < m){
                    if(!visited[a][b] && arr[a][b] != -1){
                        visited[a][b] = true;
                        day[a][b] = d + 1;
                        q.offer(new Node(a, b));
                    }
                }
            }
        }

        // 토마토가 모두 익었는지, 토마토가 모두 익은 날은 언제인지 동시에 검사
        loop:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] != -1){
                    answer = -1;
                    break loop;
                }

                answer = Math.max(answer, day[i][j]);
            }
        }

        System.out.println(answer);
    }
}