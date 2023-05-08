package 프로그래머스;

import java.util.ArrayList;
import java.util.HashMap;

// 파기해야 할 개인정보 구하면 됨
class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerList = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++){
            String[] term = terms[i].split(" ");
            char category = term[0].charAt(0);
            int vaildDate = Integer.parseInt(term[1]) * 28;

            map.put(category, vaildDate);
        }

        for(int i = 0; i < privacies.length; i++){
            String[] pv = privacies[i].split(" ");
            String date = pv[0];
            char category = pv[1].charAt(0);

            // today - 개인정보 날짜
            int diffDate = getDiffDate(today, date);
            if(diffDate >= map.get(category)){
                answerList.add(i+1);
            }
        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++)
            answer[i] = answerList.get(i);

        return answer;
    }

    public int getDiffDate(String today, String pvDate){
        String[] todays = today.split("[.]");
        String[] pvDates = pvDate.split("[.]");

        // yearToDate -> 12 * 28 * y
        int todayAllDate = (Integer.parseInt(todays[0]) * 12 * 28) + Integer.parseInt(todays[1]) * 28 + Integer.parseInt(todays[2]);
        int pvAllDate = (Integer.parseInt(pvDates[0]) * 12 * 28) + Integer.parseInt(pvDates[1]) * 28 + Integer.parseInt(pvDates[2]);

        System.out.println(todayAllDate - pvAllDate);

        return todayAllDate - pvAllDate;
    }
}