package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 모듈러 연산
public class _1323_숫자_연결하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int len = String.valueOf(n).length();

        HashSet<Long> hashSet = new HashSet<>();
        long mod = n % k;
        int cnt = 1;
        long digit = (long) Math.pow(10, len);

        while(true){
            if(mod == 0){
                break;
            }

            mod = (n % k + (int)((mod * (digit % k)) % k)) % k;

            if(hashSet.contains(mod)){
                System.out.println(-1);
                return;
            }

            hashSet.add(mod);
            cnt++;
        }

        System.out.println(cnt);
    }
}