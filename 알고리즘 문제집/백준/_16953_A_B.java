package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 16953 - A -> B
 * 문제유형 : BFS
 * 난이도 : Silver 1
 * 풀이시간 : 10분
 */
public class _16953_A_B {
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

        int answer = -1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, 1));

        loop:
        while(!q.isEmpty()){
            Node node = q.poll();
            int num = node.num;
            int cnt = node.cnt;

            for(int i = 0; i < 2; i++){
                long n = num;
                if(i == 0){
                    n *= 2;
                }else{
                    n = Long.parseLong(num + "1");
                }

                if(n <= b){
                    if(n == b){
                        answer = cnt + 1;
                        break loop;
                    }

                    q.offer(new Node((int) n, cnt + 1));
                }
            }
        }

        if(answer == Integer.MAX_VALUE)
            answer = -1;

        System.out.println(answer);
    }
}