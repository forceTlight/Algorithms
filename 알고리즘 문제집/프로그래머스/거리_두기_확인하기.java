package 프로그래머스;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    private int x;
    private int y;

    public Node1(int x, int y){
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
public class 거리_두기_확인하기 {
    static char[][] arr;
    static boolean[][] visited;
    static int[][] distance;

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }

    static public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < places.length; i++){
            arr = new char[5][5];
            for(int j = 0; j < 5; j++){
                char[] sArr = places[i][j].toCharArray();
                for(int k = 0; k < 5; k++){
                    arr[j][k] = sArr[k];
                }
            }
            answer[i] = bfs();
        }

        return answer;
    }

    static int bfs() {
        Queue<Node1> queue = new LinkedList<>();

        // bfs
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 'P') {
                    distance = new int[5][5];
                    visited = new boolean[5][5];
                    queue.offer(new Node1(i, j));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Node1 node1 = queue.poll();
                        int x = node1.getX();
                        int y = node1.getY();
                        for (int k = 0; k < 4; k++) {
                            int a = x + dx[k];
                            int b = y + dy[k];
                            if (a >= 0 && a < 5 && b >= 0 && b < 5) {
                                if (!visited[a][b] && arr[a][b] != 'X' && distance[x][y] < 2) {
                                    if (arr[a][b] == 'P')
                                        return 0;

                                    distance[a][b] = distance[x][y] + 1;
                                    visited[a][b] = true;
                                    queue.add(new Node1(a, b));
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}