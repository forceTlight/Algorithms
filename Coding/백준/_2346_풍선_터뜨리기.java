package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2346_풍선_터뜨리기 {
    static int[] answer;
    static class Node{
        int data;
        boolean visited;
        public Node(int data){
            this.data = data;
            this.visited = false;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Node> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int data = Integer.parseInt(st.nextToken());
            arrayList.add(new Node(data));
        }

        int pos = 0;
        answer[0] = 1;
        arrayList.get(0).visited = true;
        for(int i = 1; i < n; i++){
            int data = arrayList.get(pos).data;

            while(data > 0){
                pos++;
                if(pos >= n)
                    pos = 0;
                if(arrayList.get(pos).visited)
                    continue;

                data--;
            }

            while(data < 0){
                pos--;
                if(pos < 0)
                    pos = n-1;
                if(arrayList.get(pos).visited)
                    continue;

                data++;
            }

            arrayList.get(pos).visited = true;
            answer[i] = pos+1;
        }

        for(int a : answer)
            System.out.print(a + " ");
    }
}