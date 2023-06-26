package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class _2667_단지번호_붙이기 {
    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;
    static boolean[][] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                int a = input.charAt(j) - '0';
                arr[i][j] = a;
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    int cnt = 1;

                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        int x = node.a;
                        int y = node.b;

                        for (int k = 0; k < 4; k++) {
                            int a = x + dx[k];
                            int b = y + dy[k];

                            if (a >= 0 && a < n && b >= 0 && b < n) {
                                if (arr[a][b] == 1 && !visited[a][b]) {
                                    visited[a][b] = true;
                                    cnt++;
                                    q.offer(new Node(a, b));
                                }
                            }
                        }
                    }
                    answerList.add(cnt);
                }
            }
        }

        Collections.sort(answerList);

        System.out.println(answerList.size());
        for(int num : answerList)
            System.out.println(num);
    }
}