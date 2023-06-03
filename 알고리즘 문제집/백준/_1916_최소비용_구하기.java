package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_최소비용_구하기 {
    static class Edge implements Comparable<Edge>{
        int node;
        int distance;

        public Edge(int node, int distance){
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge e){
            return this.distance - e.distance;
        }
    }

    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dis = new int[n+1];
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dikstra(start);
        System.out.println(dis[end]);
    }

    public static void dikstra(int node){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(node, 0));
        dis[node] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.node;
            int nowCost = edge.distance;

            if(nowCost > dis[now])
                continue;

            for(Edge e : graph.get(now)){
                if(dis[e.node] > nowCost + e.distance){
                    dis[e.node] = nowCost + e.distance;
                    pq.offer(new Edge(e.node, dis[e.node]));
                }
            }
        }
    }
}