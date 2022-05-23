import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Shark{
    int a, b, size;
    Shark(int a, int b){
        this.a = a;
        this.b = b;
    }
    Shark(int a, int b, int size){
        this.a = a;
        this.b = b;
        this.size = size;
    }
    int getA(){
        return a;
    }
    int getB(){
        return b;
    }
    int getSize(){
        return size;
    }
    void growUp(){
        this.size++;
    }
    boolean checkEat(int fishSize){
        if(size > fishSize){
            return true;
        }else{
            return false;
        }
    }
    boolean checkPass(int fishSize){
        if(size >= fishSize){
            return true;
        }else{
            return false;
        }
    }
}
public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] distance;
    static int n;
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        distance = new int[n][n];
        int a = 0, b = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9){
                    a = i;
                    b = j;
                }
            }
        }
        bfs(a, b);
    }
    static void bfs(int aa, int bb){
        Queue<Shark> q = new LinkedList<>();
        q.offer(new Shark(aa, bb, 2));
        while(!q.isEmpty()){
            Shark shark = q.poll();
            int a = shark.getA();
            int b = shark.getB();
            int size = shark.getSize();
            for(int i = 0; i < 4; i++){
                int x = a + dx[i];
                int y = b + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < n){
                    if(size < arr[x][y]) // 물고기의 크기가 클 경우 무시
                        continue;
                    if(size == arr[x][y]){ // 물고기의 크기가 같을 경우 통과
                        distance[x][y] = distance[a][b] + 1;
                    }else if()
                }
            }
        }
    }
}
