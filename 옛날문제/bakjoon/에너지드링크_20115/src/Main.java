import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] drink = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for(int i = 0; i < n; i++){
            drink[i] = Integer.parseInt(st.nextToken());
            if(max < drink[i])
                max = drink[i];
        }
        double sum = 0;
        for(int v: drink){
            if(max != v){
                sum += (float)v/2;
            }
        }
        sum += max;
        System.out.println(sum);
    }
}
