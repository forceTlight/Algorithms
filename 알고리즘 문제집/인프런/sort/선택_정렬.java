package 인프런.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 선택_정렬 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 삽입 정렬
        for(int i = 0; i < n-1; i++){
            int idx = i;
            for(int j = i+1; j < n; j++){
                if(arr[idx] > arr[j])
                    idx = j;
            }
            // swap
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        // print
        for(int a : arr)
            System.out.print(a + " ");
    }
}