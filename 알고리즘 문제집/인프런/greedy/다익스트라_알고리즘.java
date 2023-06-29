package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라_알고리즘 {
    static class Edge implements Comparable<Edge> {
        int node;
            int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return edge.distance - this.distance;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        graph = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        dikstra(1);

        for(int i = 1; i <= n; i++){
            if(dis[i] != Integer.MAX_VALUE){
                System.out.println(i + " " + dis[i]);
            }else{
                System.out.println(i + " INF");
            }
        }

    }

    public static void dikstra(int node) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(node, 0));
        dis[node] = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.node;
            int nowCost = edge.distance;

            if (nowCost > dis[now])
                continue;

            for (Edge ob : graph.get(now)) {
                if (dis[ob.node] > nowCost + ob.distance) {
                    dis[ob.node] = nowCost + ob.distance;
                    pq.offer(new Edge(ob.node, dis[ob.node]));
                }
            }
        }
    }
}