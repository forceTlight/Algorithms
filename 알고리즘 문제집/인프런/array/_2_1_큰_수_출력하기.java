package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2_1_큰_수_출력하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        System.out.print(arr[0] + " ");
        for(int i = 1; i < arr.length ; i++){
            if(arr[i - 1] < arr[i])
                System.out.print(arr[i] + " ");
        }
    }
}
