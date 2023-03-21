package 인프런.sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장난꾸러기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] rootArr = arr.clone();

        int chul = 0;
        int couple = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != rootArr[i]){
                if(chul == 0)
                    chul = i+1;
                else
                    couple = i+1;
            }
        }
        bw.write(chul + " " + couple);
        bw.flush();
    }
}