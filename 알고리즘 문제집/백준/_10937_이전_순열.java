package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 10937 - 이전 순열
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 2시간
 */
public class _10937_이전_순열 {
    static int swapA;
    static int swapB;
    static boolean check = false;
    static ArrayList<Integer> arrayList;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arrayList.add(num);
            arr[i] = num;
        }

        dfs(0, n - 1);


        //swap
        int num1 = arrayList.get(swapA);
        int num2 = arrayList.get(swapB);

        arr[swapA] = num2;
        arr[swapB] = num1;

        // j+1 이후 구간을 내림차순으로 채워넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int k = swapB + 1; k < n; k++) {
            pq.offer(arr[k]);
        }

        // 내림차순 반영하기
        int k = swapB + 1;
        while (!pq.isEmpty()) {
            int num = pq.poll();
            arr[k++] = num;
        }

        if (!check) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void dfs(int maxIdx, int idx) {
        if (maxIdx >= idx)
            return;

        int num1 = arrayList.get(idx); // num1이 오른쪽에 있음 (더작은수)
        for (int i = idx - 1; i >= maxIdx; i--) {
            int num2 = arrayList.get(i);
            if (num2 > num1) {
                check = true;
                swapA = idx;
                swapB = i;
                dfs(i + 1, idx - 1);
                return;
            }
        }

        dfs(maxIdx, idx - 1);
    }
}