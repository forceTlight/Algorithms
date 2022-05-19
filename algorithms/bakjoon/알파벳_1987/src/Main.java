import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int idx;
    int distance;
    static ArrayList<Character> c_list = new ArrayList<>();
    public Node(int idx, int distance, ArrayList<Character> c_list){
        this.idx = idx;
        this.distance = distance;
    }
    public int getIdx(){
        return idx;
    }
    public int getDistance(){
        return distance;
    }
    public ArrayList<Character> getList(){
        return c_list;
    }
}

public class Main {
    static int n, m;
    static char map[][];
    static int visit[][];
    //static int[][] map_cnt;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            String input = st.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = input.charAt(j);
            }
        }
        System.out.println(bfs());
    }
    public static int bfs() {
        int max = 1;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Character> c_list = new ArrayList<>();
        c_list.add(map[0][0]);
        q.offer(new Node(0, 0, c_list));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int a = node.getIdx();
            int b = node.getDistance();
            ArrayList<Character> list = (ArrayList<Character>) node.getList().clone();
            for (int i = 0; i < 4; i++) {
                int x = a + dx[i];
                int y = b + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    char tmp_c = map[x][y];
                    if (!list.contains(tmp_c) && visit[x][y] != 1) {
                        list.add(tmp_c);
                        q.offer(new Node(x, y, list));
                        visit[x][y] = 1;
                        if(max > list.size())
                            max = list.size();
                    }
                }
            }
        }
        return max;
    }
}
