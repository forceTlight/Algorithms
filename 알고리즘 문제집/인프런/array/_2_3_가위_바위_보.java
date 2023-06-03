package 인프런.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2_3_가위_바위_보 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        String[] a = br.readLine().split(" ");
//        String[] b = br.readLine().split(" ");
//
//        for(int i = 0; i < n; i++){
//            String answer = null;
//            if(a[i].equals("1")){
//                if(b[i].equals("2")){
//                    answer = "B";
//                }else if(b[i].equals("3")){
//                    answer = "A";
//                }
//            }else if(a[i].equals("2")){
//                if(b[i].equals("1")){
//                    answer = "A";
//                }else if(b[i].equals("3")){
//                    answer = "B";
//                }
//            }else if(a[i].equals("3")){
//                if(b[i].equals("1")){
//                    answer = "B";
//                }else if(b[i].equals("2")){
//                    answer = "A";
//                }
//            }
//
//            if(answer == null)
//                answer = "D";
//
//            System.out.println(answer);
        /**
         * 강의에서 알려 준 코드
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < n; i++){
            String answer = "";
            if(a[i] == b[i]){
                answer = "D";
            }else if(a[i] == 1 && b[i] == 3){
                answer ="A";
            }else if(a[i] == 2 && b[i] == 1){
                answer = "A";
            }else if(a[i] == 3 && b[i] == 2){
                answer = "A";
            }else{
                answer = "B";
            }
            System.out.println(answer);
        }
    }
}
