import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int arr[];
    static Integer dp[];
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        dp = new Integer[n];
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            top_down(i);
        }
        int max = dp[0];
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
    static int top_down(int N){
        if(dp[N] == null){
            dp[N] = 1;
            for(int i = N - 1; i >= 0; i--){
                if (arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], top_down(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
