package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 2578 - 빙고
 * 문제유형 : 구현
 * 난이도 : SILVER 4
 * 풀이시간 : 30분
 */
public class _2578_빙고 {
    static class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static HashMap<Integer, Point> hashMap;
    static int[][] bingo;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        hashMap = new HashMap<>();
        bingo = new int[5][5];
        for (int[] arr : bingo)
            Arrays.fill(arr, 1);

        // 빙고판 채우기
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                hashMap.put(num, new Point(i, j));
            }
        }

        // 사회자가 빙고 숫자 부르기
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                Point point = hashMap.get(num);
                int a = point.a;
                int b = point.b;

                bingo[a][b] = 0;

                if (isBingo()) {
                    System.out.println((i * 5) + (j+1));
                    return;
                }
            }
        }
    }

    public static boolean isBingo() {
        int bingoCnt = 0;

        // 수평 빙고
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 1) {
                    check = false;
                    break;
                }
            }
            if (check)
                bingoCnt++;
        }

        // 수직 빙고
        for (int i = 0; i < 5; i++) {
            boolean check = true;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 1) {
                    check = false;
                    break;
                }
            }
            if (check)
                bingoCnt++;
        }

        // 좌 -> 우 대각선 빙고
        boolean check = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 1) {
                check = false;
                break;
            }
        }

        if (check)
            bingoCnt++;

        // 우 -> 좌 대각선 빙고
        check = true;
        for (int i = 0; i < 5; i++) {
            if (bingo[4 - i][i] == 1) {
                check = false;
                break;
            }
        }

        if (check)
            bingoCnt++;

        return bingoCnt >= 3;
    }
}