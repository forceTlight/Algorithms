package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_4_피보나치_수열 {
    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] arr = new int[n];
//        arr[0] = 1; arr[1] = 1;
//
//        for(int i = 2; i < n; i++){
//            arr[i] = arr[i - 2] + arr [i - 1];
//        }
//
//        for(int i = 0; i < n; i++){
//            System.out.print(arr[i] + " ");
//        }
        /**
         * 배열 안쓰고 피보나치 수열 풀기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int a = 1; int b = 1;
        int c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i < n; i++){
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
