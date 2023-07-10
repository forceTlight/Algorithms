package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1212 - 8진수, 2진수
 * 문제유형 : 구현
 * 난이도 : BRONZE 2
 * 풀이시간 : 15분
 */
public class _1212_8진수_2진수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        // 수가 0이면 0출력
        if (input.equals("0")) {
            System.out.println(0);
            return;
        }

        char[] numbers = input.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i] - '0';
            String binaryString = toBinaryString(num);
            sb.append(binaryString);
        }

        // 처음 0부터 시작하면 제외
        while (sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        System.out.println(sb);
    }

    public static String toBinaryString(int octNumber) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            if (octNumber > 0) {
                int remainder = octNumber % 2;
                octNumber /= 2;
                sb.insert(0, remainder);
            } else {
                sb.insert(0, 0);
            }
        }

        return sb.toString();
    }
}