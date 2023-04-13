package 프로그래머스;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class 카카오_셔틀버스 {
    static class Crew implements Comparable<Crew> {
        int time;

        public Crew(int time) {
            this.time = time;
        }

        @Override
        public int compareTo(Crew crew) {
            return this.time - crew.time;
        }
    }

    // n - 셔틀 운행 횟수, t - 셔틀 운행 간격, m - 한 셔틀에 탈 수 있는 최대 크루 수, timetable - 크루가 대기열에 도착하는 시각을 모은 배열
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Crew> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        // timetable 정렬 (시간 오름차 순)
        for (int i = 0; i < timetable.length; i++) {
            int time = getMinute(timetable[i]);
            pq.offer(new Crew(time));
        }

        Queue<Integer> q = new LinkedList<>();
        int startBus = getMinute("09:00");
        int endBus = startBus + (t * (n - 1));
        int lastBus = 0;
        int lastTime = 0; // 제일 마지막에 버스에 탑승한 인원 시간
        int cnt = 0;
        while (n > 0 && !pq.isEmpty()) {
            if (startBus >= 1440) { // 자정이 넘어갔을 때
                break;
            }
            cnt = m;
            lastBus = startBus;

            while (!pq.isEmpty() && (cnt > 0 && pq.peek().time <= startBus)) {
                lastTime = pq.poll().time;
                hashMap.put(lastTime, hashMap.getOrDefault(lastTime, 0) + 1);
                cnt--;
            }

            startBus += t;
            n--;
        }

        // 콘이 탑승 할 버스 시간 구하기
        // 1. 버스 자리가 남았을 경우 -> 제일 마지막 버스 시간에 타기
        if (cnt >= 0) {
            if (cnt == 0) {
                answer = minuteToTime(lastTime - 1);
            }
            // 마지막 버스 시간이 진짜 마지막 버스 시간인지 보기
            else if (endBus < lastBus) {
                answer = minuteToTime(endBus);
            } else {
                answer = minuteToTime(lastBus);
            }
        }
        // 2. 버스 자리가 안남았을 경우
        // 2.1 제일 마지막 사람이랑 같이 탈 수 있는 경우
        // 2.2 제일 마지막 사람이랑 같이 탈 수 없는 경우 (마지막 사람)
        else {
            if (lastTime == lastBus) { // 버스 자리가 안남았을경우
                answer = minuteToTime(lastTime - 1);
            }
        }
        return answer;
    }

    public int getMinute(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    public String minuteToTime(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        int minute = time - (hour * 60);
        if (hour < 10)
            sb.append("0");
        sb.append(hour).append(":");
        if (minute < 10)
            sb.append("0");
        sb.append(minute);

        return sb.toString();
    }
}