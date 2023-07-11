package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 10094 - 별찍기 - 19
 * 문제유형 : 구현, 재귀
 * 난이도 : SILVER 4
 * 풀이시간 : 10분
 */
public class _10094_별찍기_19 {
    static char[][] answer;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = 1 + (n-1) * 4;

        answer = new char[size][size];
        for(char[] ans : answer)
            Arrays.fill(ans, ' ');

        createStar(size, 0, 0);

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(answer[i][j]);
            }

            System.out.println();
        }
    }

    public static void createStar(int size, int a, int b){ // a는 별이 시작되는 세로, b는 별이 시작되는 가로
        if(size <= 0)
            return;

        for(int i = 0; i < size; i++){
            // 가로
            answer[a][b+i] = '*';
            answer[a+size-1][b+i] = '*';

            // 세로
            answer[a+i][b] = '*';
            answer[a+i][b+size-1] = '*';
        }

        createStar(size - 4, a + 2, b + 2);
    }
}