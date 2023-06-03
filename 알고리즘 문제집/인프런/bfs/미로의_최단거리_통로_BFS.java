package 인프런.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로의_최단거리_통로_BFS {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int[][] arr;
    public static boolean[][] visited;
    public static int[][] distance;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[8][8];
        visited = new boolean[8][8];
        distance = new int[8][8];

        for(int i = 1; i <= 7; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 7; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 1));
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int dis = distance[x][y];
            for(int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];

                if(a >= 1 && a <= 7 && b >= 1 && b <= 7){
                    if(!visited[a][b] && arr[a][b] == 0){
                        distance[a][b] = dis + 1;
                        visited[a][b] = true;

                        q.offer(new Node(a, b));
                    }
                }
            }
        }

        int answer = distance[7][7] == 0? -1: distance[7][7];
        System.out.println(answer);
    }
}
