package 인프런.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 모든_아나그램_찾기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        HashMap<Character, Integer> anaMap = new HashMap<>();
        // 아나그램 문자열 맵에 넣기
        for(int i = 0; i < t.length(); i++){
            anaMap.put(t.charAt(i), anaMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int window = t.length();
        int answer = 0;

        boolean flag = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(i == window - 1)
                flag = true;
            if(i >= window){
                char wc = s.charAt(i - window);
                if(map.get(wc) == 1)
                    map.remove(wc);
                else
                    map.put(wc, map.get(wc) - 1);
            }

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(flag){
                boolean check = true;
                for(char key : anaMap.keySet()){
                    if(map.getOrDefault(key, 0).intValue() !=  anaMap.get(key).intValue()){
                        check = false;
                        break;
                    }
                }
                if(check)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}