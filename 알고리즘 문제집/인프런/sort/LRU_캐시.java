package 인프런.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LRU_캐시 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = -1;
            for(int j = 0; j < n; j++){ // 0이나 targetNumber 찾기
                if(arr[j] == 0 || arr[j] == target){
                    idx = j;
                    break;
                }
            }
            if(idx == -1){
                for(int j = n-1; j > 0; j--)
                    arr[j] = arr[j-1];
            }else{
                for(int j = idx; j > 0; j--)
                    arr[j] = arr[j-1];
            }

            arr[0] = target;
        }

        for (int a : arr)
            System.out.print(a + " ");
    }
}