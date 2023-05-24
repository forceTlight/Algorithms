package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_나무_자르기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        int right = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int left = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(checkLength(arr, m, mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    public static boolean checkLength(int[] arr, int m, int l){
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > l){
                sum += (arr[i] - l);
            }
        }

        if(sum >= m)
            return true;
        else
            return false;
    }
}