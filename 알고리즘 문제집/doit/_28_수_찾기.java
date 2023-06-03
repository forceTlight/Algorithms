package doit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _28_수_찾기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; st.hasMoreTokens(); i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] targetArr = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; st.hasMoreTokens(); i++){
            targetArr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        // 이분 탐색
        for(int i = 0; i < m; i++){
            long key = targetArr[i];

            int left = 0;
            int right = n-1;

            int answer = 0;
            while(left <= right){
                int mid = (left + right) / 2;
                if(arr[mid] < key){
                    left = mid + 1;
                }else if(arr[mid] > key){
                    right = mid - 1;
                }else{
                    answer = 1;
                    break;
                }
            }

            bw.write(answer + "\n");
        }

        bw.flush();
    }
}