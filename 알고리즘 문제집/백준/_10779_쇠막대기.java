package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10779_쇠막대기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '('){
                stack.push('(');
                flag = false;
            }else{
                stack.pop();
                if(flag){ // 전에 닫힌 괄호가 나왔을 경우 (막대 끝)
                    answer++;
                }else{ // 열린 괄호가 나왔을 경우 (레이저)
                    answer += stack.size();
                }
                flag = true;
            }
        }

        System.out.println(answer);
    }
}