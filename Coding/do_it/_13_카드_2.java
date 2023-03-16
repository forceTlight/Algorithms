package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 큐
// 카드 -> 1부터 N까지의 번호 붙어있음, 1번 카드 제일 위, N번 카드 제일 아래
// Action -> 카드가 한 장 남을때 까지 반복함
// 1. 제일 위에 있는 카드 바닥에 버림
// 2. 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮김
// 제일 마지막에 남게되는 카드를 구해라
public class _13_카드_2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            queue.add(i+1);
        }

        while(queue.size() > 1){
            queue.poll();
            if(!queue.isEmpty()){
                int num = queue.poll();
                queue.add(num);
            }
        }

        System.out.println(queue.poll());
    }
}