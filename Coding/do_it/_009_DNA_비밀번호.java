package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _009_DNA_비밀번호 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // window

        String s = br.readLine();

        st = new StringTokenizer(br.readLine(), " ");

        HashMap<Character, Integer> pwdMap = new HashMap<>();
        pwdMap.put('A', Integer.parseInt(st.nextToken()));
        pwdMap.put('C', Integer.parseInt(st.nextToken()));
        pwdMap.put('G', Integer.parseInt(st.nextToken()));
        pwdMap.put('T', Integer.parseInt(st.nextToken()));

        HashMap<Character, Integer> map = new HashMap<>();
        boolean check = false;
        int answer = 0;

        loop:
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(i == m-1)
                check = true;
            if(i >= m){
                char bc = s.charAt(i-m);
                if(map.get(bc) == 1)
                    map.remove(bc);
                else
                    map.put(bc, map.get(bc) - 1);
            }

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(check){
                for(char pwd: pwdMap.keySet()){
                    if(pwdMap.get(pwd) > map.getOrDefault(pwd, 0))
                        continue loop;
                }
                answer++;
            }
        }

        System.out.println(answer);
    }
}