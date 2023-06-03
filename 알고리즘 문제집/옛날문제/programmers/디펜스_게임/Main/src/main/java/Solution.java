// 백 트래킹

import java.util.ArrayList;

public class Solution {
    static int answer = 0;
    ArrayList<Integer> maxArr = new ArrayList<>();

    public static void main(String args[]){

    }

    public int solution(int n, int k, int[] enemy) {
        int cnt = 0;
        int max = 0;

        for(int i = 0; i < enemy.length; i++){
            max = enemy[i];
            int currentNum = n;
            int defenseNum = 0;
            for(int j = i; j < enemy.length; j++){
                if(enemy[j] >= max && defenseNum < k){
                    defenseNum++;
                }else{
                    if(currentNum - enemy[j] < 0)
                        break;

                    currentNum = currentNum - enemy[j];
                }
            }
            cnt++;
        }
        if(answer < cnt)
            answer = cnt;
    }

    public void getMaxArea(){

    }
}
