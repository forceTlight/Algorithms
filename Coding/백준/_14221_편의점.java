package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14221_편의점 {
    static class Edge implements Comparable<Edge> {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge e) {
            return this.distance - e.distance;
        }
    }

    static int[] dis;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dis = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());

        int house_num = Integer.parseInt(st.nextToken());
        int store_num = Integer.parseInt(st.nextToken());

        int[] houses = new int[house_num];
        int[] stores = new int[store_num];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            stores[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        int answer_distance = Integer.MAX_VALUE;

        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < store_num; i++) {
            int store = stores[i];

            dikstra(store);

            // 최소 거리 비교
            for (int j = 0; j < house_num; j++) {
                int house = houses[j];
                if (dis[house] <= answer_distance) {
                    if (dis[house] == answer_distance && house >= answer) { // 거리가 같은데 정점 번호가 클 경우
                        continue;
                    }

                    answer = house;
                    answer_distance = dis[house];
                }
            }
        }

        System.out.println(answer);
    }

    public static void dikstra(int node) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(node, 0));
        dis[node] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.node;
            int nowCost = edge.distance;

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