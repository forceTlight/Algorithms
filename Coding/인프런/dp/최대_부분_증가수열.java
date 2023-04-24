package 인프런.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 최대_부분_증가수열 {
    static int[] dp;
    static ArrayList<Integer> list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        dp = new int[1001];
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int value = getValue(num);

            dp[num] = value + 1;
            max = Math.max(dp[num], max);

            list.add(num);
        }

        System.out.println(max);
    }

    // 특정 원소 전에 방문한 가장 작은 dp값 반환
    public static int getValue(int n){
        int max = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) <= n){
                max = Math.max(max, dp[list.get(i)]);
            }
        }

        return max;
    }
}