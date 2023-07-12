package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * 20291 - 파일정리
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 5분
 */
public class _20291_파일정리 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for(int i = 0; i < n; i++){
            String fileName = br.readLine();
            String exName = fileName.split("\\.")[1];
            treeMap.put(exName, treeMap.getOrDefault(exName, 0) + 1);
        }

        for(String key : treeMap.keySet()){
            int count = treeMap.get(key);
            System.out.println(key + " " + count);
        }
    }
}