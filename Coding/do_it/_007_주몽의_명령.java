package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _007_주몽의_명령 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;

        int answer = 0;

        while(lt < rt){
            int sum  = arr[lt] + arr[rt];
            if(sum > m){
                rt--;
            }else if(sum < m){
                lt++;
            }else{
                lt++;
                rt--;
                answer++;
            }
        }

        System.out.println(answer);
    }
}