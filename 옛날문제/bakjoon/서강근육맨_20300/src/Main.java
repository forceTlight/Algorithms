import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long machine[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            machine[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(machine);
        long last = 0;
        int c = 0;
        if(machine.length % 2 != 0){
            last = machine[machine.length-1];
            c = 1;
        }
        long max = Long.MIN_VALUE;
        long sum;
        for(int i = 0; i < machine.length/2; i++){
            sum = machine[i] + machine[machine.length-1-i-c];
            max = Math.max(sum, max);
        }
        max = Math.max(max, last);
        System.out.println(max);
    }
}
