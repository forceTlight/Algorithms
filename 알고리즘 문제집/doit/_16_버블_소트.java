package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Data implements Comparable<Data> {
    int index;
    int value;

    public Data(int index, int value){
        this.index = index;
        this.value = value;
    }

    // value 값 기준으로 오름차순 정렬
    @Override
    public int compareTo(Data o) {
        return value - o.value;
    }
}
public class _16_버블_소트 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Data[] data = new Data[n];

        for(int i = 0; i < n; i++){
            data[i] = new Data(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(data); // value 값 기준으로 오름차순 정렬 (value는 정렬되기 전 값)

        // max 값 찾기
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(data[i].index - i, max);
        }

        System.out.println(max+1);
    }
}