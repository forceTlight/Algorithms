import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String args[]) throws IOException {
        int max = 0; int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rope[] = new int[n];
        int range = rope.length-1;
        for(int i = 0; i < n; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        for(int i = 0; i < rope.length; i++){
            int weight = rope[range - i] * (i+1);
            if(weight > max){
                max = weight;
            }
        }
        System.out.println(max);
    }
}
