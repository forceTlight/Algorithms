import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] c = new char[n];
        for(int i = 0; i < n; i++){
            c[i] = input.charAt(i);
        }
        StringTokenizer colorToken;
        int b_cnt = 0;
        int r_cnt = 0;
        colorToken = new StringTokenizer(input, "R");
        while(colorToken.hasMoreTokens()){
            colorToken.nextToken();
            b_cnt++;
        }
        colorToken = new StringTokenizer(input, "B");
        while(colorToken.hasMoreTokens()){
            colorToken.nextToken();
            r_cnt++;
        }
        // 더 작은걸로 카운트 세기
        int answer = 0;
        if(b_cnt < r_cnt){
            answer = b_cnt + 1;
        }else{
            answer = r_cnt + 1;
        }
        System.out.println(answer);
    }
}
