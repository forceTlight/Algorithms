package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class _1946_신입_사원 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int t = Integer.parseInt(br.readLine());
        int[] cnt = new int[t];

        for (int i = 0; i < t; i++) {
            map.clear();
            int n = Integer.parseInt(br.readLine());
            int document[] = new int[n];
            int review[] = new int[n];

            // input
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                document[j] = Integer.parseInt(input[0]);
                review[j] = Integer.parseInt(input[1]);
                map.put(document[j], review[j]);
            }

            // process
            int min = map.get(1);
            for (Map.Entry entry : map.entrySet()) {
                int key = (int) entry.getKey();
                int value = (int) entry.getValue();
                if (min >= value) {
                    cnt[i]++;
                    min = value;
                }
            }
        }

        // result
        for (int i = 0; i < t; i++)
            System.out.println(cnt[i]);
    }

    public static boolean solution(TreeMap<Integer, Integer> map, int ds, int rs) {


        for (Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if (key == ds)
                continue;

            if (key < ds)
                if (value < rs)
                    return false;
        }
        return true;
    }
}
