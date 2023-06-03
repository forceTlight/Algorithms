import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int cnt = 0;
        while(b!=a){
            StringBuilder sb = new StringBuilder(Long.toString(b));
            if(b % 2 == 0){
                b = b/2;
                cnt++;
            }else if(sb.charAt(sb.length()-1) == '1' && b > a){
                sb.deleteCharAt(sb.length()-1);
                b = Long.parseLong(sb.toString());
                cnt++;
            }else{
                cnt = -2;
                break;
            }
        }
        System.out.println(cnt+1);
    }
}
