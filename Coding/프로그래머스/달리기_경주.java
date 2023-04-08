package 프로그래머스;// 추월한 선수의 이름을 부른다
import java.util.*;

class 달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
    
        // 등수에 들어있는 사람 정보를 담고있음
        ArrayList<String> arrayList = new ArrayList<>();
        
        // 사람이 들어있는 등수 정보를 가지고있음
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            arrayList.add(players[i]);
            hashMap.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++){
            String callName = callings[i];
            int rank = hashMap.get(callName);
            
            // 전의 사람이랑 swap
            String beforeName = arrayList.get(rank - 1);
            
            hashMap.put(beforeName, rank);
            hashMap.put(callName, rank - 1);
            
            arrayList.set(rank, beforeName);
            arrayList.set(rank - 1, callName);
        }
        
        answer = new String[arrayList.size()];
        for(int i = 0; i < arrayList.size(); i++)
            answer[i] = arrayList.get(i);
        
        return answer;
    }
}