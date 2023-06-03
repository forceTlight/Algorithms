package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진_변환_반복하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int cnt = 0;
        int sum = 0;
        while (!input.equals("1")) {
            String tmp = input;
            input = input.replaceAll("0", "");
            sum += tmp.length() - input.length();

            input = Integer.toBinaryString(input.length());

            cnt++;
        }

        System.out.println(cnt + "," + sum);
    }
}