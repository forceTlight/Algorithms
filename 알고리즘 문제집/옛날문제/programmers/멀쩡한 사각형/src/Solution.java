import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer> numList = new ArrayList<>();
    static int m = 1; // 최소 공배수
    static int a;
    static int b;

    public static void main(String args[]) {
        System.out.println(solution(3, 5));
    }

    public static long solution(int w, int h) {
        a = w;
        b = h;
        getNum();
        long width = (long)w * h - ((a + b - 1) * m);
        return width;
    }

    // 최소 공약수 서로소, 공배수 구하기
    public static void getNum() {
        int max = a > b ? a : b;
        for (int i = 2; i <= max; i++) {
            if (a % i == 0) {
                if (!numList.contains(i)) {
                    numList.add(i);
                }
            }
            if (b % i == 0) {
                if (!numList.contains(i)) {
                    numList.add(i);
                }
            }
        }
        // 최소 공배수 구하기
        for (int i = 0; i < numList.size(); i++) {
            int n = numList.get(i);
            if (a % n == 0 && b % n == 0) {
                m = n;
            }
        }
        // 최소 공약수 서로소 구하기
        loop:
        for (int i = 0; i < numList.size(); i++) {
            int n = numList.get(i);
            if (a % n == 0 && b % n == 0) {
                a /= n;
                b /= n;
                i = -1;
            }
        }
    }
}
