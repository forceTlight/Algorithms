package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * 2108 - 통계학
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 30분
 */
public class _2108_통계학 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // 최빈값 구하기 용도

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            sum += arr[i];
            treeMap.put(arr[i], treeMap.getOrDefault(arr[i], 0) + 1);

            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        int avg = (int) Math.round((double) sum / n); // 평균
        int mid = arr[n/2]; // 중앙값
        int frequency = 0; // 최빈값
        int diff = max - min; // 범위

        // 최빈값 구하기
        int maxNum = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int key : treeMap.keySet()){
            maxNum = Math.max(maxNum, treeMap.get(key));
        }
        // 리스트에 넣기
        for(int key : treeMap.keySet()){
            if(treeMap.get(key) == maxNum)
                arrayList.add(key);
        }
        if(arrayList.size() >= 2)
            frequency = arrayList.get(1);
        else
            frequency = arrayList.get(0);

        // 1. 산술평균 출력 (소수점 첫째 자리에서 반올림)
        System.out.println(avg);

        // 2. 중앙값 출력
        System.out.println(mid);

        // 3. 최빈값 출력 (여러개 있을 때는 최빈 값 중 두번째로 작은 값을 출력)
        System.out.println(frequency);

        // 4. 범위 출력
        System.out.println(diff);
    }
}