import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5_특정_문자_뒤집기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        /**
         * 내가 작성한 코드
         */
//        int lt = 0, rt = input.length() -1;
//
//        char[] charArray = input.toCharArray();
//
//        while(lt < rt){
//            if(checkAlphabet(input.charAt(lt))) {
//                if(checkAlphabet(input.charAt(rt))){
//                    char tmp = input.charAt(lt);
//                    charArray[lt] = input.charAt(rt);
//                    charArray[rt] = tmp;
//                    lt ++;
//                    rt --;
//                }else{
//                    rt --;
//                }
//                continue;
//            }
//            lt ++;
//        }
//        input = String.valueOf(charArray);
//
//        System.out.println(input);

        /**
         * 강의 참조한 코드
         */
        char[] s = input.toCharArray();
        int lt = 0, rt = input.length() -1;

        while(lt < rt){
            if(!Character.isAlphabetic(s[lt])){
                lt ++;
            }else if(!Character.isAlphabetic(s[rt])){
                rt --;
            }else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
        }

        String answer = String.valueOf(s);
        System.out.println(answer);
    }

    static private boolean checkAlphabet(char alphabet){
        if('a' <= alphabet && alphabet <= 'z' || 'A' <= alphabet && alphabet <= 'Z'){
            return true;
        }
        return false;
    }
}
