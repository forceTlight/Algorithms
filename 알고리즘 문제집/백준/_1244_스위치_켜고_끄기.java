package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1244 - 스위치 켜고 끄기
 * 문제유형 : 구현
 * 난이도 : SILVER 4
 * 풀이시간 : 30분
 */
public class _1244_스위치_켜고_끄기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] status = new boolean[n+1];

        for(int i = 1; i <= n; i++){
            status[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1){ // 남자라면 배수들 모두 스위치 바꾸기
                for(int j = 1; j <= n; j++){
                    if(j % num == 0)
                        status[j] = !status[j];
                }
            }else{ // 여자라면 스위치와 대칭이면 모두 바꾸기
                status[num] = !status[num];

                int lt = num - 1;
                int rt = num + 1;

                while(lt >= 1 && rt <= n){
                    if(status[lt] == status[rt]){ // 대칭이면 스위치 상태를 바꾼다, 아니면 바로 탈출
                        status[lt] = !status[lt];
                        status[rt] = !status[rt];
                    }else{
                        break;
                    }

                    lt--;
                    rt++;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int ans = status[i]? 1 : 0;
            System.out.print(ans + " ");

            if(i % 20 == 0)
                System.out.println();
        }
    }
}