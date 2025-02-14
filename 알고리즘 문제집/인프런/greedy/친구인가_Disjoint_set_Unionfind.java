package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 친구인가_Disjoint_set_Unionfind {
    static int[] unf;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n+1];

        for(int i = 0; i <= n; i++)
            unf[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(find(a) == find(b))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa != fb)
            unf[fa] = fb;
    }

    public static int find(int v){
        if(v == unf[v])
            return v;
        else
            return unf[v] = find(unf[v]);
    }
}