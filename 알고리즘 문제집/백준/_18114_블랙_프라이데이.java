package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _18114_블랙_프라이데이 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        boolean check = false;

        loop:
        for(int i = 0; i < n; i++){
            int tmp = arr[i];
            if(tmp == c){
                check = true;
                break;
            }else if(tmp > c){
                break;
            }
            for(int j = i + 1; j < n; j++){
                tmp = arr[i] + arr[j];
                if(tmp == c){
                    check = true;
                    break;
                }else if(tmp > c)
                    break;


                if(j == n - 1)
                    break;

                // binarySearch
                int left = j+1;
                int right = n - 1;

                while(left <= right){
                    int mid = (left + right) / 2;
                    if(tmp + arr[mid] > c){
                        right = mid - 1;
                    }else if(tmp + arr[mid] < c){
                        left = mid + 1;
                    }else{
                        check = true;
                        break loop;
                    }
                }
            }
        }

        if(check){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}