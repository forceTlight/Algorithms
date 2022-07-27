import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int value = Integer.MAX_VALUE;
    static int pick1;
    static int pick2;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        binarySearch(0, arr.length - 1);
        System.out.println(pick1 + " " + pick2);
    }

    public static void binarySearch(int left, int right) {
        int sum;
        int tmp;
        while (left < right) {
            sum = arr[left] + arr[right];
            tmp = Math.abs(sum);
            if (tmp < value) {
                value = tmp;
                pick1 = arr[left];
                pick2 = arr[right];
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}
