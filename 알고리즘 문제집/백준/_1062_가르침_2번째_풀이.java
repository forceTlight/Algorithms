package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 1062 - 가르침
 * 유연한 백트래킹
 */
public class _1062_가르침_2번째_풀이 {
    static int n;
    static int k;
    static String[] words;
    static HashSet<Character> alphabetSet;
    static int answer = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];
        alphabetSet = new HashSet<>();

        for(int i = 0; i < n; i++){
            words[i] = br.readLine().replace("a","").replace("c","").replace("n","")
                    .replace("t","").replace("i","");
        }

        if(k < 5){
            System.out.println(0);
            return;
        }

        k -= 5;

        alphabetSet.add('a');
        alphabetSet.add('c');
        alphabetSet.add('n');
        alphabetSet.add('t');
        alphabetSet.add('i');

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int idx){
        if(depth == k){
            int cnt = 0;
            loop:
            for(int i = 0; i < words.length; i++){
                String word = words[i];
                for(int j = 0; j < word.length(); j++){
                    char c = word.charAt(j);
                    if(!alphabetSet.contains(c))
                        continue loop;
                }
                cnt++;
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for(int i = idx; i <= 26; i++){
            char alphabet = (char)('a' + i);
            if(!alphabetSet.contains(alphabet)){
                alphabetSet.add(alphabet);
                dfs(depth + 1, i + 1);
                alphabetSet.remove(alphabet);
            }
        }

    }
}