package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _26_미로_탐색 {
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
    static int[][] answer;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        answer = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        // bfs
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];

                if(a >= 0 && a < n && b >= 0 && b < m && arr[a][b] == 1){
                    if(!visited[a][b]){
                        visited[a][b] = true;
                        answer[a][b] = answer[x][y] + 1;
                        q.offer(new Node(a, b));
                    }
                }
            }
        }

        System.out.println(answer[n-1][m-1] + 1);
    }
}