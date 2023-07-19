package 프로그래머스;

import java.util.*;

/**
 * 할인_행사
 * 문제유형 : 해시
 * 난이도 : LEVLE 2
 * 풀이시간 : 35분
 */
class 할인_행사 {
    public static void main(String args[]){
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < 10; i++){
            String dis = discount[i];
            hashMap.put(dis, hashMap.getOrDefault(dis, 0) + 1);
        }

        // 충족이 됐는지 조회
        boolean check = true;
        for(int i = 0; i < want.length; i++){
            int wantNumber = wantMap.get(want[i]);
            if(hashMap.getOrDefault(want[i], -1) != wantNumber)
                check = false;
        }

        if(check)
            answer++;

        int lt = 0;
        loop:
        for(int rt = 10; rt < discount.length; rt++){
            // hashMap에 정보 리로드
            hashMap.put(discount[lt], hashMap.get(discount[lt]) - 1);
            hashMap.put(discount[rt], hashMap.getOrDefault(discount[rt], 0) + 1);

            check = true;
            // 충족이 됐는지 조회
            for(int i = 0; i < want.length; i++){
                int wantNumber = wantMap.get(want[i]);
                if(hashMap.getOrDefault(want[i], -1) != wantNumber)
                    check = false;
            }

            lt++;

            if(check)
                answer++;
        }

        return answer;
    }
}