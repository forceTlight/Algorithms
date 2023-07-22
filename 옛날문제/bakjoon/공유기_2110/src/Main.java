import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static Integer[] network;
    static int c;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        network = new Integer[n];
        for(int i = 0; i < n; i++){
            network[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(network);
        System.out.println(binarySearch(0, network[network.length-1]));
    }
    public static int binarySearch(int low, int high){
        // mid는 거리를 의미함
        int mid;
        int max = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(isPromising(mid)){
                low = mid+1;
                max = Math.max(max, mid);
            }else{
                high = mid-1;
            }
        }
        return max;
    }
    public static boolean isPromising(int distance){
        int prev = network[0];
        int cnt = 0;
        for(int i = 1; i < network.length; i++){
            if(network[i] - prev >= distance){
                prev = network[i];
                cnt++;
            }else{
                continue;
            }
        }
        cnt = cnt+1;
        if(cnt < c)
            return false;
        return true;
    }
}
