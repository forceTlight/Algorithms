import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_10_봉우리 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,0, -1, 1};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){

            loop:
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 4; k++){
                    int num = arr[i][j];

                    int a = i + dy[k];
                    int b = j + dx[k];
                    if(a >= 0 && a < n && b >= 0 && b < n){
                        if(num <= arr[a][b])
                            continue loop;
                    }
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
