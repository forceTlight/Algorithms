package 프로그래머스;// 과제는 시작하기로 한 시간이 되면 시작
// 새로운 과제를 시작할 시간이 되었을 때, 기존에 진행중이던 과제가 있다면 과제 멈추고 새로운 과제 시작
// 진행중이던 과제가 끝났을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행
// 만약에 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 있다면 새로 시작해야 하는 과제부터 진행
// 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작

// 1. 들어온 값 시간 순으로 정렬
// 2. 과목 객체 만들기 (idx (들어온 순서), 남은 시간, 과목 이름))
import java.util.*;

class 과제_진행하기 {
    static class Subject implements Comparable<Subject>{
        int idx;
        int startTime; // 시간 Minute으로 계산
        int leftTime;
        String name;
        
        public Subject(int startTime, int leftTime, String name){
            this.startTime = startTime;
            this.leftTime = leftTime;
            this.name = name;
        }
        
        public void setIdx(int idx){
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Subject subject){
            return subject.idx - this.idx;
        }
    }
        
    public String[] solution(String[][] plans) {
        String[] answer = {};

        TreeMap<Integer, Subject> treeMap = new TreeMap<>();

        // 시간 순대로 정렬해서 treeMap에 넣기
        for (int i = 0; i < plans.length; i++) {
            int startTime = convertToMinute(plans[i][1]);
            int leftTime = Integer.parseInt(plans[i][2]);
            treeMap.put(startTime, new Subject(startTime, leftTime, plans[i][0]));
        }

        PriorityQueue<Subject> pq = new PriorityQueue<>();

        int beforeTime = -1;
        int idx = 0;

        ArrayList<String> list = new ArrayList<>();

        for (int key : treeMap.keySet()) {
            Subject s = treeMap.get(key);

            // 시간 차 계산
            int subTime = s.startTime - beforeTime;

            // 남는 시간에 과제하기
            while (!pq.isEmpty() && subTime != 0) {
                Subject beforeSubject = pq.poll();
                if (subTime >= beforeSubject.leftTime) { // 과제를 다 했을 경우
                    subTime -= beforeSubject.leftTime;
                    list.add(beforeSubject.name);
                } else { // 과제를 다 하지 못했을 경우
                    beforeSubject.leftTime = beforeSubject.leftTime - subTime;
                    pq.offer(beforeSubject);
                    subTime = 0;
                }
            }

            s.setIdx(idx++);
            pq.offer(s);
            beforeTime = s.startTime;
        }

        // pq에 남아있는거 꺼내기
        while (!pq.isEmpty()) {
            Subject s = pq.poll();
            list.add(s.name);
        }

        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
    
    public int convertToMinute(String input){
        String[] times = input.split(":");
        int time = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        
        return time * 60 + minute;
    }
}
