package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {
    static public class Node{
        int v;
        int cost;

        Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    // 노드에 대한 정보를 담는 리스트
    static ArrayList<Node>[] graph;
    // 방문한 적이 있는지 체크하는 목적의 리스트
    static boolean[] visit;
    // 최단 거리 테이블
    static int[] dist;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        dist = new int[v+1];
        visit = new boolean[v+1];

        for(int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE; // 최대 값으로 초기화, 최단 거리를 찾기 위함
        }

        for(int i = 0; i < e; i++){
            // u -> v로 가는 가중치 w가 주어진다.
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[U].add(new Node(V, W));
        }

        // 기타.다익스트라 알고리즘 수행
        dijkstra(k);

        for(int i = 1; i <= v; i++){
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF": dist[i]);
        }
    }

    static void dijkstra(int start){
        // 우선 순위 큐 사용, 가중치 기준으로 오름차순
        PriorityQueue<Node> q =new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        // 시작 노드에 대해서 초기화
        q.add(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()){
            // 현재 최단거리가 가장 짧은 노드를 꺼내서 방문 처리
            Node now = q.poll();

            if(!visit[now.v]){
                visit[now.v] = true;
            }

            for(Node next : graph[now.v]){
                // 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을 경우
                if(!visit[next.v] && dist[next.v] > now.cost + next.cost){
                    dist[next.v] = now.cost + next.cost;
                    q.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}