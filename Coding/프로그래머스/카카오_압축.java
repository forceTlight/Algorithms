package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;

class 카카오_압축 {
    HashMap<String, Integer> dictionary = new HashMap<>();

    public int[] solution(String msg) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        init();

        StringBuilder sb = new StringBuilder();
        int pt = 0;
        while (pt < msg.length()) {
            sb.setLength(0);

            sb.append(msg.charAt(pt)); // 현재 가르키고 있는 문자 더하기
            int p = pt;
            // 순회 하면서 딕셔너리에 있는 단어들 모두 더하기
            while (dictionary.containsKey(sb.toString())) {
                p++;

                if(p >= msg.length())
                    break;

                sb.append(msg.charAt(p));
            }

            // 딕셔너리에 없는 문자 딕셔너리에 색인 추가
            if(!dictionary.containsKey(sb.toString()))
                dictionary.put(sb.toString(), dictionary.size() + 1);

            // 딕셔너리 색인 출력 (답)
            if (p <= msg.length()) {
                if(p == msg.length()){
                    arrayList.add(dictionary.get(sb.toString()));
                }else{
                    sb.deleteCharAt(sb.length() -1);
                    arrayList.add(dictionary.get(sb.toString()));
                }
            }

            pt = p - 1; // 딕셔너리에 저장된 끝 포인터
            pt++;
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++)
            answer[i] = arrayList.get(i);

        return answer;
    }

    public void init() {
        for (int i = 1; i <= 26; i++) {
            char c = (char) ('A' + (i - 1));
            dictionary.put(String.valueOf(c), i);
        }
    }
}