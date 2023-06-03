import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int arr[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        m = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = -1;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            right = Math.max(right, arr[i]);
        }

        while(left < right){
            int mid = (left + right) / 2;
            if(solve(mid) <= m){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
    public static int solve(int mid){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int cnt  = 1; // 구간의 갯수를 의미 함
        for(int i = 0; i < n; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if(max - min > mid){
                cnt++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--; // 하나 이상의 연속된 수로 하나만 포함할 수 있어서 i - 1
            }
        }
        return cnt;
    }
}
