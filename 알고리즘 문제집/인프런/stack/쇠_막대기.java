package 인프런.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 여러 쇠 막대기 절단
// 조건
// 쇠 막대기는 자신보다 긴 쇠막대기만 위에 놓을 수 있다. 쇠 막대기를 다른 쇠 막대기 위에 놓는 경우, 완전히 포함하도록 놓되, 끝점은 겹치치 않게 놓는다.
// 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
// 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
public class 쇠_막대기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                stack.pop();

                // 전에 나온 인덱스에 열린 괄호가 있는지 확인 => 있으면 레이저로 판별
                if(input.charAt(i-1) == '('){
                    answer += stack.size();
                }else{
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}