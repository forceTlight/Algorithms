package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14888_연산자_끼워넣기 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] oper; // 0은 +, 1은 -, 2은 곱셈, 3은 나눗셈
    static int[] num;

    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        oper = new int[4];
        num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++)
            oper[i] = Integer.parseInt(st.nextToken());

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int sum){
        if(depth == n){
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            if(oper[i] > 0){
                oper[i]--;
                if(i == 0){ // +
                    dfs(depth+1, sum + num[depth]);
                }else if(i == 1){ // -
                    dfs(depth+1, sum - num[depth]);
                }else if(i == 2){ // *
                    dfs(depth+1, sum * num[depth]);
                }else{ // 3 /
                    dfs(depth+1, sum / num[depth]);
                }
                oper[i]++;
            }
        }
    }
}