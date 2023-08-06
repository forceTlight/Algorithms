package 프로그래머스;// output: 각 유저가 받은 결과 메일 수
// output-size: id_list size (2 <= id_list <= 1000)

// input: 유저 id list, report - 이용자id, 신고한id 문자열, k - 정지기준이 되는 신고 갯수
// input-size: 2 <= id_list <= 1000, 1 <= report <= 200000, 1 <= k <= 200

// 문제 설명
// 각 유저는 한번에 한 명의 유저를 신고할 수 있다.
// 신고 횟수에는 제한이 없고, 서로 다른 유저를 계속해서 신고할 수 있다.
// 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리

// k번 이상 신고된 유저는 게시판 이용이 정지, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송함
// 유저가 신고한 신고한 모든 내용을 취합하여 마지막까지 한꺼번에 게시판 이용 정지를 시키면 정지 메일을 받음


import java.util.*;

class 카카오_신고결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {        
        HashMap<String, HashSet<String>> banGraph = new HashMap<>(); // 그래프
        HashMap<String, Integer> reportMap = new HashMap<>();
        HashMap<String, HashSet<String>> tmpMap = new HashMap<>(); // 중복방지 맵
        
        for(int i = 0; i < report.length; i++){
            String[] inputs = report[i].split(" ");
            String reportId = inputs[0];
            String banId = inputs[1];
            
            // 만약 그래프가 비어있으면 new ArrayList<>();
            if(!banGraph.containsKey(banId)){
                banGraph.put(banId, new HashSet<>());
            }
            
            HashSet<String> reporterSet = banGraph.get(banId);
            if(reporterSet.contains(reportId))
               continue;
            
            reporterSet.add(reportId);
            reportMap.put(banId, reportMap.getOrDefault(banId, 0) + 1);
            // System.out.println(reportMap.getOrDefault(banId, 0));
        }
        
        HashMap<String, Integer> answerMap = new HashMap<>();
                
        // 답 구하기
        for(String banId : reportMap.keySet()){
            int reportCnt = reportMap.get(banId);
                        
            // 정지 기준 이상이면
            if(reportCnt >= k){
                for(String reporterId : banGraph.get(banId)){                    
                    answerMap.put(reporterId, answerMap.getOrDefault(reporterId, 0) + 1);
                }
            }
            
            System.out.println(reportCnt);
        }
        
        int[] answer = new int[id_list.length]; 
        
       for(int i = 0; i < id_list.length; i++){
           String id = id_list[i];
           int cnt = answerMap.getOrDefault(id, 0);
           
           answer[i] = cnt;
       }
        
        return answer;
    }
}