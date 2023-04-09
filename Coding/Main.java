import java.util.Arrays;

class Main {
    static int y;
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[] dp;

    public static void main(String args[]){
        System.out.println(solution(2, 2, 1));
    }
    public static int solution(int x, int y, int n) {
        dp = new int[y+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for(int i = x; i <= y; i++){
            if(i + n <= y)
                dp[i + n] = Math.min(dp[i + n], dp[i] + 1);
            if(i * 2 <= y)
                dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
            if(i * 3 <= y)
                dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
        }

        answer = dp[y] == Integer.MAX_VALUE? -1 : dp[y];


        return answer;
    }
}