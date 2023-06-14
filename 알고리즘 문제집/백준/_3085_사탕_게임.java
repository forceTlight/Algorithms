package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3085_사탕_게임 {
    static int n;
    static char[][] arr;
    static int answer = 1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        // 좌, 우
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                tmpSwap(i, j, i, j + 1); // 좌, 우
                tmpSwap(j, i, j+1, i); // 상, 하
            }
        }

        System.out.println(answer);

//        // 상, 하
//        for(int i = 0; i < n - 1; i++){
//            for(int j = 0; j < n; j++){
//                tmpSwap(i, j, i + 1, j + 1);
//            }
//        }
    }

    public static void tmpSwap(int x1, int y1, int x2, int y2){
        // swap
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;

        // 검사
        // 좌, 우
        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n - 1; j++){
                if(arr[i][j] == arr[i][j+1]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }

        // 상, 하
        for(int i = 0; i < n; i++){
            int cnt = 1;
            for(int j = 0; j < n - 1; j++){
                if(arr[j][i] == arr[j+1][i]){
                    cnt++;
                }else{
                    cnt = 1;
                }

                answer = Math.max(answer, cnt);
            }
        }

        // swap 되돌리기
        char tmp2 = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp2;
    }
}