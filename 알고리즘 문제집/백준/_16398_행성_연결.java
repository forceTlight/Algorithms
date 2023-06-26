package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// N * N 행렬을 받는다, 행렬에 들어있는 값은 i, j의 플로우를 의미한다.
// 플로우 값을 통해 MST를 구현하고, sum 값을 반환하면 답이 나온다.
public class _16398_행성_연결 {
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
        int n = Integer.parseInt(br.readLine());
        unf = new int[n];

        for(int i = 0; i < n; i++)
            unf[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++){
                int weight = Integer.parseInt(st.nextToken());
                if(i == j)
                    continue;
                pq.offer(new Edge(i, j, weight));
            }
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int a = edge.a;
            int b = edge.b;
            int weight = edge.weight;

            if(find(a) != find(b)){
                union(a, b);
                sum += weight;
            }
        }

        System.out.println(sum);
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