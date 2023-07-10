package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5597 - 과제 안내신 분..?
 * 문제유형 : 구현
 * 난이도 : BRONZE 5
 * 풀이시간 : 3분
 */
public class _5597_과제_안내신_분 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] students = new int[31];
        for(int i = 0; i < 28; i++){
            int num = Integer.parseInt(br.readLine());
            students[num] = 1;
        }

        for(int i = 1; i <= 30; i++){
            if(students[i] == 0)
                System.out.println(i);
        }
    }
}