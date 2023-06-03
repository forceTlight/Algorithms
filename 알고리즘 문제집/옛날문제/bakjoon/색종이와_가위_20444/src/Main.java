import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long n;
    static long k;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
        if(binarySearch(0, n)){
            bw.write("YES");
        }else{
            bw.write("NO");
        }
        bw.flush();
    }
    public static boolean binarySearch(long left, long right){
        long mid;
        long num;
        while(left <= right){
            mid = (left + right) / 2;
            num = (mid+1) * (n-mid+1);
            if(num == k){
                return true;
            }
            if(num > k){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
