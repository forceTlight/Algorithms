package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _006_연속된_자연수의_합_구하기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n / 2 + 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i + 1;

        int lt = 0;
        int sum = 0;
        int answer = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];

            while (sum >= n && lt < rt) {
                if (sum == n)
                    answer++;

                sum -= arr[lt++];
            }
        }

        System.out.println(answer+1);
    }
}