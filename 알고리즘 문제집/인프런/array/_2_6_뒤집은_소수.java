package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2_6_뒤집은_소수 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 푼 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String[] input = br.readLine().split(" ");
//        int[] arr = new int[n];
//
//        StringBuilder sb = new StringBuilder();
//
//        int max = 0;
//        loop:
//        for(int i = 0; i < n; i++){
//            sb.setLength(0);
//            for(int j = input[i].length() - 1; j >= 0 ; j--){
//                if(sb.toString() == null && input[i].charAt(j) == '0')
//                    continue;
//
//                sb.append(input[i].charAt(j));
//            }
//            arr[i] = Integer.parseInt(sb.toString());
//            if(max < arr[i])
//                max = arr[i];
//        }
//
//        int[] ch = new int[max + 1];
//        ch[0] = 1; ch[1] = 1;
//        for(int i = 2; i <= max; i++){
//            for(int j = i*2; j <= max; j+=i){
//                ch[j] = 1;
//            }
//        }
//
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] != 0){
//                if(ch[arr[i]] == 0)
//                    System.out.print(arr[i]+ " ");
//            }
//        }
        /**
         * 강의에서 푼 코드 (수를 뒤집는걸 연산으로 접근)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        List<Integer> answers = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0){
                int t = tmp % 10;
                res = res * 10 + t;
                tmp /= 10;
            }
            if(isPrime(res))
                answers.add(res);
        }

        answers.forEach(a -> System.out.print(a + " "));
    }

    public static boolean isPrime(int num){
        for(int i = 2; i < num; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
