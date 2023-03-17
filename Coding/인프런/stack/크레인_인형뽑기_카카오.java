package 인프런.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 크레인_인형뽑기_카카오 {
    static int[][] arr;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Stack<Integer> storeStack = new Stack<>();
        int answer = 0;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int idx = Integer.parseInt(st.nextToken());
            int doll = getElement(idx, 0);
            if(doll == 0)
                continue;

            if(!storeStack.isEmpty() && storeStack.peek() == doll){
                storeStack.pop();
                answer += 2;
            }
            else
                storeStack.push(doll);
        }

        System.out.println(answer);
    }

    public static int getElement(int idx, int depth){
        if(depth == n+1)
            return 0;

        if(arr[depth][idx] != 0){
            int element = arr[depth][idx];
            arr[depth][idx] = 0;
            return element;
        }

        return getElement(idx, depth+1);
    }
}