import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정사각형의_개수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long sum = 0;
        for(int i = 1; i <= n; i++){
            sum += (long) i * i;
        }

        System.out.println(sum);
    }
}