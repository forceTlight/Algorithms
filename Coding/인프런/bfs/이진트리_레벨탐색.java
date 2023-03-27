package 인프런.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 이진트리_레벨탐색 {
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
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while(!queue.isEmpty()){
            bw.write(L + " ");
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node node = queue.poll();
                bw.write(node.data + " ");

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            bw.write("\n");
            L++;
        }

        bw.flush();
    }
}