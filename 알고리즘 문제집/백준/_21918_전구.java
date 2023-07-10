package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 21918 - 전구
 * 문제유형 : 구현
 * 난이도 : BRONZE 2
 * 풀이시간 : 15분
 */
public class _21918_전구 {
    static boolean[] bulbs;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bulbs = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            bulbs[i] = num == 1;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            switch(a){
                case 1:
                    changeBulb(b, c == 1);
                    break;
                case 2:
                    changeBulb(b, c);
                    break;

                case 3:
                    turnOffBulb(b, c);
                    break;

                case 4:
                    turnOnBulb(b, c);
                    break;
            }
        }

        for(int i = 1; i <= n; i++){
            int status = bulbs[i]? 1 : 0;
            System.out.print(status + " ");
        }
    }

    // 1번 명령어 - i번째 전구 상태를 x로 변경한다.
    public static void changeBulb(int idx, boolean status){
        bulbs[idx] = status;
    }

    // 2번 명령어 - l번째부터 r번째까지의 전구의 상태를 변경한다.
    public static void changeBulb(int l, int r){
        for(int i = l; i <= r; i++){
            bulbs[i] = !bulbs[i];
        }
    }

    // 3번 명령어 - l번째부터 r번째까지의 전구를 끈다.
    public static void turnOffBulb(int l, int r){
        for(int i = l; i <= r; i++){
            bulbs[i] = false;
        }
    }

    // 4번 명령어 - l번째부터 r번째까지의 전구를 킨다.
    public static void turnOnBulb(int l, int r){
        for(int i = l; i <= r; i++){
            bulbs[i] = true;
        }
    }
}