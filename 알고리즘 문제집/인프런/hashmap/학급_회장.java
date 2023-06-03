package 인프런.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 학급_회장 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hashMap = new HashMap<>();

        hashMap.put('A', 0);
        hashMap.put('B', 0);
        hashMap.put('C', 0);
        hashMap.put('D', 0);
        hashMap.put('E', 0);

        String input = br.readLine();
        char answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            int cnt = hashMap.get(c);
            hashMap.put(c, ++cnt);

            if(cnt > max){
                answer = c;
                max = cnt;
            }
        }

        System.out.println(answer);
    }
}