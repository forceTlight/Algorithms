package 프로그래머스;
// output: 강철부대가 복귀할 수 있는 최단시간

// input: 강철부대가 위치한 지역을 포함한 총 지역의 수 - n, 왕복할 수 있는 길 정보 담은 2차원 정수배열 - roads, 부대원이 위치한 서로 다른 지역을 나타내는 정수배열 sources, 강철부대의 지역 destination
// input-size: 3 <= n <= 100,000, 2 <= roads <= 500,000, 1 <= sources <= 500, 1 <= dstination <= n

// 문제 설명
import java.util.*;

class 부대_복귀 {

    static class Node{
        int edge;
        int weight;
        
        public Node(int edge, int weight){
            this.edge = edge;
            this.weight = weight;
        }
    }
    
    static int[] answer;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.answer = new int[sources.length];
        this.adj = new ArrayList[n+1];        
        
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        Queue<Node> q = new LinkedList<>();
        int distance[] = new int[n + 1];
        Arrays.fill(distance, 9999999);
        
        q.offer(new Node(destination, 0));
        visited = new boolean[n + 1];
        
        while(!q.isEmpty()){
            Node node = q.poll();
            int edge = node.edge;
            int weight = node.weight;
            
            if(weight < distance[edge]){
                distance[edge] = weight;
            }
            
            for(int e : adj[edge]){
                if(!visited[e]){
                    visited[e] = true;
                    q.offer(new Node(e, weight + 1));
                }
            }
        }
        
        for(int i = 0; i < sources.length; i++){
            int edge = sources[i];
            
            if(edge == destination){
                answer[i] = 0;
            }else{
                if(distance[edge] == 9999999)
                    answer[i] = -1;
                else
                    answer[i] = distance[edge];
            }            
        }
        
        return answer;
    }
}