import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int c;
    static char[] word;
    static List<Character> vowel = Arrays.asList(new Character[]{'a','e','i','o','u'});
    static boolean[] visit;
    static ArrayList<String> wordArray = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        word = new char[c];
        visit = new boolean[c];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < c; i++) {
            word[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(word);
        dfs(0, 0);
        print();
    }

    public static void dfs(int cnt, int idx) {
        if(cnt == l){
            process();
            return;
        }
        for (int i = idx; i < c; i++) {
            if (visit[i] != true) {
                visit[i] = true;
                dfs(cnt + 1, idx+1);
                visit[i] = false;
            }
        }
    }
    public static void process(){
        int vowel_cnt = 0;
        sb.setLength(0);
        for(int i = 0; i < c; i++){
            if(visit[i]){
                sb.append(word[i]);
            }
        }
        if(!wordArray.contains(sb.toString())){
            for(int i = 0; i < l; i++){
                if(vowel.contains(sb.charAt(i))){
                    vowel_cnt ++;
                }
            }
            if(vowel_cnt >= 1 && vowel_cnt <= l - 2)
                wordArray.add(sb.toString());
        }
    }
    public static void print(){
        for(int i = 0; i < wordArray.size(); i++){
            System.out.println(wordArray.get(i));
        }
    }
}
