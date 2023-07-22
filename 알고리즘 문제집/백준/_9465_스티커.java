package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 9465_스티커
 * 문제유형 : DP Top-Down
 * 난이도 : SILVER 1
 * 풀이시간 : 1시간 30분
 */

// output: 2n개의 스티커 중에서 두 변을 공유하지 않는 스티커 점수의 최댓값
// output-size: int
// input: 1) 테스트 케이스 t 2) 사이즈 n 3) n개의 정수 -> 정수는 그 위치에 해당하는 스티커의 점수 (score)
// input-size: 0 <= score <= 100

// 유형 : DP
// 사용하는 자료구조 :

// 문제 설명
// 1. 스티커는 2행 n열로 배치되어있다.
// 2. 스티커 한 장을 떼면 그 스티커와 변을 공유하는 스티커는 모두 찢어져서 사용할 수 없게된다.
// 3. 2n개의 스티커 중에서 점수 합이 최대가 되면서, 서로 변을 공유하지 않는 스티커 집합을 구해야한다.
public class _9465_스티커 {
    static int[][] dp;
    static int[][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            dp = new int[n + 1][3];
            arr = new int[n + 1][3];
            for(int[] d : dp)
                Arrays.fill(d, -1);

            for(int j = 1; j <= 2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= n; k++){
                    arr[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[1][2] = arr[1][2];

            sb.append(Math.max(getScore(n, 1), getScore(n, 2))).append("\n");
        }
        System.out.println(sb);
    }

    public static int getScore(int col, int low){
        if(col <= 1 || dp[col][low] != -1)
            return dp[col][low];

        int nextLow = low == 1? 2 : 1;
        return dp[col][low] = Math.max(getScore(col - 1, nextLow), getScore(col - 2, nextLow)) + arr[col][low];
    }
}