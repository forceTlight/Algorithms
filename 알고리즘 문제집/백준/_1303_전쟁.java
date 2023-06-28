package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1303 - 전쟁
 * 문제유형 : BFS
 * 난이도 : Silver 1
 * 풀이시간 : 10분
 */
public class _1303_전쟁 {
    static class Node{
        int a;
        int b;

        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        int whiteNum = 0;
        int blueNum = 0;

        char[][] arr = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j]){
                    int cnt = 1;
                    char team = arr[i][j];

                    q.offer(new Node(i, j));
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        Node node = q.poll();
                        int x = node.a;
                        int y = node.b;

                        for(int k = 0; k < 4; k++){
                            int a = x + dx[k];
                            int b = y + dy[k];

                            if(a >= 0 && a < n && b >= 0 && b < m){
                                if(arr[a][b] == team && !visited[a][b]){
                                    visited[a][b] = true;
                                    cnt++;
                                    q.offer(new Node(a, b));
                                }
                            }
                        }
                    }

                    if(team == 'W'){
                        whiteNum += (cnt*cnt);
                    }else{
                        blueNum += (cnt*cnt);
                    }
                }
            }
        }

        System.out.println(whiteNum);
        System.out.println(blueNum);
    }
}