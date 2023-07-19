package 프로그래머스;
import java.util.*;

/**
 * 다리를 지나는 트럭
 * 문제유형 : 스택/큐, 구현
 * 난이도 : LEVLE 2
 * 풀이시간 : 1시간 30분
 */
class 다리를_지나는_트럭 {
    static class Node{
        int weight;
        int time;
        
        public Node(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {        
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < truck_weights.length; i++){
            q.offer(new Node(truck_weights[i], 0));
        }
                
        ArrayList<Node> list = new ArrayList<>();
        int time = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            
            // 리스트 안에 무게 계산
            while(true){
                time++;
                int sum = 0;
                // 다리위의 무게 계산, 시간 추가
                for(int j = 0; j < list.size(); j++){
                    Node bridgeNode = list.get(j);
                    bridgeNode.time++;
                    if(bridgeNode.time == bridge_length){ // 다리를 다 건너면 제거
                        list.remove(j);
                        j--;
                    }else{
                        sum += bridgeNode.weight; // 다리 못건넌 무게들 구하기
                    }
                }

                if(sum + node.weight <= weight && list.size() < bridge_length){ // 다리에 차를 올릴 수 있는 경우
                    list.add(node);
                    break;
                }
            }
        }
        
        // 현재 도로에 있는 차들의 대기시간 구하기
        time += bridge_length - list.get(list.size() - 1).time;
        
        return time;
    }
}