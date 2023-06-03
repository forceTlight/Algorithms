package 인프런.dfs;

import java.util.*;
import java.io.*;

public class 합이_같은_부분집합 {
    static boolean flag = false;
    static String answer = "NO";
    static int total = 0;
    static boolean[] visited;
    static int[] arr;
    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        total = Arrays.stream(arr).sum();

        for(int i = 1; i <= n; i++){
            dfs(0, 0);
        }

        System.out.println(answer);
    }

    public static void dfs(int idx, int sum) {
        if(flag)
            return;

        if(idx == n){
            if(total - sum == sum){
                flag = true;
                answer = "YES";
            }
            return;
        }

        dfs(idx+1, sum + arr[idx]);
        dfs(idx+1, sum);
    }
}