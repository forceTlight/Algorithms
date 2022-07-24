import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long answer;
    static long n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        binarySearch(0, (long) Math.sqrt(n));
        if(answer * answer < n)
            answer ++;
        System.out.println(answer);
    }
    public static void binarySearch(long low, long high) {
        if (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid >= n || mid < 0) {
                binarySearch(low, mid -1);
            }else{
                answer = mid;
                binarySearch(mid + 1, high);
            }
        }
    }
}
