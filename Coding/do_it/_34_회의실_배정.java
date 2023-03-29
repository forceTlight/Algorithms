package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _34_회의실_배정 {
    static class Class implements Comparable<Class> {
        int prev;
        int next;

        public Class(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }

        @Override
        public int compareTo(Class c) {
            if(this.prev == c.prev)
                return this.next - c.next;

            return this.prev - c.prev;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Class> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            pq.offer(new Class(prev, next));
        }

        int answer = 0;
        int next = -1;
        while (!pq.isEmpty()) {
            Class c = pq.poll();
            if (c.prev >= next) {
                next = c.next;
                answer++;
            } else if (c.next < next) {
                next = c.next;
            }
        }

        System.out.println(answer);
    }
}