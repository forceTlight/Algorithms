package 인프런.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 재귀_함수를_이용한_2진수_출력 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n);
    }

    static void dfs(int n){
        if(n == 0)
            return;

        dfs(n/2);
        System.out.print(n % 2);
    }
}