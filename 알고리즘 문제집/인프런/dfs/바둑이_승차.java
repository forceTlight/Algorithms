package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바둑이_승차 {
    static boolean[] visited;
    static int n;
    static int m;
    static int[] arr;
    static int answer = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int sum){
        if(sum > n){
            return;
        }
        if(idx == m){
            answer = Math.max(sum, answer);
            return;
        }

        dfs(idx+1, sum + arr[idx]);
        dfs(idx+1, sum);
    }
}