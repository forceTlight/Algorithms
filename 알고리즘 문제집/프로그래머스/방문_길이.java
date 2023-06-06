package 프로그래머스;

import java.util.*;

class 방문_길이 {
    static class Node{
        int x;
        int y;
        int toX;
        int toY;
        
        public Node(int x, int y, int toX, int toY){
            this.x = x;
            this.y = y;
            this.toX = toX;
            this.toY = toY;
        }
        
        @Override
        public boolean equals(Object o){
            if(this == o)
                return true;
            
            if(!(o instanceof Node))
                return true;
            
            Node node = (Node) o;
            
            return (x == node.x && y == node.y && toX == node.toX && toY == node.toY) || (x == node.toX && y == node.toY && toX == node.x && toY == node.y); 
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x, y, toX, toY) + Objects.hash(toX, toY, x, y);
        }
    }
    
    public int solution(String dirs) {        
        Node node = new Node(5, 5, 5, 5);
        HashSet<Node> hashSet = new HashSet<>();

        int ans = 0;
        for(int i = 0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            
            int x = node.x;
            int y = node.y;
                        
            if(c == 'U'){
                x--;
            }else if(c == 'D'){
                x++;
            }else if(c == 'L'){
                y--;
            }else if(c == 'R'){
                y++;
            }
            
                    
            if(x >= 0 && x <= 10 && y >= 0 && y <= 10){
                hashSet.add(new Node(node.x, node.y, x, y));
                node.x = x;
                node.y = y;
            }
        }
        
        System.out.println(ans);
        
        return hashSet.size();
    }
}