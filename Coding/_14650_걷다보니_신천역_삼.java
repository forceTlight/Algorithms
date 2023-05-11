import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14650_걷다보니_신천역_삼 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;

        if(n == 1){
            System.out.println(answer);
        }else{
            answer = (int) Math.pow(3, n - 2) * 2;
            System.out.println(answer);
        }

    }
}