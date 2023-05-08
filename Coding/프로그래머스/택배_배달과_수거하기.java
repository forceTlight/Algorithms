package 프로그래머스;

import java.util.TreeSet;

class 택배_배달과_수거하기 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int c = cap;

        int deliveryIdx = deliveries.length - 1;
        int pickupIdx = pickups.length - 1;

        loop:
        while(true){
            c = cap;
            boolean deliveryCheck = false;

            int idx = 0;

            // 배달 거리
            for(int i = deliveryIdx; i >= 0 && c > 0; i--){
                if(deliveries[i] > 0){
                    deliveryIdx = i;
                    deliveryCheck = true;
                    idx = Math.max(idx, i+1);

                    if(c <= deliveries[i]){
                        deliveries[i] -= c;
                        c = 0;
                    }else{
                        c -= deliveries[i];
                        deliveries[i] = 0;
                    }
                }
            }

            boolean pickupCheck = false;
            int pIdx = 0;
            int store = cap;
            // 수거 거리
            for(int i = pickupIdx; i >= 0 && store > 0; i--){
                if(pickups[i] > 0){
                    pickupIdx = i;
                    pickupCheck = true;
                    pIdx = Math.max(pIdx, i+1);

                    if(store > pickups[i]){
                        store -= pickups[i];
                        pickups[i] = 0;
                    }else{
                        pickups[i] -= store;
                        store = 0;
                    }
                }
            }

            if(deliveryCheck && pickupCheck){
                answer += Math.max(pIdx, idx) * 2;
            }else if(deliveryCheck){
                answer += idx * 2;
            }else if(pickupCheck){
                answer += pIdx * 2;
            }else{
                break loop;
            }

//            System.out.println(answer);
        }

        return answer;
    }
}