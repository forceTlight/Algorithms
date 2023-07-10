package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 4396 - 지뢰찾기
 * 문제유형 : 구현
 * 난이도 : SILVER 4
 * 풀이시간 : 30분
 */
public class _4396_지뢰_찾기 {
    static char[][] map;
    static char[][] answer;
    static int n;

    // 대각선 포함
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        answer = new char[n][n];

        for (char[] arr : answer)
            Arrays.fill(arr, '.');

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        boolean isOpenMine = false; // 지뢰가 있는 곳을 열었는지 체크

        // 사용자 지뢰게임 시작
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'x') {
                    if (openGrid(i, j))
                        isOpenMine = true;
                }
            }
        }

        // 지뢰 열었으면 모든 지뢰 열기
        if(isOpenMine) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        answer[i][j] = '*';
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean openGrid(int x, int y) {
        // 지뢰를 열었는지 검사
        if (map[x][y] == '*') {
            return true;
        }

        int mineCnt = 0;

        for (int i = 0; i < 8; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (a >= 0 && a < n && b >= 0 && b < n) {
                if (map[a][b] == '*') {
                    mineCnt++;
                }
            }
        }

        answer[x][y] = (char)(mineCnt + '0');
        return false;
    }
}