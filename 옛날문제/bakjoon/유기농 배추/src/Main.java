import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x, y;

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

    public static void main(String args[]) throws IOException {
        int c;
        int m, n, k;
        int arr[][];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(bf.readLine());
        for (int i = 0; i < c; i++) {
            String input = bf.readLine();
            String[] inputs = input.split(" ");
            m = Integer.parseInt(inputs[0]);
            n = Integer.parseInt(inputs[1]);
            k = Integer.parseInt(inputs[2]);
            arr = new int[m][n];
            for (int j = 0; j < k; j++) {
                int x, y;
                input = bf.readLine();
                inputs = input.split(" ");
                x = Integer.parseInt(inputs[1]);
                y = Integer.parseInt(inputs[0]);
                arr[y][x]++;
            }
            System.out.println(bfs(arr));
        }
    }

    public static int bfs(int arr[][]) {
        int x, y;
        int tmp_x, tmp_y;
        int cnt = 0;
        Queue<Node> queue = new LinkedList<Node>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                // 배추가 있을 때
                if (arr[i][j] == 1) {
                    queue.offer(new Node(i, j)); // 큐 추가
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        x = node.getX();
                        y = node.getY();
                        for (int k = 0; k < 4; k++) { // 상,하,좌,우 탐색
                            tmp_x = x + dx[k];
                            tmp_y = y + dy[k];
                            if (tmp_x >= 0 && tmp_x < arr.length
                                    && tmp_y >= 0 && tmp_y < arr[0].length && arr[tmp_x][tmp_y] == 1) {
                                arr[tmp_x][tmp_y] = 0;
                                queue.offer(new Node(tmp_x, tmp_y));
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}