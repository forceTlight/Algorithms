import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근묵자흑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        int sum = 0;
        for(int i = 0; i < n ; i++){
            if(sum >= n-1)
                break;

            sum += k-1;
            count++;
        }

        System.out.println(count);
    }
}