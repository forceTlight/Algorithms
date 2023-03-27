package 인프런.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 송아지_찾기 {
    static class Node{
        int x;
        public Node(int x){
            this.x = x;
        }

        public int getX(){
            return x;
        }
    }
    static int[] answer;
    static boolean[] visited;
    static int[] dx = {1, -1, 5};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        visited = new boolean[10001];
        answer = new int[10001];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a));
        visited[a] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int x = node.getX();
            int jumpCnt = answer[x];

            for(int i = 0; i < 3; i++){
                int jumpX = x + dx[i];
                if(jumpX >= 1 && jumpX <= 10000 && !visited[jumpX]){
                    answer[jumpX] = jumpCnt + 1;
                    queue.offer(new Node(jumpX));
                    visited[jumpX] = true;

                    if(jumpX == b){
                        System.out.println(answer[jumpX]);
                        return;
                    }
                }
            }
        }
    }
}