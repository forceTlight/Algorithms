import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String arsg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        int sum = 0;
        for(int i = 0; i < n; i++){
            int tmp_sum = 0;
            for(int j = 0; j <= i; j++){
                tmp_sum += p[j];
            }
            sum += tmp_sum;
        }
        System.out.println(sum);
    }
}
