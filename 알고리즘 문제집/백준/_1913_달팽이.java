package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1913 - 달팽이
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 2시간
 */
public class _1913_달팽이 {
    static int n;
    static int[][] answer;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int posNum = Integer.parseInt(br.readLine());

        answer = new int[n][n];

        int x = 0;
        int y = 0;

        dfs(n/2, n/2, 1, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(answer[i][j] == posNum){
                    x = i + 1;
                    y = j + 1;
                }
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.print(x + " " + y);
    }

    public static void dfs(int a, int b, int num, int size){
        if(num > n * n)
            return;

        if(num == 1){
            answer[a][b] = num++;
        }else{
            for(int i = b+1; i < b + size - 1; i++)
                answer[a][i] = num++;

            for(int i = a; i < a + size - 1; i++)
                answer[i][b + size - 1] = num++;

            for(int i = b + size - 1; i > b; i--)
                answer[a + size - 1][i] = num++;

            for(int i = a + size - 1; i >= a; i--)
                answer[i][b] = num++;
        }

        dfs(a - 1, b - 1, num, size + 2);
    }
}