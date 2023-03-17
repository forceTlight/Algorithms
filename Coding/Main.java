import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
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