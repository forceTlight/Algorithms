package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1245_농장_관리 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; // 대각선 포함
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1}; // 대각선 포함
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        Queue<Node> mq = new LinkedList<>();

        int answer = 0;


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                boolean check = false;

                // 인접한 산봉우리 mq에다가 집어 넣음
                if(!visited[i][j]){
                    visited[i][j] = true;
                    q.offer(new Node(i, j));
                    mq.offer(new Node(i, j));

                    while(!q.isEmpty()){
                        Node node = q.poll();
                        int a = node.x;
                        int b = node.y;

                        for(int k = 0; k < 8; k++){
                            int x = a + dx[k];
                            int y = b + dy[k];

                            if(x >= 0 && x < n && y >= 0 && y < m){
                                if(!visited[x][y] && arr[a][b] == arr[x][y]){
                                    q.offer(new Node(x, y));
                                    mq.offer(new Node(x, y));
                                    visited[x][y] = true;
                                }
                            }
                        }
                    }
                }

                loop:
                while(!mq.isEmpty()){
                    check = true;
                    Node node = mq.poll();
                    int a = node.x;
                    int b = node.y;

                    for(int k = 0; k < 8; k++){
                        int x = a + dx[k];
                        int y = b + dy[k];

                        if(x >= 0 && x < n && y >= 0 && y < m){
                            if(arr[i][j] - arr[x][y] < 0) {
                                mq.clear();
                                check = false;
                                break loop;
                            }
                        }
                    }
                }

                if(check)
                    answer++;
            }
        }


        System.out.println(answer);
    }
}