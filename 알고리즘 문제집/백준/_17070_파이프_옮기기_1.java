package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [백준] - 파이프 옮기기 1
 *  알고리즘 유형 : BFS
 */
public class _17070_파이프_옮기기_1 {
    static class Node {
        int a;
        int b;
        int status; // 0 - 세로, 1 - 가로, 2 - 대각선

        public Node(int a, int b, int status) {
            this.a = a;
            this.b = b;
            this.status = status;
        }
    }

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static int[][] arr;
    static int[][] answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최종 목적지에 벽이 있으면 0을 리턴
        if(arr[n - 1][n - 1] == 1){
            System.out.println(0);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 1));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.a;
            int y = node.b;
            int status = node.status;

            for (int i = 0; i < 3; i++) {
                int a = x + dx[i];
                int b = y + dy[i];

                // 세로 - 가로, 가로 - 세로이면 파이프 연결 못함
                if ((status == 0 && i == 1) || (status == 1 && i == 0))
                    continue;

                if (a >= 0 && a < n && b >= 0 && b < n) {
                    if (arr[a][b] == 0) {
                        // 대각선일 경우 벽에 긁히는지 검사
                        if(i == 2){
                            if(arr[a - 1][b] == 1 || arr[a][b - 1] == 1)
                                continue;
                        }
                        answer[a][b]++;
                        q.offer(new Node(a, b, i));
                    }
                }
            }
        }

        System.out.println(answer[n - 1][n - 1]);
    }
}