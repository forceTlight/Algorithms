package 프로그래머스;

import java.util.*;

class 전력망을_둘로_나누기 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        adj = new ArrayList[n+1];
        
        for(int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        for(int i = 0; i < wires.length; i++){
            visited = new boolean[n+1];
            int a = wires[i][0];
            int b = wires[i][1];
            
            adj[a].remove(Integer.valueOf(b));
            adj[b].remove(Integer.valueOf(a));
            
            dfs(1);
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(visited[j])
                    cnt++;
            }
            
            int diff = n - cnt;
            answer = Math.min(answer, Math.abs(diff - cnt));
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        return answer;
    }
    
    public void dfs(int n){
        for(int node: adj[n]){
            if(!visited[node]){
                visited[node] = true;
                dfs(node);
            }
        }
    }
}