import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] p1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            p1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p1);
        n = Integer.parseInt(br.readLine());
        int[] p2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; st.hasMoreTokens(); i++){
            p2[i] = Integer.parseInt(st.nextToken());
        }
        // 이분 탐색
        for(int i = 0; i < p2.length; i++){
            int answer = binarySearch(p1, p2[i]);
            bw.write(answer + " ");
        }
        br.close();
        bw.close();
    }
    public static int binarySearch(int arr[], int target){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid] == target){
                return 1;
            }else if(arr[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return 0;
    }
}
