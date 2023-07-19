package 프로그래머스;

import java.util.*;

/**
 * 괄호 회전하기
 * 문제유형 : 구현
 * 난이도 : LEVLE 2
 * 풀이시간 : 1시간
 */
class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        
        loop:
        for(int i = 0; i < s.length(); i++){
            // 회전 시키기
            if(i != 0){
                sb.insert(sb.length(), sb.charAt(0));
                sb.deleteCharAt(0);
            }
            
            for(int j = 0; j < s.length(); j++){
                char c = sb.charAt(j);
                
                if(c == '[' || c == '{' || c == '('){
                    stack.push(c);
                }else{
                    if(stack.isEmpty())
                        continue loop;
                    
                    char prevC = stack.pop();
                    if(c == ']' && prevC != '[' || c == '}' && prevC != '{' || c == ')' && prevC != '(')
                        continue loop;
                }
            }
            
            // 스택이 비어있지 않으면 안됨
            if(!stack.isEmpty())
                continue loop;
            
            answer++;
        }
        
        return answer;
    }
}