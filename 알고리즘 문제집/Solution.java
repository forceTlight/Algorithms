import java.util.*;

/**
 * 2020 카카오 인턴십 - 수식 최대화
 * 문제유형 : 구현, dfs
 * 난이도 : LEVEL 2
 * 풀이시간 : 2시간
 */
public class Solution {
    static HashSet<Character> opSet;
    static ArrayList<Character> opList;
    static boolean[] isVisited;
    static char[] depthArr;
    static int len;
    static long answer;

    public static void main(String args[]){
        System.out.println(solution("10+10-10-10"));
    }

    public static long solution(String expression) {
        opSet = new HashSet<>();
        opList = new ArrayList<>();

        // 연산자 종류 구하기
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                opSet.add(c);
            }
        }

        len = opSet.size();
        isVisited = new boolean[len];
        depthArr = new char[len];
        for(char op : opSet)
            opList.add(op);

        // 연산자 조합의 경우의 수 dfs로 구하기
        dfs(0, expression);

        return answer;
    }

    // 연산자 조합의 경우의 수 구하기
    public static void dfs(int depth, String expression){
        if(depth == len){
            // 해당 조합을 통해 주어진 식의 절댓값 최대값 구하기
            answer = Math.max(getAbsSum(expression), answer);
            return;
        }

        for(int i = 0; i < opList.size(); i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                depthArr[depth] = opList.get(i);
                dfs(depth+1, expression);
                isVisited[i] = false;
            }
        }
    }


    public static long getAbsSum(String expression){
        Deque<Long> numQueue = new LinkedList<>();
        Deque<Long> tmpQueueNum = new LinkedList<>();
        Deque<Character> opQueue = new LinkedList<>();
        Deque<Character> tmpQueueOp = new LinkedList<>();

        // 값 넣어두기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                opQueue.add(c);
                long num = Long.parseLong(sb.toString());
                numQueue.add(num);
                sb.setLength(0);
            }else{
                sb.append(c);
            }
        }

        numQueue.add(Long.parseLong(sb.toString()));

        // 연산자 우선순위별 연산 수행
        for(int i = 0; i < len; i++){
            char op = depthArr[i];

            while(!opQueue.isEmpty()){
                char currentOp = opQueue.poll();

                if(currentOp == op){
                    long num1 = numQueue.poll();
                    long num2 = numQueue.poll();

                    if(op == '+'){
                        numQueue.addFirst(num1+num2);
                    }else if(op == '-'){
                        numQueue.addFirst(num1-num2);
                    }else{ // 곱셈
                        numQueue.addFirst(num1*num2);
                    }
                }else{
                    long num = numQueue.poll();
                    tmpQueueNum.add(num);
                    tmpQueueOp.add(currentOp);
                }
            }


            // 복구
            while(!tmpQueueOp.isEmpty()){
                char currentOp = tmpQueueOp.poll();
                long num = tmpQueueNum.poll();

                opQueue.add(currentOp);
                numQueue.add(num);
            }

            numQueue.addLast(numQueue.poll());

        }
        return Math.abs(numQueue.poll());
    }
}