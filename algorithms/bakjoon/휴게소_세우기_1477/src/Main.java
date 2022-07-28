import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int l;
    static int[] rest;
    static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        rest = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            rest[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rest);
        binarySearch(100, 1000);
        System.out.println(max);
    }
    public static void binarySearch(int low, int high){
        int mid;
        while(low <= high){
            mid = (low + high)/2;
            if(isPromising(mid)){
                low = mid + 1;
                max = Math.max(max, mid);
            }else{
                high = mid - 1;
            }
        }
    }
    public static boolean isPromising(int key){
        int cnt = 0;
        int distance;
        for(int i = 0; i < n-1; i++){
            distance = (rest[i+1] - rest[i]) / 2;
            if(distance <= key)
                cnt++;
        }
        if(cnt >= m)
            return true;
        return false;
    }
}
