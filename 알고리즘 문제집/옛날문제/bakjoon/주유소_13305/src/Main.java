import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int distance[] = new int[n-1];
        int price[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < price.length; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }
        int idx = 0;
        long sum = 0;
        while(true){
            if(idx == price.length-1)
                break;
            int min = price[idx];
            int prev_idx = idx;
            for(int i = idx+1; i < price.length; i++){
                if(min >= price[i]){
                    idx = i;
                    min = price[i];
                    break;
                }else if(i == price.length-1){
                    idx = price.length-1;
                    break;
                }
            }
            long distance_sum = 0;
            for(int i = prev_idx; i < idx; i++){
                distance_sum += distance[i];
            }
            sum += price[prev_idx] * distance_sum;
        }
        System.out.println(sum);
    }
}
