package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1062_가르침 {
    static int k;
//    static boolean[] alpha;
    static String[] words;
    static HashSet<Character> hashSet;
    static int answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

//        alpha = new boolean[26];
        hashSet = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(k < 5){
            System.out.println(0);
            return;
        }

        k -= 5;

        // anta tica => a, t, i, c, n
//        alpha['a' - 'a'] = true;
//        alpha['c' - 'a'] = true;
//        alpha['n' - 'a'] = true;
//        alpha['t' - 'a'] = true;
//        alpha['i' - 'a'] = true;
        hashSet.add('a');
        hashSet.add('c');
        hashSet.add('n');
        hashSet.add('t');
        hashSet.add('i');

        words = new String[n];

        for(int i = 0; i < n; i++){
            String word = br.readLine();
            word = word.replace("a", "").replace("c", "").replace("n", "")
                    .replace("t", "").replace("i", "");
            words[i] = word;
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int idx){
        if(depth == k) {
            // 결과값 갱신
            int cnt = 0;

            loop:
            for(int i = 0; i < words.length; i++){
                String word = words[i];
                for(int j = 0; j < word.length(); j++){
                    char c = word.charAt(j);
                    if(!hashSet.contains(c))
                        continue loop;
                }

                cnt++;
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for(int i = idx; i <= 26; i++){
            char c = (char) ('a' + i);
            if(!hashSet.contains(c)){
                hashSet.add(c);
                dfs(depth + 1, i + 1);
                hashSet.remove(c);
            }
        }
    }
}