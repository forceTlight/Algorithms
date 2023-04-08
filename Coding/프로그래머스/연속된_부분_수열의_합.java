package 프로그래머스;// 오름차순으로 정렬된 수열 주어짐 -> 다음 조건을 만족하는 부분 수열 찾기
// 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열
// 부분 수열의 합은 k
// 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾음
// 길이가 짧은 수열이 여러 개인 경우 앞쪽에 나오는 수열을 찾는다.

// 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return

import java.util.ArrayList;
import java.util.HashMap;

class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int[] S = new int[sequence.length + 1];
        int[] arr = new int[sequence.length + 1];
        for(int i = 1; i <= sequence.length; i++)
            arr[i] = sequence[i-1];
        
        S[0] = sequence[0];
        for(int i = 1; i < arr.length; i++){
            S[i] = S[i-1] + arr[i];
        }
        
        int lt = 1;
        int rt = 1;


        int answerlt = 0;
        int answerrt = 0;
        int length = Integer.MAX_VALUE;
        while(lt <= rt && rt < arr.length){
            int sum = S[rt] - S[lt - 1];
            if(sum == k){
                if((rt - lt) < length){
                    answerlt = lt - 1;
                    answerrt = rt - 1;
                    length = rt - lt;
                }
                lt++;
            }
                
            else if(sum > k)
                lt++;
            else
                rt++;
        }
        
        int[] answer = new int[2];
        answer[0] = answerlt;
        answer[1] = answerrt;
        return answer;
    }
}