import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static String[] title;
    static long[] length;
    static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        title = new String[n];
        length = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            title[i] = st.nextToken();
            length[i] = Long.parseLong(st.nextToken());
        }
        for (int j = 0; j < m; j++) {
            int key = Integer.parseInt(br.readLine());
            binarySearch(0, title.length - 1, key);
        }
        bw.flush();
    }

    public static void binarySearch(int low, int high, long key) throws IOException {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (promising(key, mid)) {
                bw.write(title[mid] + "\n");
                return;
            } else if (key > length[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    public static boolean promising(long key, int mid) {
        if (mid == 0) {
            if (length[mid] >= key) {
                return true;
            }
        }else {
            if (length[mid - 1] < key && length[mid] >= key) {
                return true;
            }
        }
        return false;
    }
}