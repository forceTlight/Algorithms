package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17396_백도어 {
    static class Edge implements Comparable<Edge> {
        int node;
        long distance;

        public Edge(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance < e.distance? -1 : 1;
        }
    }

    static int[] status;
    static long[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    static int n;
    static int m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dis = new long[n];
        status = new int[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            status[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if ((a != n - 1 && status[a] == 1) || (b != n - 1 && status[b] == 1))
                continue;

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        dikstra(0);

        if (dis[n - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dis[n - 1]);
        }
    }

    public static void dikstra(int node) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(node, 0));
        dis[node] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.node;
            long nowCost = edge.distance;

            if (dis[now] < nowCost)
                continue;

            for (Edge e : graph.get(now)) {
                if (dis[e.node] > nowCost + e.distance) {
                    dis[e.node] = nowCost + e.distance;
                    pq.offer(new Edge(e.node, dis[e.node]));
                }
            }
        }
    }
}