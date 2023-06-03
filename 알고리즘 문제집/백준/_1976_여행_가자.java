package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976_여행_가자 {
    static int[] graph;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n+1];

        for(int i = 1; i <= n; i++)
            graph[i] = i;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    union(i+1, j+1);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = graph[Integer.parseInt(st.nextToken())];
        for(int i = 1; i < m ; i++){
            if(tmp != graph[Integer.parseInt(st.nextToken())]){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa > fb){
            graph[fa] = fb;
        }else{
            graph[fb] = fa;
        }
    }

    public static int find(int a){
        if(graph[a] == a)
            return a;

        return graph[a] = find(graph[a]);
    }
}