package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 17413 - 단어 뒤집기 2
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 30분
 */
public class _17413_단어_뒤집기_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '<'){
                while(c != '>'){
                    answer.append(c);
                    i++;
                    c = input.charAt(i);
                }

                answer.append(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(c != ' ' && c != '<'){
                    sb.append(c);
                    i++;

                    if(i >= input.length())
                        break;

                    c = input.charAt(i);
                }

                answer.append(sb.reverse());

                if(c == '<')
                    i--;
                else if(c == ' ')
                    answer.append(' ');
            }
        }

        System.out.println(answer);
    }
}