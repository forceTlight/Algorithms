import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    수들의 합_1789_이분 탐색
 */
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;
        for(int i = 1; ; i++){
            if(sum > n)
                break;
            sum += i;
            cnt++;
        }
        System.out.println(cnt-1);
    }
}
