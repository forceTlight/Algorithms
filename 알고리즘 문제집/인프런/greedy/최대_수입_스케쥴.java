package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최대_수입_스케쥴 {
    static class Lecture implements Comparable<Lecture>{
        int money;
        int day;

        public Lecture(int money, int day){
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture l){
            if(this.day == l.day)
                return l.money - this.money;

            return l.day - this.day;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Lecture> lectures = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int max = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(money, day));

            max = Math.max(max, day);
        }

        Collections.sort(lectures);

        int sum = 0;

        int j = 0;
        for(int i = max; i > 0; i--){
            for(; j < n; j++){
                Lecture lecture = lectures.get(j);
                if(lecture.day < i)
                    break;

                pq.offer(lecture.money);
            }
            if(!pq.isEmpty())
                sum += pq.poll();
        }

        System.out.println(sum);
    }
}