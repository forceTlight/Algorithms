package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 2615 - 오목
 * 문제유형 : 구현
 * 난이도 : SILVER 1
 * 풀이시간 : 1시간
 */
public class _2615_오목 {
    static class Node {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static Queue<Node> q;

    static int[] heightDx = {-1, 1}; // 세로
    static int[] heightDy = {0, 0};

    static int[] widthDx = {0, 0}; // 가로
    static int[] widthDy = {-1, 1};

    static int[] dig1Dx = {1, -1}; // 주대각선
    static int[] dig1Dy = {1, -1};

    static int[] dig2Dx = {1, -1}; // 부대각선
    static int[] dig2Dy = {-1, 1};

    static int[][] arr;
    static boolean[][] visited;
    static final int LENGTH = 19;

    static int winTeam = 0;
    static int answerX = 999;
    static int answerY = 999;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new LinkedList<>();

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (arr[i][j] != 0) {
                    checkDig1(i, j);
                    checkDig2(i, j);
                    checkHeight(i, j);
                    checkWidth(i, j);
                }
            }
        }


        if(winTeam != 0){
            System.out.println(winTeam);
            System.out.println((answerX+1) + " " + (answerY+1));
        }else{ // 승부가 결정 안났을시
            System.out.println(0);
        }

    }

    // 주 대각선 검사
    public static boolean checkDig1(int a, int b) {
        int cnt = 0;
        visited = new boolean[LENGTH][LENGTH];
        q.offer(new Node(a, b));
        visited[a][b] = true;
        while (!q.isEmpty()) {
            cnt++;
            Node node = q.poll();
            int x = node.a;
            int y = node.b;
            for (int i = 0; i < 2; i++) {
                int aa = x + dig1Dx[i];
                int bb = y + dig1Dy[i];

                if (aa >= 0 && aa < LENGTH && bb >= 0 && bb < LENGTH && !visited[aa][bb]) {
                    if (arr[x][y] == arr[aa][bb]) {
                        q.offer(new Node(aa, bb));
                        visited[aa][bb] = true;
                    }
                }
            }
        }
        if (cnt == 5) {
            winTeam = arr[a][b];
            if(b < answerY){
                answerX = a;
                answerY = b;
            }
        }

        return cnt == 5;
    }

    // 부 대각선 검사
    public static boolean checkDig2(int a, int b) {
        int cnt = 0;
        visited = new boolean[LENGTH][LENGTH];
        q.offer(new Node(a, b));
        visited[a][b] = true;
        while (!q.isEmpty()) {
            cnt++;
            Node node = q.poll();
            int x = node.a;
            int y = node.b;
            for (int i = 0; i < 2; i++) {
                int aa = x + dig2Dx[i];
                int bb = y + dig2Dy[i];

                if (aa >= 0 && aa < LENGTH && bb >= 0 && bb < LENGTH && !visited[aa][bb]) {
                    if (arr[x][y] == arr[aa][bb]) {
                        q.offer(new Node(aa, bb));
                        visited[aa][bb] = true;
                    }
                }
            }
        }
        if (cnt == 5) {
            winTeam = arr[a][b];
            if(b < answerY){
                answerX = a;
                answerY = b;
            }
        }

        return cnt == 5;
    }

    // 가로 검사
    public static boolean checkWidth(int a, int b) {
        int cnt = 0;
        visited = new boolean[LENGTH][LENGTH];
        q.offer(new Node(a, b));
        visited[a][b] = true;
        while (!q.isEmpty()) {
            cnt++;
            Node node = q.poll();
            int x = node.a;
            int y = node.b;
            for (int i = 0; i < 2; i++) {
                int aa = x + widthDx[i];
                int bb = y + widthDy[i];

                if (aa >= 0 && aa < LENGTH && bb >= 0 && bb < LENGTH && !visited[aa][bb]) {
                    if (arr[x][y] == arr[aa][bb]) {
                        q.offer(new Node(aa, bb));
                        visited[aa][bb] = true;
                    }
                }
            }
        }
        if (cnt == 5) {
            winTeam = arr[a][b];
            if(b < answerY){
                answerX = a;
                answerY = b;
            }
        }

        return cnt == 5;
    }

    // 세로 검사
    public static boolean checkHeight(int a, int b) {
        int cnt = 0;
        visited = new boolean[LENGTH][LENGTH];
        q.offer(new Node(a, b));
        visited[a][b] = true;
        while (!q.isEmpty()) {
            cnt++;
            Node node = q.poll();
            int x = node.a;
            int y = node.b;
            for (int i = 0; i < 2; i++) {
                int aa = x + heightDx[i];
                int bb = y + heightDy[i];

                if (aa >= 0 && aa < LENGTH && bb >= 0 && bb < LENGTH && !visited[aa][bb]) {
                    if (arr[x][y] == arr[aa][bb]) {
                        q.offer(new Node(aa, bb));
                        visited[aa][bb] = true;
                    }
                }
            }
        }
        if (cnt == 5) {
            winTeam = arr[a][b];
            if(b < answerY){
                answerX = a;
                answerY = b;
            }
        }

        return cnt == 5;
    }
}