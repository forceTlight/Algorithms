import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Point{
    int a;
    int b;
    Point(int a, int b){
        this.a = a;
        this.b = b;
    }
}
public class Main {
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];
        visited = new boolean[5][5];
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(st.nextToken());
                findBoardPoint(num);
                int cnt = checkBingo();
                answer++;
                if(cnt >= 3){
                    System.out.println(answer);
                    return;
                }
            }
        }
    }
    public static void findBoardPoint(int num){
        for(int i = 0 ; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i][j] == num){
                    visited[i][j] = true;
                }
            }
        }
    }
    public static int checkBingo(){
        int cnt = 0;
        loop1:
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!visited[i][j])
                    continue loop1;
            }
            cnt++;
        }
        loop2:
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(!visited[j][i])
                    continue loop2;
            }
            cnt++;
        }
        // 좌측 대각선
        int abs = 0;
        loop3:
        for(int i = 0; i < 5; i++){
            if(visited[i][i])
                abs++;
        }
        if(abs>=5)
            cnt++;

        abs = 0;
        // 우측 대각선
        loop4:
        for(int i = 0; i < 5; i++){
            if(visited[i][4-i])
                abs++;
        }
        if(abs>=5)
            cnt++;
        return cnt;
    }
}
