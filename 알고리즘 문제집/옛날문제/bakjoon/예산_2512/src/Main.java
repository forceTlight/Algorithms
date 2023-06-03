import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static long amount;
    static int answer;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        amount = Long.parseLong(br.readLine());
        binarySearch(0, Arrays.stream(arr).max().getAsInt());
        System.out.println(answer);
    }
    public static void binarySearch(int low, int high){
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(promising(mid)){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
    }
    public static boolean promising(int budget){
        long sum  = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > budget){
                sum += budget;
            }else{
                sum += arr[i];
            }
        }
        if(sum <= amount){
            return true;
        }
        return false;
    }
}
