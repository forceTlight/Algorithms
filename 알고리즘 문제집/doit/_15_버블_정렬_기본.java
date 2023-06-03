package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class _15_버블_정렬_기본 {
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // bubble sort
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-i-1; j++){
                if(arr[j] > arr[j+1])
                    swap(j, j+1);
            }
        }

        // sort result
        for(int a : arr)
            System.out.println(a);
    }

    public static void swap(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}