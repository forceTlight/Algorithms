package 인프런.dfs;

import java.io.*;

public class 피보나치_재귀__메모이제이션 {
    static int[] fibo;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        fibo = new int[n+1];
        dfs(n);

        for(int i = 1; i <= n; i++){
            System.out.println(fibo[i]);
        }
    }
    public static int dfs(int n){
        if(fibo[n] > 0)
            return fibo[n];

        if(n == 1 || n == 2)
            return fibo[n] = 1;

        return fibo[n] = dfs(n-1) + dfs(n-2);
    }
}