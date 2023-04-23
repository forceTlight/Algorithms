package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 원더랜드_프림 {
    static class Edge implements Comparable<Edge>{
        int v;
        int weight;

        public Edge(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }
    static ArrayList<ArrayList<Edge>> graph;
    static boolean[] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        int sum = 0;
        pq.offer(new Edge(1, 0));
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int v = edge.v;
            int weight = edge.weight;

            if(visited[v])
                continue;

            visited[v] = true;
            sum += weight;

            for(Edge e : graph.get(v)){
                if(!visited[e.v]){
                    pq.offer(e);
                }
            }
        }

        System.out.println(sum);
    }
}