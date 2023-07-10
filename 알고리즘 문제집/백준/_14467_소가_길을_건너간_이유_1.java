package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 14467 - 소가 길을 건너간 이유 1
 * 문제유형 : 구현
 * 난이도 : BRONZE 1
 * 풀이시간 : 5분
 */
public class _14467_소가_길을_건너간_이유_1 {
    static boolean[] bulbs;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int status = Integer.parseInt(st.nextToken());

            if (hashMap.containsKey(num)) {
                int prevStatus = hashMap.get(num);
                if (prevStatus != status)
                    answer++;
            }
            hashMap.put(num, status);
        }

        System.out.println(answer);
    }
}