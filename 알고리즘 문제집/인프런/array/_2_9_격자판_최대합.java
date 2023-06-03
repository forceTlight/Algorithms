package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_9_격자판_최대합 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // sum
        int rowSum = 0; // 열
        int columnSum = 0; // 행
        int leftDSum = 0; // 좌측 대각선
        int rightDSum = 0; // 우측 대각선
        int max = 0;
        for(int i = 0; i < n; i++){
            rowSum = 0;
            columnSum = 0;
            for(int j = 0; j < n; j++){
                if(i == j)
                    rightDSum += arr[i][j];
                else if (j == (n-1) - i){
                    leftDSum += arr[i][j];
                }
                rowSum += arr[i][j];
                columnSum += arr[j][i];
            }
            max = Math.max(max, rowSum);
            max = Math.max(max, columnSum);

        }
        max = Math.max(max, leftDSum);
        max = Math.max(max, rightDSum);

        System.out.println(max);
    }
}
