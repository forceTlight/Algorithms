package 프로그래머스;

import java.util.Arrays;

class h_index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations.length - i >= citations[i]){
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }
}