package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1743 - 음식물 피하기
 * 문제유형 : BFS
 * 난이도 : Silver 1
 * 풀이시간 : 10분
 */
public class _1743_음식물_피하기 {
    static class Node{
        int a;
        int b;

        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = 1;
        }

        Queue<Node> q = new LinkedList<>();
        int answer = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    int size = 1;
                    q.offer(new Node(i, j));
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        int x = node.a;
                        int y = node.b;

                        for(int l = 0; l < 4; l++){
                            int a = x + dx[l];
                            int b = y + dy[l];

                            if(a >= 0 && a < n && b >= 0 && b < m){
                                if(arr[a][b] == 1 && !visited[a][b]){
                                    visited[a][b] = true;
                                    size++;
                                    q.offer(new Node(a, b));
                                }
                            }
                        }
                    }

                    answer = Math.max(answer, size);
                }
            }
        }

        System.out.println(answer);
    }
}