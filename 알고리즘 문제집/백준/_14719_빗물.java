package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14719_빗물 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] arr = new int[w];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i = 1; i < w - 1; i++){
            int left = 0;
            int right = 0;

            for(int j = i - 1; j >= 0; j--){
                left = Math.max(left, arr[j]);
            }

            for(int j = i + 1; j < w; j++){
                right = Math.max(right, arr[j]);
            }

            int min = Math.min(left, right);

            if(left > arr[i] && right > arr[i])
                sum += (min - arr[i]);
        }

        System.out.println(sum);
    }
}