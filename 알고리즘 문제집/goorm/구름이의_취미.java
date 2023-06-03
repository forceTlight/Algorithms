package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 구름이의_취미 {
    private static final int REMAIN = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());

        long sum = 0;
        sum = ((n * (n+1)) / 2) % REMAIN;
        System.out.println((sum * sum) % REMAIN);
    }
}