import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int a, b;

    Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}

public class Main {
    static int answer = 1;
    static int min = 0;
    static int[][] arr;
    static int x_length;
    static int y_length;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String inputs[] = input.split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        arr = new int[n][m];
        x_length = arr[0].length;
        y_length = arr.length;
        inputs = new String[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = bf.readLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = inputs[i].charAt(j);
            }
        }
        // max 값 구하기
        if(x_length <= y_length){
            min = x_length;
        }else{
            min = y_length;
        }
        Node node = new Node(0, 0);
        process(node, 1);
        System.out.println(answer);
    }

    // int a, b 시작 점
    public static void process(Node node, int size) {
        if (min <= size) {
            return;
        }
        int a = node.a;
        int b = node.b;
        int x = a + size;
        int y = b + size;
        if (x == x_length) {
            node.setA(0);
            node.setB(++b);
            process(node, size);
            return;
        }
        if (y == y_length) {
            size++;
            node.setA(0);
            node.setB(0);
            process(node, size);
            return;
        }
        // 4개의 꼭짓점이 같다면 값 구하기
        if (arr[b][a] == arr[b][x] && arr[b][x] == arr[y][a] && arr[y][a] == arr[y][x]) {
            answer = (size + 1) * (size + 1);
        }
        node.setA(++a);
        process(node, size);
    }
}
