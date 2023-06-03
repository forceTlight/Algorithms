package 프로그래머스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _문자열_압축 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
            System.out.println(solution(br.readLine()));
    }

    public static String solution(String p) {
        return convert(p);
    }

    public static String convert(String s) {
        if (s == "")
            return "";

        // 균형 잡힌 문자열로 분리하기
        StringBuilder ub = new StringBuilder();
        StringBuilder vb = new StringBuilder();

        int lt = 0;
        int rt = 0; // 왼쪽 괄호, 오른쪽 괄호 카운트
        for (int i = 0; i < s.length(); i++) {
            if (lt == rt && lt != 0) {
                vb.append(s.substring(i));
                break;
            }
            char c = s.charAt(i);
            if (c == '(') {
                ub.append('(');
                lt++;
            } else {
                ub.append(')');
                rt++;
            }
        }

        // u 올바른 괄호 문자열인지 검사
        if (ub.length() == 0)
            return "";

        char startChar = ub.charAt(0);
        if (startChar == '(') {
            // 올바른 문자열
            return ub + convert(vb.toString());
        } else {
            // 올바르지 않은 문자열
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(convert(vb.toString()));
            sb.append(')');

            // 첫번째와 끝 문자 제거
            ub.deleteCharAt(0);
            ub.deleteCharAt(ub.length() - 1);

            // 문자열 뒤집어서 붙히기
            for(int i = 0; i < ub.length(); i++){
                if(ub.charAt(i) == '('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }

            return sb.toString();
        }
    }
}