package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_5_소수_에라토스테네스체 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        boolean[] prime = new boolean[n+1];
//
//        prime[0] = true; prime[1] = true; // 소수는 false
//
//        for(int i = 2; i <= n; i++){
//            for(int j = i * 2; j <= n; j+=i){
//                prime[j] = true;
//            }
//        }
//
//        int cnt = 0;
//        for(int i = 0; i < prime.length; i++){
//            if(prime[i] == false)
//                cnt++;
//        }
//
//        System.out.println(cnt);
        /**
         * 강의에서 알려준 코드
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] ch = new int[n + 1];
        int answer = 0;

        for(int i = 2; i <= n; i++){
            if(ch[i] == 0)
                answer ++;
            for(int j = i; j <= n; j+=i){
                ch[j] = 1;
            }
        }
        System.out.println(answer);
    }
}
