import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        int n, k;
        int answer = 0;
        int[] row;
        Integer[] tmp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        row = new int[n];
        tmp = new Integer[n-1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            row[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n-1; i++){
            int j = n-i-1;
            tmp[i] = row[j] - row[j-1];
        }
        Arrays.sort(tmp, Collections.reverseOrder());
        for(int i = k-1; i < n-1; i++){
            answer += tmp[i];
        }
        System.out.println(answer);
    }
}
