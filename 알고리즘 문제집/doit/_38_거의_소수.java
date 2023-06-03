package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _38_거의_소수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] arr = new long[10000001];

        for(int i = 2; i < arr.length; i++)
            arr[i] = i;

        for(int i = 2; i <= Math.sqrt(arr.length); i++){
            if(arr[i] == 0)
                continue;
            for(int j = i + i; j < arr.length; j += i)
                arr[j] = 0;
        }

        int answer = 0;
        for(int i = 2; i < arr.length; i++){
            if(arr[i] == 0)
                continue;

            long tmp = arr[i];
            while((double) n / (double) arr[i] > tmp)
                tmp *= arr[i];

            while((double) m / (double) arr[i] >= tmp){
                answer++;
                tmp *= arr[i];
            }
        }

        System.out.println(answer);
    }
}