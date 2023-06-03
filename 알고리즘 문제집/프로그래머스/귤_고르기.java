package 프로그래머스;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++){
            int key = tangerine[i];
            map.put(key, map.getOrDefault(key, 0) + 1);;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : map.keySet()){
            pq.offer(map.get(n));
        }

        int cnt = 0;
        while(!pq.isEmpty() && k > 0){
            k -= pq.poll();
            cnt++;
        }

        return cnt;
    }
}