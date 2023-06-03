import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] line;
    static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        line = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            line[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(line);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            long min = Long.parseLong(st.nextToken());
            long max = Long.parseLong(st.nextToken());
            binarySearch(min, max);
        }
        bw.flush();
    }
    public static void binarySearch(long min, long max) throws IOException {
        int low = 0; int high = line.length-1;
        int mid;
        int leftIndex = 0;
        int rightIndex = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(line[mid] < min){
                low = mid + 1;
            }else if(line[mid] >= min){
                high = mid - 1;
            }
        }
        leftIndex = low;
        low = 0; high = line.length-1;
        while(low <= high){
            mid = (low + high) / 2;
            if(line[mid] <= max){
                low = mid + 1;
            }else if(line[mid] > max){
                high = mid - 1;
            }
        }
        rightIndex = high + 1;
        int answer = rightIndex - leftIndex;
        bw.write(answer + "\n");
    }
}
