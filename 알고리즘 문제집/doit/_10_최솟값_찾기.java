package doit;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10_최솟값_찾기 {
    static class Node {
        int value;
        int index;

        public Node(int index, int value) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().getValue() > now) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, now));

            if (i >= m) {
                if (deque.getFirst().getIndex() == i - m)
                    deque.removeFirst();
            }
            bw.write(deque.getFirst().getValue() + " ");
        }
        bw.flush();
        bw.close();
    }
}