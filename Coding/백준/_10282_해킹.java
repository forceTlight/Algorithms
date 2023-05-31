package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _10282_해킹 {
    static class Edge implements Comparable<Edge>{
        int node;
        int time;

        public Edge(int node, int time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Edge e){
            return this.time - e.time;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static int[] times;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for(int j = 0; j <= n; j++)
                graph.add(new ArrayList<>());

            times = new int[n+1];

            Arrays.fill(times, Integer.MAX_VALUE);

            for(int j = 0; j < d; j++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int ts = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Edge(a, ts));
            }


            // 바이러스 퍼지게 하기
            dikstra(c);

            // 바이러스 갯수, 시간 조사
            int answer = 0;
            int time = 0;
            for(int j = 0; j <= n; j++){
                if(times[j] < Integer.MAX_VALUE){
                    answer++;
                    time = Math.max(times[j], time);
                }
            }

            System.out.println(answer + " " + time);
        }
    }

    public static void dikstra(int node){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(node ,0));
        times[node] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.node;
            int time = edge.time;

            if(times[now] < time)
                continue;

            for(Edge e : graph.get(now)){
                if(times[e.node] > time + e.time){
                    times[e.node] = time + e.time;
                    pq.offer(new Edge(e.node, times[e.node]));
                }
            }
        }
    }
}