package 인프런.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 말단_노드까지_제일_짧은경로_BFS {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int answer = 0;
        loop:
        while(!q.isEmpty()){
            int size = q.size();
            answer++;
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                if(node.left == null && node.right == null)
                    break loop;

                if(node.left != null)
                    q.offer(node.left);

                if(node.right != null)
                    q.offer(node.right);
            }
        }

        System.out.println(answer);
    }
}