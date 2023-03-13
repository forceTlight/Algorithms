//package 백준;
//
//import 프로그래머스.Node1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class _2178_미로_탐색 {
//    static boolean[][] visited;
//    static int[] dx = new int[]{-1, 1, 0, 0};
//    static int[] dy = new int[]{0, 0, -1, 1};
//    static int[][] arr;
//    static int[][] answer;
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        arr = new int[n][m];
//        answer = new int[n][m];
//        visited = new boolean[n][m];
//
//        for(int i = 0; i < n; i++){
//            String s = br.readLine();
//            for(int j = 0; j < s.length(); j++){
//                arr[i][j] = Character.getNumericValue(s.charAt(j));
//            }
//        }
//
//        // bfs
//        Queue<Node1> queue = new LinkedList<>();
//        queue.offer(new Node1(0, 0));
//        answer[0][0] = 1;
//        visited[0][0] = true;
//
//        while(!queue.isEmpty()){
//            Node1 node1 = queue.poll();
//            int x = node1.getX();
//            int y = node1.getY();
//
//            for(int i = 0; i < 4; i++) {
//                int a = x + dx[i];
//                int b = y + dy[i];
//
//                if (a >= 0 && a < n && b >= 0 && b < m) {
//                    if (!visited[a][b] && arr[a][b] == 1) {
//                        queue.offer(new Node1(a, b));
//                        answer[a][b] = answer[x][y] + 1;
//                        visited[a][b] = true;
//                    }
//                }
//            }
//        }
//
//        System.out.println(answer[n-1][m-1]);
//    }
//}