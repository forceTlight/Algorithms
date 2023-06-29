package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 13549 - 숨바꼭질3
 * 문제유형 : BFS
 * 난이도 : GOLD5
 * 풀이시간 : 40분
 */
public class _13549_숨바꼭질_3 {
    static class Node{
        int n;
        int cnt;

        public Node(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];

        int answer = Integer.MAX_VALUE;
        int caseNum = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int n = node.n;
            int cnt = node.cnt;

            if(n == b && cnt <= answer){
                answer = cnt;
            }

            int[] arr = {n * 2, n - 1, n + 1};

            for(int i = 0; i < 3; i++){
                int t = cnt;
                if(i != 0)
                    t++;

                if(arr[i] >= 0 && arr[i] <= 100000 && (time[arr[i]] == 0 || time[arr[i]] >= t)){
                    if(i == 0 && visited[arr[i]])
                        continue;

                    if(i == 0)
                        visited[arr[i]] = true;

                    time[arr[i]] = t;
                    q.offer(new Node(arr[i], t));
                }
            }
        }

        System.out.println(answer);
    }
}