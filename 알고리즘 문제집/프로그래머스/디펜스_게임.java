package 프로그래머스;// 디펜스 게임은 준호가 보유한 병사 n명으로 연속되는 적의 공격을 순서대로 막는 게임
// 남은 병사중 적 숫자만큼의 병사를 소모해 적을 막을 수 있다. ex) 남은 병사 7, 적 2 -> 7 - 2 = 5명의 병사 남음
// 남은 병사의 수보다 현재 라운드의 적의 수가 더 많으면 게임이 종료
// 무적권(k개)를 쓰면 병사의 소모없이 한 라운드의 공격을 막을 수 있음
// 최대 몇 라운드까지 막을 수 있는지 return
import java.util.*;

class 디펜스_게임 {
    public static void main(String args[]){
        System.out.println(solution(3, 3, new int[]{3, 3, 3, 3,}));
    }

    // n 병사 수, k 무적권 수
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        loop:
        for(int i = 0; i < enemy.length; i++){
            int value = enemy[i];
            pq.offer(value);
            n -= value;
            if(n < 0){ // 병사 수 부족
                if(k > 0){ // 무적권 있을 경우
                    int pv = pq.poll();
                    n += pv;
                    k--;
                }else{
                    break loop;
                }
            }

            answer = i + 1;
        }

        return answer;
    }
}