import java.io.*;

public class Main {
    static String[][] boom;
    static String[][] board;
    static int n;
    static boolean boomFlag = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        boom = new String[n][n];
        board = new String[n][n];
        // boom
        for (int i = 0; i < n; i++) {
            String t[] = br.readLine().split("");
            for (int j = 0; j < t.length; j++) {
                boom[i][j] = t[j];
            }
        }
        // input
        for (int i = 0; i < n; i++) {
            String t[] = br.readLine().split("");
            sb.setLength(0);
            for (int j = 0; j < t.length; j++) {
                if (t[j].equals("x")) {
                    int bomb_cnt = searchBomb(i, j);
                    board[i][j] = String.valueOf(bomb_cnt);
                } else {
                    board[i][j] = ".";
                }
            }
        }
        // 폭탄 열었을 때 처리
        if (boomFlag) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (boom[i][j].equals("*")) {
                        board[i][j] = "*";
                    }
                }
            }
        }
        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int searchBomb(int a, int b) {
        int cnt = 0;
        if (boom[a][b].equals("*")) {
            boomFlag = true;
            return -1;
        }
        for (int i = a - 1; i <= a + 1; i++) {
            for (int j = b - 1; j <= b + 1; j++) {
                if (i < 0 || j < 0 || i >= n || j >= n) {
                    continue;
                }
                if (boom[i][j].equals("*")) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
