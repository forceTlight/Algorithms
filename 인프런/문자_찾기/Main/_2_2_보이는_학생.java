import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_2_보이는_학생 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int min = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > min){
                min = arr[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
