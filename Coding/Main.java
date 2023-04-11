// 디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임
// 남은 병사중 적 숫자만큼의 병사를 소모해 적을 막을 수 있다. ex) 남은 병사 7, 적 2 -> 7 - 2 = 5명의 병사 남음
// 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료
// 무적권(k개)를 쓰면 병사의 소모없이 한 라운드의 공격을 막을 수 있음
// 최대 몇 라운드까지 막을 수 있는지 return
import java.util.*;

class Main {
    public static void main(String args[]){
        Solution solution = new Solution();
        int answer = solution.solution(new int[]{1,4,5});
        System.out.println(answer);
    }
}