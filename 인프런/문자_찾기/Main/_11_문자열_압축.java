import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11_문자열_압축 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine();
//        char[] ca = s.toCharArray();
//
//        StringBuilder sb = new StringBuilder();
//        char bc = ' '; // beforeChar
//        int p = 1;
//
//        for (char c : ca) {
//            if (bc == c) {
//                p++;
//            } else {
//                if (p != 1) {
//                    sb.append(p);
//                }
//                sb.append(c);
//
//                p = 1;
//            }
//            bc = c;
//        }
//
//        if(p != 1)
//            sb.append(p);
//
//        System.out.println(sb);

        /**
         * cnt를 이용해 푸는 코드 (좀 더 간결함)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine() + "AAAA"; // 끝까지 비교를 하기위해 뒤에 빈 문자열을 넣음

        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)) cnt ++;
            else{
                sb.append(s.charAt(i));
                if(cnt > 1)
                    sb.append(cnt);
                cnt = 1;
            }
        }

        System.out.println(sb);
    }
}
