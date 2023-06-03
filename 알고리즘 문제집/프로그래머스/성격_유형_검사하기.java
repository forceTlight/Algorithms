package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

class 성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<TreeSet<Character>> list = new ArrayList<>();

        // init
        TreeSet<Character> set1 = new TreeSet<>();
        set1.add('R');
        set1.add('T');

        TreeSet<Character> set2 = new TreeSet<>();
        set2.add('C');
        set2.add('F');

        TreeSet<Character> set3 = new TreeSet<>();
        set3.add('J');
        set3.add('M');

        TreeSet<Character> set4 = new TreeSet<>();
        set4.add('A');
        set4.add('N');

        list.add(set1);
        list.add(set2);
        list.add(set3);
        list.add(set4);

        String answer = "";

        for(int i = 0; i < survey.length; i++){
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);

            // b가 점수 얻음
            if(choices[i] > 4){
                int score = choices[i] - 4;
                map.put(b, map.getOrDefault(b , 0) + score);
            }else if(choices[i] < 4){
                int score = 4 - choices[i];
                map.put(a, map.getOrDefault(a, 0) + score);
            }
        }

        // 계산
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            TreeSet<Character> set = list.get(i);

            char a = set.pollFirst();
            char b = set.pollFirst();

            int valueA = map.getOrDefault(a, 0);
            int valueB = map.getOrDefault(b, 0);

            if(valueA == valueB){
                sb.append(a);
            }else if(valueA > valueB){
                sb.append(a);
            }else{
                sb.append(b);
            }
        }

        answer = sb.toString();

        return answer;
    }
}