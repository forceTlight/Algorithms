public class Solution {
    static int num;
    static int max = Integer.MIN_VALUE;
    static int[] peach;
    static int[] score = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int[] answer;
    static boolean[] visit;
    public static void main(String args[]){
        solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0});
    }

    static int[] solution(int n, int[] info) {
        num = n;
        peach = info;
        int[] lion = new int[11];
        //visit = new boolean[11];
        int[] answer = {};
        return answer;
    }
    static void combine(int idx, int cnt, int[] lion){
        if(cnt == num){
            getScore(lion);
        }
        if(Math.abs(lion[idx] - peach[idx]) > 1) { // 차이가 1 이상일 시 리턴
            return;
        }
        for(int i = idx; i < 11; i++){
            lion[i]++;
            combine(i+1, cnt+1, lion);
        }
    }
    static boolean getScore(int[] lion){
        int sum = 0;
        for(int i = 0; i < 11; i++){
            if(lion[i] > peach[i]){
                sum += score[i];
            }else if(lion[i] < peach[i]){
                sum -= score[i];
            }
        }
        if(max < sum){
            max = sum;
            answer = lion;
        }
    }
}
