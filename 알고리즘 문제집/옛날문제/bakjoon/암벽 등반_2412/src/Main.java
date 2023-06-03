import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> rock[] = new ArrayList[200001];
    static int T;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 200001; i++){
            rock[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rock[b].add(a);
        }
        for(int i = 0; i < 200001; i++){
            Collections.sort(rock[i]);
        }
        System.out.println(bfs());
    }
    public static int bfs(){
        int move = 0;
        // bfs
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        while(!q.isEmpty()){
            for(int i = 0; i < q.size(); i++){
                Point point = q.poll();
                int a = point.getA();
                int b = point.getB();
                if(b == T)
                    return move;
                for(int y = b - 2; y <= b + 2; y++){
                    if(y < 0 || y >= 200001)
                        continue;
                    for(int j = 0; j < rock[y].size(); j++){
                        int x = rock[y].get(j);
                        if (a + 2 < x)
                            break;
                        else if(a - 2 > x)
                            continue;

                        rock[y].remove(j);
                        q.add(new Point(x, y));
                        j--;
                    }
                }
            }
            move++;
        }
        return -1;
    }
}
class Point{
    int a, b;
    Point(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
}