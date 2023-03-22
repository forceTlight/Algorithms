package 인프런.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 뮤직_비디오 {
    static int[] arr;
    static int n;
    static int m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];      
        }
        int answer = Integer.MAX_VALUE;

        int left = Arrays.stream(arr).max().getAsInt();
        int right = sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = getCount(mid);
            if(count > m){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }

    public static int getCount(int key) {
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum > key){
                cnt++;
                sum = arr[i];
            }
        }

        return cnt;
    }
}