import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] sale = new Integer[n];
        for(int i = 0; i < n; i++){
            sale[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(sale, Comparator.reverseOrder());
        long sum = 0;
        for(int i = 0; i < sale.length; i++){
            if(i % 3 == 0){
                continue;
            }
            sum += sale[i];
        }
        System.out.println(sum);
    }
}
