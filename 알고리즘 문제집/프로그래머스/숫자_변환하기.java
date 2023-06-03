package 프로그래머스;

import java.util.*;

class 숫자_변환하기 {
    static int answer = Integer.MAX_VALUE;
    static int[] dp;
    
    public int solution(int x, int y, int n) {
        dp = new int[y + 1];
        Arrays.fill(dp, 100000000);
        dp[x] = 0;
        
        for(int i = x; i <= y; i++){
            if(i + n <= y){
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            }
            if(i * 2 <= y){
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            }
            if(i * 3 <= y){
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
            }
        }
        
        answer = dp[y] == 100000000 ? -1 : dp[y];
        
        return answer;
    }
}