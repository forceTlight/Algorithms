package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2_8_등수_구하기 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String[] input = br.readLine().split(" ");
//        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
//        Integer[] sortArr = Arrays.stream(arr.clone()).boxed().toArray(Integer[]::new);
//        Arrays.sort(sortArr, Collections.reverseOrder());
//
//        int[] result = new int[n];
//
//
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                if(arr[i] == sortArr[j]){
//                    result[i] = j + 1;
//                    break;
//                }
//            }
//        }
//
//        Arrays.stream(result).forEach(e -> System.out.print(e + " "));

        /**
         * 2중 for 문으로 푸는 코드
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int cnt = 1;
        for(int i = 0; i < n; i++){
            cnt = 1;
            for(int j = 0; j < n; j++){
                if(arr[i] < arr[j])
                    cnt++;
            }
            System.out.print(cnt + " ");
        }
    }
}
