// 1. 각 카드에는 1 ~ 100까지의 숫자가 하나씩 적혀있음
// 2. 2 이상 100 이하의 자연수를 하나 정해 그 수보다 작거나 같은 숫자 카드들을 준비하고, 준비한 카드의 수만큼 작은 상자를 자를 준비하면 게임 시작가능
// 3. 준비된 상자에 카드를 한 장씩 넣고, 상자를 무작위로 섞어 일렬로 나열함
// 4. 상자가 일렬로 나열되면 상자가 나열된 순서에 따라 1번부터 순차적으로 증가하는 번호를 붙임
// 5. 다음 임의의 상자를 하나 선택해 선택한 상자 안의 숫자 카드를 확인함
// 6. 한 카드에 적힌 번호에 해당하는 상자를 열어 담긴 카드에 적힌 숫자를 확인함
// 7. 마찬가지로, 숫자에 해당하는 번호를 가진 상자를 계속해서 열어가며, 열어야 하는 상자가 이미 열려있을 때 까지 반복
import java.util.*;

class Solution {
    static int[] arr;
    static ArrayList<Integer> list;
    static int answer = Integer.MIN_VALUE;

    public int solution(int[] cards) {
        HashSet<Integer> hashSet = new HashSet<>();
        list = new ArrayList<>();

        for(int i = 0; i < cards.length; i++){
            int num = cards[i];
            int cnt = 0;
            while(!hashSet.contains(num)){
                cnt++;
                hashSet.add(num);
                num = cards[num - 1];
            }

            if(cnt != 0)
                list.add(cnt);
        }

        // 최댓 값 구하기
        if(list.size() <= 1)
            return 0;
        else{
            Collections.sort(list, Collections.reverseOrder());
            return list.get(0) * list.get(1);
        }
    }

    public static void dfs(int idx, int depth){
        if(depth == 2){
            answer = Math.max(arr[0] * arr[1], answer);
            return;
        }

        for(int i = idx; i < list.size(); i++){
            arr[depth] = list.get(i);
            dfs(idx + 1, depth + 1);
        }
    }
}