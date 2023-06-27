package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1038 - 감소하는 수
 * 기존에는 백트래킹으로 풀었으나, DP로 풀어 424m/s -> 128m/s로 시간 복잡도를 줄였음.
 */
public class _1038_감소하는_수 {
    static int cnt = 0;
    static long answer = -1;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[10][10];

        // dp 초기화
        for(int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
            if(n == i){
                System.out.println(i);
                return;
            }
        }
        dp[0][0] = 0;

        int sum = 9;
        int beforeSum = 9;
        loop:
        for(int i = 1; i <= 9; i++){
            int tmpSum = 0;
            for(int j = i; j <= 9; j++){
                if(j == i){
                    tmpSum += 1;
                }else{
                    tmpSum += dp[i - 1][j - 1];
                }

                dp[i][j] = tmpSum;
                sum += dp[i][j];

                if(sum >= n){
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    getNum(i + 1, sb, n - beforeSum);
                    break loop;
                }

                beforeSum = sum;
            }
        }

        System.out.println(answer);
    }

    public static void getNum(int a, StringBuilder sb, int diff){
        if(answer != -1)
            return;

        if(sb.length() == a){
            cnt++;
            if(cnt == diff){
                answer = Long.parseLong(sb.toString());
                return;
            }
            return;
        }

        int n = sb.charAt(sb.length() - 1) - '0';
        for(int i = 0; i < 9; i++){
            if(n > i){
                sb.append(i);
                getNum(a, sb, diff);
                sb.deleteCharAt(sb.length() - 1);
            }else{
                break;
            }
        }
    }
}