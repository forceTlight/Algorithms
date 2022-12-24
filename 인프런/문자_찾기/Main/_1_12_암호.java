import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_12_암호 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        String answer = "";
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String input = br.readLine();
//
//        String[] words = new String[n];
//
//        for(int i = 0; i < n; i++){
//            words[i] = input.substring(i * 7, (i+1) * 7);
//        }
//
//        for(int i = 0; i < n; i++){
//            String digit = "";
//
//            // 2진수로 변환
//            for(int j = 0; j < 7; j++){
//                if(words[i].charAt(j) == '#'){
//                    digit += '1';
//                }else{
//                    digit += '0';
//                }
//            }
//
//            // 10진수로 변환
//            int num = 0;
//            for(int j = 0; j < 7; j++){
//                if(digit.charAt(6-j) == '1')
//                    num += Math.pow(2, j);
//            }
//
//            answer += (char)num;
//        }
//        System.out.println(answer);

        /**
         * 문제 풀이 코드
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String answer = "";

        for(int i = 0; i < n; i++){
            String tmp = s.substring(0, 7).replace("#", "1").replace("*", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            s = s.substring(7);
        }

        System.out.println(answer);
    }
}
