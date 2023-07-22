import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n, m;
    static int max = 0;
    static int cnt = 0;
    static ArrayList<Character> list = new ArrayList<>();
    static char map[][];
    static boolean visit[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bf.readLine(), " ");
            String input = st.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = input.charAt(j);
            }
        }
        dfs(0, 0, new ArrayList<>());
        System.out.println(max);
    }
    public static void dfs(int x, int y, ArrayList<Character> list){
        visit[x][y] = true;
        char ch = map[x][y];
        list.add(ch);
        for(int i = 0; i < 4; i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if(a >= 0 && a < n && b >= 0 && b < m){
                char c = map[a][b];
                if(!list.contains(c) && !visit[a][b]){
                    dfs(a, b, list);
                }
            }
        }
        max = Math.max(max, list.size());
        list.remove(Character.valueOf(ch));
        visit[x][y] = false;
    }
}
