package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대_점수_구하기 {
    static int n;
    static int m;
    static int[][] arr;
    static int answer = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int idx, int sum, int time){
        if(time > m)
            return;

        if(idx == n){
            answer = Math.max(answer, sum);
            return;
        }

        dfs(idx+1, sum + arr[idx][0], time + arr[idx][1]);
        dfs(idx+1, sum, time);
    }
}