package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 1213 - 팰린드롬_만들기
 * 문제유형 : 구현
 * 난이도 : SILVER 3
 * 풀이시간 : 40분
 */
public class _1213_팰린드롬_만들기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        char[] answer = new char[length];

        HashMap<Character, Integer> hashMap = new HashMap<>();
        TreeSet<Character> treeSet = new TreeSet<>();
        // 문자갯수 검사
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            treeSet.add(c);
        }

        if(length == 1){
            System.out.println(input);
            return;
        }

        // 홀수인지, 짝수인지 판단하기 -> 못만들면 "I'm Sorry Hansoo" 출력
        if (length % 2 == 0) { // 짝수 -> 모두 짝수여야 됌
            for (char key : hashMap.keySet()) {
                int cnt = hashMap.get(key);
                if (cnt % 2 == 1) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        } else { // 홀수 -> 하나만 홀수고, 나머지는 짝수여야됨
            boolean check = false; // 홀수 체크
            for (char key : hashMap.keySet()) {
                int cnt = hashMap.get(key);
                if (cnt % 2 == 1) {
                    if (check) {
                        System.out.println("I'm Sorry Hansoo");
                        return;
                    } else {
                        check = true;
                    }
                }
            }
        }

        int pt = 0;
        // 여기까지 오면 팰랜드롬 만들 수 있음, 사전순으로 조합해야 됨
        if (length % 2 == 0) { // 짝수이면
            for (char key : hashMap.keySet()) {
                int cnt = hashMap.get(key) / 2;
                for (int i = 0; i < cnt; i++) {
                    answer[pt] = key;
                    answer[length - 1 - pt] = key;
                    pt++;
                }
            }
        } else { // 홀수이면
            char oddChar = '0';
            for (char key : hashMap.keySet()) {
                int cnt = hashMap.get(key) / 2;
                for (int i = 0; i < cnt; i++) {
                    if (hashMap.get(key) % 2 == 1) { // 홀수이면
                        oddChar = key;
                    }
                    answer[pt] = key;
                    answer[length - 1 - pt] = key;
                    pt++;
                }
            }

            // 중간에 삽입
            answer[length / 2] = oddChar;
        }

        System.out.println(String.valueOf(answer));
    }
}
