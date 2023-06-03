import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int answer = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        while(true){
            int cnt = 0;
            int num = n;
            while(num != 0){
                if(num%2==1){
                    cnt++;
                }
                num /= 2;
            }
            if(cnt<=k){
                break;
            }
            answer++;
            n++;
        }
        System.out.println(answer);
    }
}
