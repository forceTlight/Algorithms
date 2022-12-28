import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_8_유효한_팰린드롬 {
    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String s = br.readLine();
        /**
         * 내가 작성한 코드 (오답)
         */
//        StringBuilder sb = new StringBuilder();
//
//        String answer = "YES";
//
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(c == ' '){
//                sb.append(" ");
//            }else if(Character.isAlphabetic(c)){
//                sb.append(c);
//            }
//        }
//
//
//        String[] sp = sb.toString().split(" ");
//
//        int lt = 0, rt = sp.length - 1;
//
//        StringBuilder reverseSb = new StringBuilder();
//        while(lt < rt){
//            reverseSb.setLength(0);
//            reverseSb.append(sp[rt]).reverse();
//            if(!sp[lt].equalsIgnoreCase(reverseSb.toString())){
//                answer = "NO";
//            }
//            lt ++;
//            rt --;
//        }
//
//        System.out.println(answer);

        /**
         * replace.All 정규 문자식을 이용해 푸는 방법
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "YES";

        String s = br.readLine().toUpperCase();

        s = s.replaceAll("[^A-Z]", "");

        StringBuilder sb = new StringBuilder(s).reverse();

        if(!s.equalsIgnoreCase(sb.toString())){
            answer = "NO";
        }

        System.out.println(answer);
    }
}
