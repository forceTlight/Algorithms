import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static long[] pick = new long[3];
    static long min = Long.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 0; i < n-2; i++){
            binarySearch(i);
        }
        Arrays.sort(pick);
        for(int i = 0; i < 3; i++){
            System.out.print(pick[i] + " ");
        }
    }
    public static void binarySearch(int idx){
        int left = idx+1;
        int right = arr.length - 1;
        while(left < right){
            long sum = arr[left] + arr[right] + arr[idx];
            long absSum = Math.abs(sum);
            if(absSum < min){
                pick[0] = arr[left];
                pick[1] = arr[right];
                pick[2] = arr[idx];
                min = absSum;
            }
            if(sum > 0)
                right --;
            else
                left ++;
        }
    }
}
