import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
    백준 - 감소하는 수
    1038번
 */
public class Main {
    static final int SIZE = 10000000;
    static ArrayList<Long> list = new ArrayList<>();
    static int n;
    static int cnt = 0;
    static boolean[] visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[10];
        for (int i = 1; i <= 10; i++) {
            dfs(9, i, 0, new StringBuilder());
        }
        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        System.out.println(list.size());
        if(n >= list.size()){
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(n));
    }

    public static void dfs(int idx, int digit, int cnt, StringBuilder sb) {
        if (cnt == digit) {
            sb.setLength(0);
            for (int i = visited.length - 1; i >= 0; i--) {
                if (visited[i]) {
                    sb.append(i);
                }
            }
            Long num = Long.parseLong(sb.toString());
            if (!list.contains(num)) {
                list.add(num);
            }
            return;
        }
        for (int i = idx; i >= 0; i--) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(idx - 1, digit, cnt + 1, sb);
                visited[i] = false;
            }
        }
    }
}
