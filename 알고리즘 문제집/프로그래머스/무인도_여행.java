package 프로그래머스;

import java.util.*;

class 무인도_여행 {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return x;
        }
        
        public int getY(){
            return y;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
        
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
        
        char[][] arr = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(arr[i][j] != 'X' && !visited[i][j]){
                    q.offer(new Node(i, j));
                    visited[i][j] = true;
                    int sum = arr[i][j] - '0';
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        int x = node.getX();
                        int y = node.getY();
                        for(int k = 0; k < 4; k++){
                            int a = x + dx[k];
                            int b = y + dy[k];
                            if(a >= 0 && a < maps.length && b >= 0 && b < maps[0].length()){
                                if(!visited[a][b] && arr[a][b] != 'X'){
                                    sum += arr[a][b] - '0';
                                    visited[a][b] = true;
                                    q.offer(new Node(a, b));
                                }
                            }
                        }
                    }
                
                    list.add(sum);
                }
            }
        }
        int[] answer;
        
        Collections.sort(list);
        
        if(list.size() <= 0){
            answer = new int[1];
            answer[0] = -1;
        }else{      
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++)
                answer[i] = list.get(i);
        }
        
        return answer;
    }
}