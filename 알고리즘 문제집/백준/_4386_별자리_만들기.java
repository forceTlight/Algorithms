package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1. 별들의 좌표 평면을 입력 받는다.
// 2. 입력을 모두 받은 후에, 각 별들의 거리를 구해서 그래프에 넣는다.
// 3. 프림 알고리즘으로 MST를 구해서 별자리를 만드는 최소 비용을 구한다.
public class _4386_별자리_만들기 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        double weight;

        public Edge(int a, int b, double weight){
            this.a = a;
            this.b =b ;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return Double.compare(this.weight, edge.weight);
        }
    }

    static int[] unf;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double[][] arr = new double[n][n];
        unf = new int[n];
        for(int i = 0; i < n; i++)
            unf[i] = i;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                arr[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            double a = arr[i][0];
            double b = arr[i][1];
            for(int j = i + 1; j < n; j++){
                if(i == j)
                    continue;

                double x = arr[j][0];
                double y = arr[j][1];

                double dis = Math.sqrt(Math.pow(y - b, 2) + Math.pow(x - a, 2));
                pq.offer(new Edge(i, j, dis));
            }
        }

        double sum = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int a = edge.a;
            int b = edge.b;
            double weight = edge.weight;

            if(find(a) != find(b)){
                union(a, b);
                sum += weight;
            }
        }

        sum = (int) (sum * 100) / 100.0;

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
        if(a == unf[a])
            return a;

        return unf[a] = find(unf[a]);
    }
}