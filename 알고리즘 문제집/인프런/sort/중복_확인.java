package 인프런.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 중복_확인 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        String answer = "U";
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1]){
                answer = "D";
                break;
            }
        }

        bw.write(answer);
        bw.flush();
    }
}