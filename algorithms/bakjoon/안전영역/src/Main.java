import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int cnt = 1;
    static int map[][];
    static int submerged[][];
    static boolean visit[][];

    public static void main(String args[]) throws IOException {
        int max = Integer.MIN_VALUE;
        int height;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                height = Integer.parseInt(st.nextToken());
                max = Math.max(max, height);
                map[i][j] = height;
            }
        }
        // 높이 max까지 대입해서 안전한 영역의 최대 개수 출력
        for (int i = 1; i < max; i++) {
            // 초기화
            submerged = new int[n][n];
            visit = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    height = map[j][k];
                    if (height <= i)
                        submerged[j][k] = 1; // 침수 지역 표시
                }
            }
            combine();
        }
        System.out.println(cnt);
    }

    static void combine() {
        int combine_cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visit[i][j] == false && submerged[i][j] == 0) {
                    visit[i][j] = true;
                    combine_cnt++;
                    bfs(i, j);
                }
            }
        }
        cnt = Math.max(cnt, combine_cnt);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                // 침수된 곳 무시
                if (submerged[nx][ny] == 1)
                    continue;
                if (submerged[nx][ny] == 0 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
}
