package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class _11_스택으로_오름차순_수열_만들기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answer = new ArrayList<>();
        boolean check = true;
        int n = Integer.parseInt(br.readLine());

        int idx = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            while(idx <= k){
                stack.push(idx++);
                answer.add("+");
            }

            if(stack.peek() != k){
                check = false;
            }else{
                stack.pop();
                answer.add("-");
            }
        }

        if(!check){
            System.out.println("NO");
        }else{
            for(String a : answer)
                System.out.println(a);
        }
    }
}