package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _17_소트_인사이드 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[input.length()];
        int n = input.length();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            arr[i] = Character.getNumericValue(c);
        }

        // 선택 정렬
        for(int i = 0; i < n-1; i++){
            int idx = i;
            for(int j = i; j < n; j++){
                if(arr[idx] < arr[j])
                    idx = j;
            }

            // swap
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        for(int a : arr)
            System.out.print(a);
    }
}