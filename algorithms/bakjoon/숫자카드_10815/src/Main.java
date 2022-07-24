import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            p1[i] = Integer.parseInt(st.nextToken());
        }
        n = Integer.parseInt(br.readLine());
        int[] p2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; st.hasMoreTokens(); i++){
            p2[i] = Integer.parseInt(st.nextToken());
        }
        // 이분 탐색
    }
    public static int binarySearch(int arr[], int target){
        ddd
    }
}
