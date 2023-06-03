package 인프런.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_7_회문_문자열 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine().toLowerCase();
//        String answer = "YES";
//
//        int lt = 0, rt = s.length() - 1;
//
//        while(lt < rt){
//            if(s.charAt(lt) != s.charAt(rt)){
//                answer = "NO";
//                break;
//            }
//            lt ++;
//            rt --;
//        }
//
//        System.out.println(answer);

//        /**
//         * length / 2로 풀기
//         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine().toLowerCase();
//        String answer = "YES";
//
//        int length = s.length() / 2;
//        for (int i = 0; i < length; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
//                answer = "NO";
//                break;
//            }
//        }
//        System.out.println(answer);

        /**
         * StringBuilder reverse, equalIgnoreCase로 풀기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toLowerCase();
        String answer = "NO";

        String reverse = new StringBuilder(s).reverse().toString();

        if(s.equalsIgnoreCase(reverse))
            answer = "YES";

        System.out.println(answer);
    }
}
