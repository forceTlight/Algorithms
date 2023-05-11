import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for(int j = 0; j < k; j++)
                pq.offer(Long.parseLong(st.nextToken()));

            long sum = 0;
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();

                sum += (a+b);
                pq.offer(a+b);
            }

            System.out.println(sum);
        }
    }
}