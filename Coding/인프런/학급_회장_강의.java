package 인프런;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 학급_회장_강의 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hashMap = new HashMap<>();

        String s = br.readLine();
        for(char c : s.toCharArray()){
            int cnt = hashMap.getOrDefault(c, 0);
            hashMap.put(c, cnt+1);
        }

        int max = Integer.MIN_VALUE;
        char answer = ' ';
        for(char key: hashMap.keySet()){
            if(max < hashMap.get(key)){
                max = hashMap.get(key);
                answer = key;
            }
        }

        System.out.println(answer);
    }
}