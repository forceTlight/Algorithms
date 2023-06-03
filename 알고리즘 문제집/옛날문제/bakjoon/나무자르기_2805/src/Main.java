import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long trees[];
    static long answer = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        trees = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        binarySearch(0, 1000000000);
        System.out.println(answer);
    }

    public static void binarySearch(long low, long high) {
        long mid;
        if (low <= high) {
            mid = (low + high) / 2;
            if (isPossible(mid)) {
                binarySearch(mid+1, high);
                answer = Math.max(mid, answer);
            }else{
                binarySearch(low, mid-1);
            }
        }
    }

    public static boolean isPossible(long height) {
        int sum = 0;
        for (int i = 0; i < trees.length; i++) {
            if (trees[i] <= height)
                continue;
            sum += trees[i] - height;
            if (sum >= m)
                return true;
        }
        return false;
    }
}
