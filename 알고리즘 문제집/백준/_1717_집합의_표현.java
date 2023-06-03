package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717_집합의_표현 {
    static int[] graph;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if (fa < fb) {
            graph[fb] = fa;
        } else {
            graph[fa] = fb;
        }
    }

    public static int find(int a) {
        if (graph[a] == a) {
            return a;
        }

        return graph[a] = find(graph[a]);
    }
}