import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _4_문자_찾기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> answers = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for(int i = 0; i < n; i++)
            input[i] = br.readLine();

        for(String x : input){
            char[] s = x.toCharArray();
            int left = 0, right = x.length() - 1;
            while(left < right){
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left ++;
                right --;
            }
            answers.add(String.valueOf(s));
        }

        for(int i = 0; i < n; i++){
            System.out.println(answers.get(i));
        }
    }
}
