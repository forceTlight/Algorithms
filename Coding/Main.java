import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
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

        System.out.println("YES");
    }
}