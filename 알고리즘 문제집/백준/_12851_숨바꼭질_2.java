package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 12851 - 숨바꼭질2
 * 문제유형 : BFS
 * 난이도 : GOLD4
 * 풀이시간 : 1시간
 */
public class _12851_숨바꼭질_2 {
    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        int[] visited = new int[100001];

        int answer = Integer.MAX_VALUE;
        int caseNum = 0;
        q.offer(new Node(a, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int n = node.num;
            int cnt = node.cnt;

            if(n == b && cnt <= answer){
                answer = cnt;
                caseNum++;
            }

            for(int i = 0; i < 3; i++){
                int num = n;
                if(i == 0){
                    num = num * 2;
                }else if(i == 1){
                    num++;
                }else{
                    num--;
                }

                if(num >= 0 && num <= 100000 && (visited[num] == 0 || visited[num] == cnt + 1)){
                    visited[num] = cnt + 1;
                    q.offer(new Node(num, cnt + 1));
                }
            }
        }

        System.out.println(answer);
        System.out.println(caseNum);
    }
}