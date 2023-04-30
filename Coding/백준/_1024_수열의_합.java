package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1024_수열의_합 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = l; i <= 100; i++) {
            double a = (double) (n - ((i - 1) * i / 2)) / i;

            if (a < 0)
                break;

            // 정수형이 아닐 경우
            if (a % 1 != 0.0)
                continue;

            for (int j = 0; j <= i - 1; j++) {
                list.add((int) a + j);
            }
            break;
        }

        if (!list.isEmpty()) {
            list.forEach(e -> System.out.print(e + " "));
        } else {
            System.out.println(-1);
        }
    }
}