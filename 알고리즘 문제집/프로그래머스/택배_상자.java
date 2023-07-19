package 프로그래머스;

import java.util.Stack;

class 택배_상자 {
    public static void main(String args[]){
        System.out.println(solution(new int[]{3, 5, 4, 2, 1}));
    }
    public static int solution(int[] order) {
        int answer = 0;

        // 보조 컨테이너
        Stack<Integer> stack = new Stack<>();

        int num = 1;

        for(int i = 0; i < order.length; i++){
            int currentOrder = order[i];

            while(currentOrder > num){
                stack.push(num++);
            }

            if(currentOrder == num) {
                answer++;
                num++;
            } else {
                if(stack.isEmpty() || stack.peek() != currentOrder)
                    return answer;
                else { // 스택에서 꺼내야 할 때
                    stack.pop();
                    answer++;
                }
            }
        }

        return answer;
    }
}