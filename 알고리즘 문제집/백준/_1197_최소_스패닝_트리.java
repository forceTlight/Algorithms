package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1197_최소_스패닝_트리 {
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
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    static int[] unf;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        unf = new int[v + 1];
        for(int i = 1; i <= v; i++){
            unf[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(a, b, c));
        }

        int sum = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int a = edge.v1;
            int b = edge.v2;
            int weight = edge.weight;

            if(find(a) != find(b)){
                union(a, b);
                sum += weight;
            }
        }

        System.out.println(sum);
    }

    // a가 b보다 항상 크게끔
    public static void union(int a, int b){
        if(a < b){ // swap
            int tmp = a;
            a = b;
            b = tmp;
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