package 프로그래머스;

import java.util.*;

class 영어_끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;

        HashSet<String> hashSet = new HashSet<>();
        
        int cnt = 0;
        String preWord = null;
        for(int i = 0; i < words.length; i++){
            int num = (cnt % n) + 1;
            
            String word = words[i];
            if(hashSet.contains(word)){
                answer[0] = num;
                answer[1] = (int)Math.ceil((double) (i + 1) / n);
                break;
            }
            
            System.out.println(word);
            
            if(preWord != null){
                char lastC = preWord.charAt(preWord.length() - 1);
                char firstC = word.charAt(0);
                if(lastC != firstC){
                    answer[0] = num;
                    answer[1] = (int)Math.ceil((double) (i + 1) / n);
                    break;
                }
            }
            
            preWord = word;
            hashSet.add(word);
            cnt++;
        }

        return answer;
    }
}