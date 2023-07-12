package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 22858 - 원상 복구 (Small)
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 30분
 */
public class _22858_원상복구_Small {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] S = new int[n]; // 셔플된 카드
        int[] D = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 원상 복구
        // i번째 카드를 S[D[i]]번로 위치시키는 작업을 반복하면 됨

        int[] P = new int[n];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                int d = D[j] - 1;
                P[d] = S[j];
            }

            for(int j = 0; j < n; j++){
                S[j] = P[j];
            }
        }

        for(int i = 0; i < n; i++)
            System.out.print(P[i] + " ");
    }
}