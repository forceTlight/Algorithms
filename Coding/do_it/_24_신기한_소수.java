package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _24_신기한_소수 {
    static boolean[] visited;
    static int[] digit;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] oneDigit = new int[4];
        digit = new int[5];
        visited = new boolean[10];
        oneDigit[0] = 2;
        for(int i = 1; i <= 3; i++)
            oneDigit[i] = i * 2 + 1;

        for(int i = 0; i < 5; i++)
            digit[i] = (i * 2) + 1;

        if(n == 1){
            // 1의 자리 출력
            for(int a : oneDigit)
                System.out.println(a);
            return;
        }

        for(int i = 0; i < 4; i++){
            dfs(oneDigit[i], 1);
        }
    }

    public static void dfs(int num, int depth){
        if(depth >= n){
            System.out.println(num);
            return;
        }

        for(int i = 0; i < 5; i++){
            int sum = 10 * num + digit[i];
            if(isPrime(sum)){
                dfs(sum, depth+1);
            }
        }
    }

    // 소수 판별하는 메서드
    public static boolean isPrime(int num){
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0)
                return false;
        }

        return true;
    }
}