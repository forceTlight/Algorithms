package 인프런.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 교육과정_설계 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Queue<Character> queue = new LinkedList<>();
        for(char c : input.toCharArray())
            queue.offer(c);

        input = br.readLine();
        for(char c : input.toCharArray()){
            if(queue.contains(c)){
                char subject = queue.poll();
                if(c != subject){
                    System.out.println("NO");
                    return;
                }
            }
        }

        if(queue.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}