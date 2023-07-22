import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map = new char[500][500];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 공백으로 초기화
        for(int i = 0; i < 4 * (n-1) + 1; i++){
            for(int j = 0; j < 4 * (n-1) + 1; j++){
                map[i][j] = ' ';
            }
        }
        drawStar(0, 0, n);

        // 그리기
        for(int i = 0; i < 4 * (n-1) + 1; i++){
            for(int j = 0; j < 4 * (n-1) + 1; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void drawStar(int x, int y, int n){
        if(n == 1){
            map[x][y] = '*';
            return;
        }
        int len = 4 * (n-1) + 1;
        // 좌 , 우
        for(int i = x; i < x + len; i++){
            map[y][i] = '*';
            map[y + len - 1][i] = '*';
        }

        // 상, 하
        for(int i = y; i < y + len; i++){
            map[i][x] = '*';
            map[i][x + len - 1] = '*';
        }

        drawStar(x + 2, y + 2, n - 1);
    }
}
