
import java.util.Arrays;
import java.util.Arrays;

public class Solution {
    static int max = Integer.MIN_VALUE;
    static int[] lion;
    static int[] answer = {-1};
    public static void main(String args[]){
        solution(9, new int[] {0,0,1,2,0,1,1,1,1,1,1});
        //solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0});
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(int n, int[] info) {
        lion = new int[11];
        combine(info, 1, n);
        return answer;
    }
    static void combine(int[] info, int cnt, int n){
        if(cnt == n+1){
            getScore(info);
            return;
        }
        for(int i = 0; i <= 10 && lion[i] <= info[i]; i++){
            lion[i]++;
            combine(info, cnt+1, n);
            lion[i]--;
        }
    }
    static void getScore(int[] info){
        int sum = 0;
        for(int i = 0; i < 11; i++) {
            if (lion[i] != 0 || info[i] != 0) {
                if (lion[i] > info[i]) {
                    sum += 10 - i;
                } else if (lion[i] <= info[i]) {
                    sum -= 10 - i;
                }
            }
        }
        if(sum > 0 && max <= sum){
            max = sum;
            answer = lion.clone();
        }
    }
}
