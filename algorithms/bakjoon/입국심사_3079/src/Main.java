import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] times;
    static long m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        times = new long[n];
        for (int i = 0; i < n; i++) {
            times[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(times);
        System.out.println(binarySearch(0, Long.MAX_VALUE));
    }
    public static long binarySearch(long low, long high){
        long answer = Long.MAX_VALUE;
        long mid;
        while(low <= high){
            mid = (low + high) / 2;
            if(isPromising(mid)){
                high = mid - 1;
                answer = Math.min(mid, answer);
            }else{
                low = mid + 1;
            }
        }
        return answer;
    }
    public static boolean isPromising(long minTime){
        long sum = 0;
        for(int i = 0; i < times.length; i++){
            sum += minTime / times[i];
            if(sum >= m)
                return true;
        }
        return false;
    }
}
