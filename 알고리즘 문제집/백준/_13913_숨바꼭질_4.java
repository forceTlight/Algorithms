package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 13913 - 숨바꼭질 4
 * 문제유형 : BFS, Stack
 * 난이도 : GOLD 4
 * 풀이시간 : 40분
 */
public class _13913_숨바꼭질_4 {
    static class Node{
        int n;
        int t;
        ArrayList<Integer> path;

        public Node(int n, int t){
            this.n = n;
            this.t = t;
            this.path = new ArrayList<>();
        }

        public void add(int n){
            this.path.add(n);
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        int[] time = new int[100001];
        int[] parent = new int[100001];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(a, 0));
        int answer = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            int n = node.n;
            int t = node.t;
            node.add(n);

            if(n == b){
                answer = t;
                break;
            }

            int[] arr = {n * 2, n + 1, n - 1};
            t++;
            for(int i = 0; i < 3; i++){
                int next = arr[i];
                if(next >= 0 && next <= 100000 && (time[next] == 0 || time[next] >= t)){
                    time[next] = t;
                    parent[next] = n;
                    node.n = next;
                    node.t = t;
                    q.offer(new Node(next, t));
                }
            }
        }

        System.out.println(answer);

        Stack<Integer> stack = new Stack<>();
        while(b != a){
            stack.push(b);
            b = parent[b];
        }

        stack.push(a);

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}