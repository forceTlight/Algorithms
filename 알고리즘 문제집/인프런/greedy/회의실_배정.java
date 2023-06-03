package 인프런.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 회의실_배정 {
    static class Room implements Comparable<Room>{
        int start;
        int end;

        public Room(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room room){
            if(this.end == room.end)
                return this.start - room.start;

            return this.end - room.end;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Room> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Room(start, end));
        }

        int prevStart = 0;
        int prevEnd = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Room room = pq.poll();
            if(prevEnd == room.end && room.start != room.end)
                continue;

            if(prevEnd > room.start)
                continue;

            prevEnd = room.end;
            cnt++;
        }

        System.out.println(cnt);
    }
}