package 인프런.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 좌표_정렬 {
    static class Node implements Comparable<Node>{
        int x;
        int y;
        public Node (int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> nodeList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(x, y));
        }
        Collections.sort(nodeList);
        for(Node node : nodeList){
            bw.write(node.x + " " + node.y + "\n");
        }

        bw.flush();
    }
}