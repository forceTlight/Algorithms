package 프로그래머스;

import java.util.*;

class 리코쳇_로봇 {
    static class Node{
        int a;
        int b;
        
        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static boolean[][] visited;
    static int[][] distance;
    
    public int solution(String[] board) {        
        visited = new boolean[board.length][board[0].length()];
        distance = new int[board.length][board[0].length()];
        
        Node startNode = null;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length(); j++){
                if(board[i].charAt(j) == 'R'){
                    startNode = new Node(i, j);
                    visited[i][j] = true;
                    break;
                }
            }
        }

        ArrayList<Integer> test = new ArrayList<>();
        test.remove(Integer.valueOf(1));
        
        Queue<Node> q = new LinkedList<>();
        q.offer(startNode);
        
        int answer = -1;
        
        loop:
        while(!q.isEmpty()){
            Node node = q.poll();
            int a = node.a;
            int b = node.b;
            
            for(int i = 0; i < 4; i++){
                int x = a;
                int y = b;
                while(x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < board.length  && y + dy[i] < board[0].length()  && board[x + dx[i]].charAt(y + dy[i]) != 'D'){
                    x += dx[i];
                    y += dy[i];
                }
                
                if(!visited[x][y]){
                    visited[x][y] = true;
                    
                    distance[x][y] = distance[a][b] + 1;
                    
                    if(board[x].charAt(y) == 'G'){
                        answer = distance[x][y];
                        break loop;
                    }
                    
                    q.offer(new Node(x, y));
                }
            }
        }
        
        return answer;
    }
}