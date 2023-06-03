package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Print{
    int idx;
    int priority;
    public Print(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
    public int getPriority(){
        return priority;
    }

    public int getIdx(){
        return idx;
    }
}
public class _1966_프린터_큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Print> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            queue.clear();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; st.hasMoreTokens(); j++){
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Print(j, priority));
            }

            // process
            int cnt = 0;
            while(true){
                int max = getCurrentMaxPriority(queue);
                Print print = queue.poll();
                if(print.getPriority() != max){
                    queue.add(print);
                    continue;
                }
                cnt++;
                if(print.getIdx() == position){
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }

    // 현재 max값 구하기
    public static int getCurrentMaxPriority(Queue<Print> queue){
        return queue.stream().mapToInt(q -> q.getPriority()).max().orElse(0);
    }
}