package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 원더랜드_크루스칼 {
    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int weight;

        public Edge(int v1, int v2, int weight){
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }

    static int[] unf;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        unf = new int[n+1];

        for(int i = 1; i <= n; i++)
            unf[i] = i;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(a, b, weight));
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            int v1 = edge.v1;
            int v2 = edge.v2;

            if(find(v1) != find(v2)){
                union(v1, v2);
                sum += edge.weight;
            }
        }

        System.out.println(sum);
    }

    public static void union(int a, int b){
        if(a > b){
            int tmp = b;
            b = a;
            a = tmp;
        }

        int fa = find(a);
        int fb = find(b);

        if(fa != fb)
            unf[fa] = fb;
    }

    public static int find(int a){
        if(unf[a] == a)
            return a;
        else
            return unf[a] = find(unf[a]);
    }
}