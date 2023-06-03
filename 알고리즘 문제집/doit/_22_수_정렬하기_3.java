package doit;

import java.io.*;
import java.util.Arrays;

public class _22_수_정렬하기_3 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = Arrays.stream(arr).max().getAsInt();

        for(int exp = 1; max / exp > 0; exp *= 10){
            countingSort(arr, exp);
        }

        for(int a : arr)
            bw.append(a + "\n");

        bw.flush();
    }

    private static void countingSort(int[] arr, int exp){
        int[] count = new int[10];
        int[] output = new int[arr.length];

        // 각 숫자의 개수를 세어준다
        for(int i = 0; i < arr.length; i++)
            count[(arr[i] / exp) % 10]++;

        // 누적 개수
        for(int i = 1; i < 10; i++)
            count[i] += count[i-1];

        // 정렬
        for(int i = arr.length - 1; i >= 0; i--){
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 결과 복사
        for(int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
}