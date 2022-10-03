import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자_찾기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.toUpperCase();

        char c = br.readLine().charAt(0);
        c = Character.toUpperCase(c);

        int cnt = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == c){
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}
