package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 16926 - 배열 돌리기 1
 * 문제유형 : 구현
 * 난이도 : SILVER 1
 * 풀이시간 : 1시간
 */
public class _16926_배열_돌리기_1 {
    static int[][] arr;
    static int[][] tmpArr;
    static int n;
    static int m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tmpArr = new int[n][m];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    tmpArr[j][k] = arr[j][k];
                }
            }

            dfs(0, n - 1, 0, m - 1);

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int a1, int a2, int b1, int b2) {
        if (((a2 - a1 <= 0) && (b2 - b1) <= 0) || (a2 - a1) < 0 || (b2 - b1) < 0)
            return;

        // 위 가로
        for (int i = b1; i < b2; i++) {
            arr[a1][i] = tmpArr[a1][i + 1];
        }

        // 아래 세로
        for (int i = a1; i < a2; i++) {
            arr[i + 1][b1] = tmpArr[i][b1];
        }

        // 아래 가로
        for (int i = b1; i < b2; i++) {
            arr[a2][i + 1] = tmpArr[a2][i];
        }

        // 위 세로
        for (int i = a1; i < a2; i++) {
            arr[i][b2] = tmpArr[i+1][b2];
        }

        dfs(a1 + 1, a2 - 1, b1 + 1, b2 - 1);
    }
}