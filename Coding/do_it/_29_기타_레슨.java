package do_it;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _29_기타_레슨 {
    static int n;
    static int m;
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; st.hasMoreTokens(); i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();

        int left = max; int right = sum;
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(getCount(mid) > m){ // 앨범의 갯수가 구할려는 것보다 많이 나왔음 -> 앨범 사이즈를 키워야함
                left = mid + 1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static int getCount(int size){
        int sum = 0;
        int cnt = 1;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum > size){
                sum = arr[i];
                cnt++;
            }
        }

        return cnt;
    }
}