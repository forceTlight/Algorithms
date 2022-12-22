import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6_중복_문자_제거 {
    public static void main(String args[]) throws IOException {
        /**
         * 기존에 접근한 코드 (오답 코드)
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = br.readLine();
//        char[] cArray = input.toCharArray();
//
//        StringBuilder sb = new StringBuilder();
//
//        ArrayList<Character> duplicatedChar = new ArrayList<>();
//
//        for (int i = cArray.length - 1; i >= 0; i--) {
//            int cnt = 0;
//            char c = input.charAt(i);
//            if(duplicatedChar.contains(c))
//                continue;
//
//            for(int j = i; j >= 0; j--){
//               if(c == input.charAt(j))
//                   cnt++;
//            }
//            if(cnt % 2 == 0){
//                duplicatedChar.add(c);
//                continue;
//            }
//
//            sb.insert(0, c);
//            duplicatedChar.add(c);
//        }
//
//        System.out.println(sb);

        /**
         * String.ValueOf(char)로 Index 비교해서 푼 코드
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            if(i == input.indexOf(input.charAt(i))){
                sb.append(input.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
