package 인프런.dfs;

import java.io.*;

public class 말단_노드까지_제일_짧은경로_DFS {
    static int min = Integer.MAX_VALUE;
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

        dfs(root, 0);
        System.out.println(min);
    }

    public static void dfs(Node node, int depth){
        if(node == null){
            min = Math.min(depth-1, min);
            return;
        }

        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}