package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _35_잃어버린_괄호 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int startIdx = 0;
        int answer = 0;
        int tmp = 0;
        boolean check = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-' || c == '+') {
                int num = Integer.parseInt(sb.toString());
                sb.setLength(0);

                if (c == '-') {
                    if(!check){
                        answer += num;
                        check = true;
                    }else{
                        answer = answer - (tmp + num);
                        tmp = 0;
                    }
                } else {
                    if(check){
                        tmp += num;
                    }else{
                        answer += num;
                    }
                }
            } else {
                sb.append(c - '0');
            }
        }

        int num = Integer.parseInt(sb.toString());
        if(check){
            answer -= (tmp+num);
        }else{
            answer += num;
        }
        System.out.println(answer);
    }
}