package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class _33_수_묶기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int data = Integer.parseInt(br.readLine());
            if(data > 0)
                maxHeap.offer(data);
            else
                minHeap.offer(data);
        }

        long answer = 0;
        while(!minHeap.isEmpty()){
            if(minHeap.size() >= 2){
                int a = minHeap.poll();
                int b = minHeap.poll();
                answer += (long) a * b;
            }else{
                int a = minHeap.poll();
                answer += a;
            }
        }

        while(!maxHeap.isEmpty()){
            if(maxHeap.size() >= 2){
                int a = maxHeap.poll();
                int b = maxHeap.poll();
                if(b == 1)
                    answer += (long) a + b;
                else answer += (long) a * b;
            }else{
                int a = maxHeap.poll();
                answer += a;
            }
        }

        System.out.println(answer);
    }
}