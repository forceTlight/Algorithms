package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2470_두_용액 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int left = 0;
        int right = arr.length - 1;

        int a = 0;
        int b = 0;
        int value = Integer.MAX_VALUE;

        while(left < right){
            int tmp = arr[left] + arr[right];

            if(value > Math.abs(tmp)){
                a = arr[left];
                b = arr[right];
                value = Math.min(value, Math.abs(tmp));
            }

            if(tmp > 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(a + " " + b);
    }
}