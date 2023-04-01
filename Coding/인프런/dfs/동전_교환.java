package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 동전_교환 {
    static int n;
    static int charge;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        charge = Integer.parseInt(br.readLine());

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int sum){
        if(sum > charge){
            return;
        }
        if(depth >= answer)
            return;
        if(sum == charge){
            answer = Math.min(answer, depth);
            return;
        }

        for(int i = n-1; i >= 0; i--){
            if(charge - (sum + arr[i]) >= 0){
                dfs(depth+1, sum + arr[i]);
            }
        }
    }
}