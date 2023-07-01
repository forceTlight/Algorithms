package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 14226 - 이모티콘
 * 문제유형 : BFS,
 * 난이도 : GOLD 4
 * 풀이시간 : 1시간
 */
public class _14226_이모티콘 {
    static class Node{
        int before;
        int n;
        int t;

        public Node(int before, int n, int t){
            this.before = before;
            this.n = n;
            this.t = t;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[1001][1001];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 1, 0));

        int answer = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Node node = q.poll();
            int n = node.n;
            int before = node.before;
            int t = node.t;

            if(n == s){
                answer = Math.min(answer, t);
                continue;
            }

            t++;
            for(int i = 0; i < 3; i++){
                int num = n;
                if(i == 0){ // 화면에 붙여넣기
                    num = num + before;
                }else if(i == 1){ // 이모티콘 하나 삭제
                    num -= 1;
                }else{ // 클립보드에 저장
                    before = n;
                }

                if(num >= 1 && num <= 1000 && !visited[before][num]){
                    visited[before][num] = true;
                    q.offer(new Node(before, num, t));
                }
            }
        }

        System.out.println(answer);
    }
}