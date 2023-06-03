package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _008_좋다 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for(int i = 0; i < arr.length; i++){
            int lt = 0; int rt = n-1;
            while(lt < rt){
                if(arr[lt] + arr[rt] < arr[i])
                    lt++;
                else if(arr[lt] + arr[rt] > arr[i])
                    rt--;
                else { // 같을 때
                    // 서로 다른 수의 합인지 체크
                    if(lt != i && rt != i){
                        answer ++;
                        break;
                    }
                    else if(lt == i)
                        lt++;
                    else
                        rt--;
                }
            }
        }
        System.out.println(answer);
    }
}