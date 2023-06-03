package doit;

import java.io.*;

public class _19_수_정렬하기2 {
    static int[] temp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        mergeSort(arr, 0, arr.length - 1);

        for(int i = 0; i < n; i++){
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int k = left;

        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid){
            temp[k++] = arr[i++];
        }

        while(j <= right){
            temp[k++] = arr[j++];
        }

        for(int index = left; index < k; index++){
            arr[index] = temp[index];
        }
    }
}