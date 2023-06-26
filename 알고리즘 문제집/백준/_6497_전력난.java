package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _6497_전력난 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int weight;

        public Edge(int a, int b, int weight){
            this.a = a;
            this.b = b;
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

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0)
                break;

            unf = new int[m];
            for(int i = 0; i < m; i++)
                unf[i] = i;

            PriorityQueue<Edge> pq = new PriorityQueue<>();

            int originalSum = 0;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                pq.offer(new Edge(a, b, weight));
                originalSum += weight;
            }

            int sum = 0;
            while(!pq.isEmpty()){
                Edge edge = pq.poll();
                int a = edge.a;
                int b = edge.b;
                int weight = edge.weight;

                if(find(a) != find(b)){
                    union(a, b);
                    sum += weight;
                }
            }

            System.out.println(originalSum - sum);
        }
    }

    // a > b
    public static void union(int a, int b){
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        int fa = find(a);
        int fb = find(b);

        if(fa != fb){
            unf[fa] = fb;
        }
    }

    public static int find(int a){
        if(unf[a] == a)
            return a;

        return unf[a] = find(unf[a]);
    }
}