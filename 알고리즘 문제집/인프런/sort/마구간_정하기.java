package 인프런.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

    public class 마구간_정하기 {
        static int[] arr;
        static int n;
        static int m;

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            int left = 0;
            int right = arr[arr.length-1] - arr[0];
            int answer = 0;

            while(left <= right){
                int mid = (left + right) / 2; // mid는 distance이다.
                if(getCount(mid) >= m){
                    answer = mid;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

            System.out.println(answer);
        }

        public static int getCount(int distance){
            int cnt = 1;
            int ep = arr[0];
            for(int i = 1; i < arr.length; i++){
                if(arr[i] - ep >= distance){
                    cnt++;
                    ep = arr[i];
                }
            }

            return cnt; // cnt는 말의 갯수이다. -> 말의 갯수가 작으면 distance 감소시켜야함
        }
    }