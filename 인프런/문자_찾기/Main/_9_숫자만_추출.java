import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9_숫자만_추출 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine();
//
//        s = s.replaceAll("[^0-9]","");
//
//        System.out.println(Integer.parseInt(s));
        /**
         * 1 - 연산을 통해 구하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int answer = 0;

        for(char c : s.toCharArray()){
            if(c >= 48 && c <= 57)
                answer = answer * 10 + (c - 48);
        }

        System.out.println(answer);
    }
}
