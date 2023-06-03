package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2075_N번째_큰수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // solution
        // 최소 값, 최댓 값 찾기
        List<Integer> candidateList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[n - 1][i] > max) {
                max = arr[n - 1][i];
            }

            if (arr[n - 1][i] < min) {
                min = arr[n - 1][i];
            }
        }
        loop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[n - 1 - j][i] >= min) {
                    candidateList.add(arr[n - 1 - j][i]);
                }
            }
        }

        Collections.sort(candidateList, Collections.reverseOrder());

        System.out.println(candidateList.get(n - 1));
    }
}
