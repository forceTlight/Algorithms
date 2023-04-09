package 프로그래머스;

import java.util.*;

class 호텔_대실 {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public int getStart(){
            return start;
        }
        public int getEnd(){
            return end;
        }
        
        @Override
        public int compareTo(Node node){
            return this.start - node.start;
        }
    }
    public int solution(String[][] book_time) {        
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < book_time.length; i++){
            int start = convertToMinute(book_time[i][0]);
            int end = convertToMinute(book_time[i][1]);
            list.add(new Node(start, end));
        }
        
        Collections.sort(list);
        LinkedList<Node> linkedList = new LinkedList<>();
        int max = 0;
        
        for(int i = 0; i < list.size(); i++){
            Node node = list.get(i);
            
            Node deleteNode = null;
            for(Node n : linkedList){
                if(n.getEnd() + 10 <= node.getStart()){
                    deleteNode = n;
                    break;
                }
            }
            
            if(deleteNode != null)
                linkedList.remove(deleteNode);
            
            linkedList.add(node);
            
            if(max < linkedList.size())
                max = linkedList.size();
        }
        
        return max;
    }
    
    public int convertToMinute(String hour){
        String[] hours = hour.split(":");
        return Integer.parseInt(hours[0]) * 60 + Integer.parseInt(hours[1]);
    }
}