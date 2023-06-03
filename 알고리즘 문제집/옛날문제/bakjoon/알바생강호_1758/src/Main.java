import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p[] = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(p);
        long sum = 0;
        for(int i = p.length -1; i >= 0; i--){
            int v = p[i] - (p.length - i - 1) ;
            if(v <= 0)
                break;
            sum += v;
        }
        System.out.println(sum);
    }
}
