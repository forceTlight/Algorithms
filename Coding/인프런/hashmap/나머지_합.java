package 인프런.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 나머지_합 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        long[] s = new long[n + 1];
        HashMap<Long, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            s[i] = (s[i - 1] + arr[i]) % m;

            map.put(s[i], map.getOrDefault(s[i], 0) + 1);
        }

        long answer = 0;
        for (long key : map.keySet()) {
            int num = map.get(key);
            answer += ((long) num * (num - 1) / 2);
        }

        System.out.println(answer + map.getOrDefault(0L, 0));
    }
}