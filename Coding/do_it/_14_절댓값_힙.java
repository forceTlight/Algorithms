package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class _14_절댓값_힙 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            long first_abs = Math.abs(o1);
            long second_abs = Math.abs(o2);

            if(first_abs == second_abs){ // 절댓값이 같으면 음수 우선 정렬
                return o1 > o2 ? 1 : -1;
            }else{
                return (int) (first_abs - second_abs); // 절댓값 기준으로 정렬
            }
        });

        for(int i = 0; i < n; i++){
            long x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if(priorityQueue.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(priorityQueue.poll()).append("\n");
            }else{
                priorityQueue.offer(x);
            }
        }

        System.out.println(sb);
    }
}