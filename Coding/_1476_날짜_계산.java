import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1476_날짜_계산 {
    static int e, s, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        e = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);

        int cnt = 0;

        int a = 0, b = 0, c = 0;
        while(e != a || b != s || c != m){
            a = a  % 15 + 1;
            b = b % 28 + 1;
            c = c % 19 + 1;

            cnt ++;
        }

        System.out.println(cnt);
    }
}
