package 프로그래머스;

import java.util.*;

class 뒤에_있는_큰_수_찾기 {
    static class Node{
        int idx;
        int value;
        public Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    
    public int[] solution(int[] numbers) {
        Stack<Node> stack = new Stack<>();
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            int value = numbers[i];
            
            while(!stack.isEmpty() && stack.peek().value < value){
                Node node = stack.pop();
                answer[node.idx] = value;
            }
            
            stack.push(new Node(i, value));
        }
        
        // 스택에 남은 것들은 -1로 처리
        while(!stack.isEmpty()){
            Node node = stack.pop();
            answer[node.idx] = -1;
        }
        
        return answer;
    }
}