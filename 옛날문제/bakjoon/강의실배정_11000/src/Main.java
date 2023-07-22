import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        int max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] room = new int[n][2];
        boolean[] visited = new boolean[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return (o1[1] - o2[1]);
                }
                return (o1[0] - o2[0]);
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(room[0][1]);
        for(int i = 1; i < n; i++){
            if(q.peek() <= room[i][0])
                q.poll();
            q.add(room[i][1]);
        }
        System.out.println(q.size());
    }
}
