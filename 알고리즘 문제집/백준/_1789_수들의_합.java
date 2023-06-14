package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _1789_수들의_합 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        HashSet<Long> hashSet = new HashSet<>();

        long num = 0;
        while(n > 0){
            num++;
            n -= num;
            hashSet.add(num);

            if(hashSet.contains(n))
                break;
        }

        System.out.println(hashSet.size());
    }
}