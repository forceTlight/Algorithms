package 프로그래머스;

import java.util.*;

class 미로_탈출 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] distance;
    
    public int solution(String[] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length()];
        distance = new int[maps.length][maps[0].length()];
        
        Node startNode = null;
        Node endNode = null;
        Node leverNode = null;
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                char c = maps[i].charAt(j);
                if(c == 'S'){
                    startNode = new Node(i, j);
                }else if(c == 'E'){
                    endNode = new Node(i, j);
                }else if(c == 'L'){
                    leverNode = new Node(i, j);
                }
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        
        // StartNode -> LeverNode
        loop:
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];
                
                if(a >= 0 && a < maps.length && b >= 0 && b < maps[0].length()){
                    if(!visited[a][b] && maps[a].charAt(b) != 'X'){
                        distance[a][b] = distance[x][y] + 1;
                        visited[a][b] = true;
                        
                         q.offer(new Node(a, b));
                        
                        if(maps[a].charAt(b) == 'L')
                            break loop;
                    }
                }
            }
        }
        
        // 레버 노드까지 갈 수 있는지 확인하기
        if(distance[leverNode.x][leverNode.y] == 0)
            return -1;
        
        // LeverNode -> EndNode
        visited = new boolean[maps.length][maps[0].length()];
        q.clear();
        q.offer(leverNode);
        
        loop2:
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];
                
                if(a >= 0 && a < maps.length && b >= 0 && b < maps[0].length()){
                    if(!visited[a][b] && maps[a].charAt(b) != 'X'){
                        distance[a][b] = distance[x][y] + 1;
                        visited[a][b] = true;
                        
                        q.offer(new Node(a, b));
                        
                        if(maps[a].charAt(b) == 'E')
                            break loop2;
                    }
                }
            }
        }
        
        // 출구 노드까지 갈 수 있는지 확인하기
        if(distance[endNode.x][endNode.y] == 0)
            return -1;
        
        answer = distance[endNode.x][endNode.y];
        // answer = distance[leverNode.x][leverNode.y];
        
        return answer;
    }
}