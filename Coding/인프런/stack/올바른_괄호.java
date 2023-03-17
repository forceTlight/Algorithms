package 인프런.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}