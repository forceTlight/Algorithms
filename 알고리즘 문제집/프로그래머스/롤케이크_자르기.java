package 프로그래머스;

import java.util.*;

/**
 * 롤케이크 자르기
 * 문제유형 : 해시
 * 난이도 : LEVLE 2
 * 풀이시간 : 30분
 */
class 롤케이크_자르기 {
    public static void main(String args[]) {
        System.out.println(solution(new int[]{1, 2, 3, 1, 4}));
    }

    public static int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> aMap = new HashMap<>();
        HashMap<Integer, Integer> bMap = new HashMap<>();
        HashMap<Integer, Integer> tmpAMap = new HashMap<>();
        HashMap<Integer, Integer> tmpBMap = new HashMap<>();
        // 반으로 나누기
        int len = topping.length / 2;

        // A 토핑 할당
        for (int i = 0; i < len; i++) {
            int t = topping[i];
            aMap.put(t, aMap.getOrDefault(t, 0) + 1);
            tmpAMap.put(t, tmpAMap.getOrDefault(t, 0) + 1);
        }

        // B 토핑 할당
        for (int i = len; i < topping.length; i++) {
            int t = topping[i];
            bMap.put(t, bMap.getOrDefault(t, 0) + 1);
            tmpBMap.put(t, tmpBMap.getOrDefault(t, 0) + 1);
        }

        if(aMap.keySet().size() == bMap.keySet().size())
            answer++;

        for (int i = len - 1; i >= 0; i--) {
            int t = topping[i];
            aMap.put(t, aMap.get(t) - 1);
            bMap.put(t, bMap.getOrDefault(t, 0) + 1);
            if (aMap.get(t) == 0)
                aMap.remove(t);

            if (aMap.keySet().size() == bMap.keySet().size())
                answer++;
        }

        for (int i = len; i < topping.length; i++) {
            int t = topping[i];
            tmpBMap.put(t, tmpBMap.get(t) - 1);
            tmpAMap.put(t, tmpAMap.getOrDefault(t, 0) + 1);
            if (tmpBMap.get(t) == 0)
                tmpBMap.remove(t);

            if (tmpAMap.keySet().size() == tmpBMap.keySet().size())
                answer++;
        }

        return answer;
    }
}