package 프로그래머스;

import java.util.*;

class 요격_시스템 {
    static class Bound implements Comparable<Bound>{
        int start;
        int end;
        
        public Bound(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Bound bound){
            return this.end - bound.end;
        }
    }
    
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<Bound> pq = new PriorityQueue<>();
        for(int i = 0; i <targets.length; i++){
            int start = targets[i][0];
            int end = targets[i][1];
            
            pq.offer(new Bound(start, end));
        }
        
        while(!pq.isEmpty()){
            Bound bound = pq.poll();
            int end = bound.end;
                        
            while(!pq.isEmpty() && pq.peek().start < end){
                pq.poll();
            }
            
            answer++;
        }
        
        return answer;
    }
}