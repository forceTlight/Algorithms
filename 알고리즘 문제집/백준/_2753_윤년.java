package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2753 - 윤년
 * 문제유형 : 구현
 * 난이도 : BRONZE 5
 * 풀이시간 : 1분
 */
public class _2753_윤년 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0)
            answer = 1;

        System.out.println(answer);
    }
}