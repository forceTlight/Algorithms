package 인프런.dfs;
import java.io.*;

public class 이진트리탐색 {
    static class Node{
        Node left;
        Node right;
        String data;

        public Node(String data){
            this.data = data;
        }
    }
    public static void main(String args[]) throws IOException {
        Node root = new Node("1");
        root.left = new Node("2");
        root.left.left = new Node("4");
        root.left.right = new Node("5");
        root.right = new Node("3");
        root.right.left = new Node("6");
        root.right.right = new Node("7");

        dfs1(root);
        System.out.println();

        dfs2(root);
        System.out.println();

        dfs3(root);
        System.out.println();
    }

    // 전위순회
    public static void dfs1(Node node){
        if(node == null)
            return;

        System.out.print(node.data + " ");
        dfs1(node.left);
        dfs1(node.right);
    }

    // 중위순회
    public static void dfs2(Node node){
        if(node == null)
            return;

        dfs2(node.left);
        System.out.print(node.data + " ");
        dfs2(node.right);
    }

    // 후위순회
    public static void dfs3(Node node){
        if(node == null)
            return;

        dfs3(node.left);
        dfs3(node.right);
        System.out.print(node.data + " ");
    }
}