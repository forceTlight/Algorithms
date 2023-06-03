package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1025_제곱수_찾기 {
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int answer = -1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = -n+1; k < n; k++){
                    for(int l = -m+1; l < m; l++){
                        if(k == 0 && l == 0)
                            continue;

                        int a = i;
                        int b = j;

                        StringBuilder sb = new StringBuilder();
                        while(a >= 0 && a < n && b >= 0 && b < m){
                            sb.append(arr[a][b]);

                            int num = Integer.parseInt(sb.toString());
                            int sqrtNum = (int) Math.sqrt(num);
                            if(num == sqrtNum * sqrtNum)
                                answer = Math.max(answer, (int) num);

                            a += k;
                            b += l;
                        }
                    }
                }
            }
        }

        // n, m이 1일 경우 따로 검사
        if(n == 1 && m == 1){
            int sqrtNum = (int) Math.sqrt(arr[0][0]);
            if(arr[0][0] == sqrtNum * sqrtNum)
                answer = arr[0][0];
        }

        System.out.println(answer);
    }
}