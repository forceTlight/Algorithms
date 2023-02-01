import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2343_기타_레슨 {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        arr = new int[n];
        m = Integer.parseInt(input[1]);

        int sum = 0;
        int max = 0;
        input = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
            max = Math.max(arr[i], max);
            sum += arr[i];
        }

        int left = max, right = sum;
        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            if(checkSize(mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println("" + left);
    }

    public static boolean checkSize(int mid){
        int cnt = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            if(sum + arr[i] > mid){
                cnt ++;
                sum = 0;
            }
            sum += arr[i];
        }
        if(sum != 0)
            cnt++;

        if(cnt <= m)
            return true;
        else
            return false;
    }
}
