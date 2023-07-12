package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 17276 - 배열 돌리기
 * 문제유형 : 구현
 * 난이도 : SILVER 2
 * 풀이시간 : 30분
 */
public class _17276_배열_돌리기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];
            int[][] answer = new int[n][n];
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    answer[j][k] = arr[j][k];
                }
            }

            int rotate = 0;
            if(d >= 0){
                rotate = d / 45;
            }else{ // 음수이면 rotate = (360 - d) / 45;
                rotate = (360 + d) / 45;
            }

            // 45도 방향으로 회전
            for(int j = 0; j < rotate; j++){
                // 1. 주 대각선을 가운데 열(n+1)/2 로 옮긴다.
                int mid = (n+1)/2 - 1;
                for(int k = 0; k < n; k++){
                    answer[k][mid] = arr[k][k];
                }

                // 2. 가운데 열을 부 대각선으로 옮긴다.
                for(int k = 0; k < n; k++){
                    answer[k][n - 1 - k] = arr[k][mid];
                }

                // 3. 부 대각선을 가운데 행으로 옮긴다.
                for(int k = 0; k < n; k++){
                    answer[mid][k] = arr[n - 1 - k][k];
                }

                // 4. 가운데 행을 X의 주 대각선으로 옮긴다.
                for(int k = 0; k < n; k++){
                    answer[k][k] = arr[mid][k];
                }

                // 회전후 복사
                for(int k = 0; k < n; k++){
                    for(int l = 0; l < n; l++){
                        arr[k][l] = answer[k][l];
                    }
                }
            }

            // print
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    System.out.print(answer[j][k] + " ");
                }
                System.out.println();
            }
        }
    }
}