package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  _18_ATM {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        int sum = 0;
        for(int i = 1; i < n; i++){
            int target = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > target){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = target;
        }

        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                sum += arr[j];
            }
        }

        System.out.println(sum);
    }
}