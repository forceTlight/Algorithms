package 프로그래머스;
// output: 실패열이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열

// input: 스테이지 개수 N, 사용자가 현대 도전 중인 스테이지 번호가 담긴 배열 stages
// input-size: 1 <= N <= 500, 1 <= stages <= 200,000

// 문제 설명
// 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어 수

import java.util.*;

class 카카오_실패율 {
    static class Node implements Comparable<Node>{
        int stage;
        double failRate;
        
        public Node(int stage, double failRate){
            this.stage = stage;
            this.failRate = failRate;
        }
        
        @Override
        public int compareTo(Node n){
            if(n.failRate == this.failRate)
                return this.stage - n.stage;
            
            return Double.compare(n.failRate, this.failRate);
        }
    }
    
    public int[] solution(int N, int[] stages) {        
        PriorityQueue<Node> resultPq = new PriorityQueue<>();
        PriorityQueue<Integer> stagePq = new PriorityQueue<>();
        
        for(int i = 0; i < stages.length; i++){
            stagePq.offer(stages[i]);
        }
        
        int currentStage = 1;
        while(currentStage <= N){
            int cnt = 0;
            int size = stagePq.size();
            
            while(!stagePq.isEmpty() && stagePq.peek() == currentStage){
                stagePq.poll();
                cnt++;
            }
            
            double failure = size == 0? 0: (double) cnt / size;
            resultPq.offer(new Node(currentStage, failure));
            currentStage++;
        }
        
        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[i] = resultPq.poll().stage;
        }
        
        return answer;
    }
}