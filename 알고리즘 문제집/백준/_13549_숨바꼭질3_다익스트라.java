package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 13549 - 숨바꼭질3
 * 문제유형 : 다익스트라
 * 난이도 : GOLD5
 * 풀이시간 : 20분
 * 주의사항 : BFS는 가중치가 다른 간선의 최솟값을 구하지 못한다. (모든 가중치가 동일해야 함), 만약 가중치가 다른경우 다익스트라로 풀어야한다.
 */
public class _13549_숨바꼭질3_다익스트라 {
    static class Edge implements Comparable<Edge>{
        int node;
        int time;

        public Edge(int node, int time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Edge edge){
            return this.time - edge.time;
        }
    }

    static int[] dis;
    static ArrayList<Edge>[] adj;
    static int answer = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        dis = new int[100001];
        Arrays.fill(dis, 100001);
        adj = new ArrayList[100001];
        for(int i = 0; i <= 100000; i++)
            adj[i] = new ArrayList<>();

        dijkstra(a, b);
        System.out.println(answer);
    }

    public static void dijkstra(int start, int end){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.node;
            int nowTime = edge.time;

            if(now == end){
                answer = nowTime;
                break;
            }

            for(int i = 0; i < 3; i++){
                int node = now;
                int time = nowTime;
                if(i == 0){
                    node = now * 2;
                }else if(i == 1){
                    node++;
                    time++;
                }else{
                    node--;
                    time++;
                }

                if(node >= 0 && node <= 100000)
                    adj[now].add(new Edge(node, time));
            }

            if(dis[now] < nowTime)
                continue;

            for(Edge e : adj[now]){
                if(e.time < dis[e.node]){
                    dis[e.node] = e.time;
                    pq.offer(new Edge(e.node, dis[e.node]));
                }
            }
        }
    }
}