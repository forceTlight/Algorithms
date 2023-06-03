package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_12_멘토링 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int cnt = 0;
                for(int k = 0; k < m; k++){
                    int pi = 0, pj = 0;
                    for(int l = 0; l < n; l++){
                        if(arr[k][l] == i+1) pi = l;
                        if(arr[k][l] == j+1) pj = l;
                    }
                    if(pi > pj)
                        cnt++;
                }
                if(cnt == m)
                    answer ++;
            }
        }


        System.out.println(answer);
    }
}
