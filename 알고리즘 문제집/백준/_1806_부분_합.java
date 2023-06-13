package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1806_부분_합 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

//        int[] S  = new int[n+1];

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int answer = Integer.MAX_VALUE;
        long sum  = 0;
        int lt = 0;
        for(int rt = 0; rt < n; rt++){
            int num = Integer.parseInt(st.nextToken());
            arr[rt] = num;

            sum += num;

            while(lt < rt) {
                if(sum - arr[lt] < s){
                    break;
                }

                sum -= arr[lt++];
            }

            if(sum >= s){
                answer = Math.min(answer, ((rt + 1) - lt));
            }
        }

        answer = answer == Integer.MAX_VALUE? 0: answer;

        System.out.println(answer);
    }
}