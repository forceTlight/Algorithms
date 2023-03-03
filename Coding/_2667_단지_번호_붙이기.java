import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Point1 {
    int x;
    int y;
    Point1(int y, int x){
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class _2667_단지_번호_붙이기 {
    static int answer = 0;
    static List<Integer> house = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)))   ;
            }
        }

        Queue<Point1> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    queue.add(new Point1(i, j));
                    visited[i][j] = true;
                    int houseCount = 0;

                    while(!queue.isEmpty()){
                        Point1 p = queue.poll();
                        int x = p.getX();
                        int y = p.getY();

                        for(int k = 0; k < 4; k++){
                            int a = y + dy[k];
                            int b = x + dx[k];
                            if(a >= 0 && a < n && b >= 0 && b < n && arr[a][b] == 1 && !visited[a][b]){
                                queue.add(new Point1(a, b));
                                visited[a][b] = true;
                            }
                        }
                        houseCount ++;
                    }
                    house.add(houseCount);
                    answer ++;
                }
            }
        }
        Collections.sort(house);

        // result
        System.out.println(answer);
        house.forEach(System.out::println);
    }
}
