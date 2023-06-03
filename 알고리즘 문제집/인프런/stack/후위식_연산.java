package 인프런.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class 후위식_연산 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> numStack = new Stack<>();
        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                numStack.push(c - '0');
            }else{
                int a = numStack.pop();
                int b = numStack.pop();
                numStack.push(calculate(a, b, c));
            }
        }

        System.out.println(numStack.pop());
    }

    public static int calculate(int a, int b, char operation){
        switch(operation){
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }

        return 0;
    }
}