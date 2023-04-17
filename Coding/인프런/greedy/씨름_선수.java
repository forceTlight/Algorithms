package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 씨름_선수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heightpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> weightpq = new PriorityQueue<>(Collections.reverseOrder());

        // maxWeight, maxHeight 조사
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map.put(h, w);

            heightpq.add(h);
        }

        int cnt = 0;
        while(!heightpq.isEmpty()){
            int height = heightpq.poll();
            int weight = map.get(height);

            if(!weightpq.isEmpty() && weightpq.peek() > weight)
                continue;

            weightpq.add(weight);
            cnt++;
        }



        System.out.println(cnt);
    }
}