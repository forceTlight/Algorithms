package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1158_요세푸스_문제 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> tq = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while(!q.isEmpty()){
            for(int i = 0; i < m - 1; i++){
                int num = q.poll();
                q.offer(num);
            }

            answer.add(q.poll());
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i));

            if(i != answer.size() - 1)
                sb.append(", ");
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}