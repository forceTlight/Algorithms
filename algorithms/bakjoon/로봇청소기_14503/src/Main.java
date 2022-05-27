import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    direct - 0-북 1-동 2-남 3-서
 */
class Cleaner {
    int a, b;
    int direct; // 바라보는 방향
    int cnt = 0; // 회전한 횟수

    Cleaner(int a, int b, int direct) {
        this.a = a;
        this.b = b;
        this.direct = direct;
    }

    void setDirect(int direct) {
        this.direct = direct;
    }

    void turn() {
        this.direct--;
        if (direct < 0)
            direct = 3;
        cnt++;
    }

    boolean checkFoward() {
        int tmp_a = a;
        int tmp_b = b;
        switch (direct) {
            case 0:
                tmp_a++;
            case 1:
                tmp_b++;
            case 2:
                tmp_a--;
            case 3:
                tmp_b--;
        }
        ;
        if (tmp_a > 0 && tmp_a < Main.n && tmp_b < Main.m)
            return false;
        if (Main.map[tmp_a][tmp_b] == 1)
            return false;
        a = tmp_a;
        b = tmp_b;
        return true;
    }
    boolean checkBack(){
        int tmp_a = a;
        int tmp_b = b;
        switch (direct) {
            case 0:
                tmp_a--;
            case 1:
                tmp_b--;
            case 2:
                tmp_a++;
            case 3:
                tmp_b++;
        }
        ;
        if (tmp_a > 0 && tmp_a < Main.n && tmp_b < Main.m)
            return false;
        if (Main.map[tmp_a][tmp_b] == 1)
            return false;
        a = tmp_a;
        b = tmp_b;
        return true;
    }
    int getA() {
        return a;
    }

    int getB() {
        return b;
    }

}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        st = new StringTokenizer(bf.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int direct = Integer.parseInt(st.nextToken());
        Cleaner cleaner = new Cleaner(a, b, direct);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(cleaner);
    }

    public static void bfs(Cleaner cleaner) {
        Queue<Cleaner> q = new LinkedList<>();
        q.offer(cleaner);
        while (!q.isEmpty()) {
            int a = cleaner.getA();
            int b = cleaner.getB();
            int direct = cleaner.direct;
            visit[a][b] = true;
            for (int i = 0; i < 4; i++) {
                cleaner.turn();
                if (cleaner.checkFoward()) {
                    a = cleaner.getA();
                    b = cleaner.getB();
                    if (visit[a][b] == false) {
                        direct = cleaner.direct;
                        q.offer(new Cleaner(a, b, direct));
                    }
                }
            }
        }
    }
}
