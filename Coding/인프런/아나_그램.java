package 인프런;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 아나_그램 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        for(char c : s1.toCharArray()){
            int cnt = s1Map.getOrDefault(c, 0);
            s1Map.put(c, cnt+1);
        }

        for(char c : s2.toCharArray()){
            int cnt = s2Map.getOrDefault(c, 0);
            s2Map.put(c, cnt+1);
        }

        for(char c : s1Map.keySet()){
            if(s1Map.get(c) != s2Map.get(c)){
                System.out.println("NO");
                return;
            }
        }

        for(char c : s2Map.keySet()){
            if(s2Map.get(c) != s1Map.get(c)){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}