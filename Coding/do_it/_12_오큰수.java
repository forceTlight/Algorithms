package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12_오큰수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int num =  arr[i];
            if(stack.isEmpty()){
                stack.push(i); // 수열의 값이 아닌, 인덱스 값을 저장
                continue;
            }

            while(!stack.isEmpty() && num > arr[stack.peek()]){ // 오른쪽에 큰 수가 왔을 경우
                int idx = stack.pop();
                answer[idx] = num;
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int a : answer)
            sb.append(a).append(" ");

        System.out.println(sb);
    }
}