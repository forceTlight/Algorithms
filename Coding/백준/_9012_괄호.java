package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012_괄호 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();

        loop:
        for(int i = 0; i < n; i++){
            stack.clear();
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++){
                char c = input.charAt(j);
                if(c == '('){
                    stack.push('(');
                }else{
                    if(stack.isEmpty()){
                        System.out.println("NO");
                        continue loop;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(stack.isEmpty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}