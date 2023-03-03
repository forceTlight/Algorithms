import java.util.Stack;

class Node {
    int pointer;
    int prev;
    int next;

    Node(int pointer, int prev, int next) {
        this.pointer = pointer;
        this.prev = prev;
        this.next = next;
    }

    int getPointer() {
        return pointer;
    }

    int getPrev() {
        return prev;
    }

    int getNext() {
        return next;
    }
}
class Table {

    private Stack<Node> nodeStack;

    private StringBuilder result;

    private int pointer;

    private int[] prev;
    private int[] next;

    public Table(int n, int pointer) {
        this.pointer = pointer;
        nodeStack = new Stack<>();
        prev = new int[n];
        next = new int[n];
        result = new StringBuilder("O".repeat(n));

        // LinkedList
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    // U X
    public void upChoice(int c) {
        while(c -- > 0)
            pointer = prev[pointer];
    }

    // D X
    public void downChoice(int c) {
        while(c -- > 0)
            pointer = next[pointer];
    }

    // C
    public void removeAndBelowChoice() {
        nodeStack.push(new Node(pointer, prev[pointer], next[pointer]));

        if (prev[pointer] != -1)
            next[prev[pointer]] = next[pointer];
        if (next[pointer] != -1)
            prev[next[pointer]] = prev[pointer];

        result.setCharAt(pointer, 'X');

        if (next[pointer] != -1)
            pointer = next[pointer];
        else
            pointer = prev[pointer];
    }

    // Z
    public void repairRecentlyDeleted() {
        Node node = nodeStack.pop();

        if (node.getPrev() != -1)
            next[node.getPrev()] = node.getPointer();

        if (node.getNext() != -1)
            prev[node.getNext()] = node.getPointer();

        result.setCharAt(node.getPointer(), 'O');
    }

    public String toString() {
        return result.toString();
    }
}

public class Main {

    public static void main(String args[]) {
        String[] input = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(8, 2, input));
    }

    public static String solution(int n, int k, String[] cmd) {
        Table table = new Table(n, k);

        for (String s : cmd) {
            if (s.startsWith("U")) {
                table.upChoice(Integer.parseInt(s.substring(2)));
            } else if (s.startsWith("D")) {
                table.downChoice(Integer.parseInt(s.substring(2)));
            } else if (s.startsWith("C")) {
                table.removeAndBelowChoice();
            } else {
                table.repairRecentlyDeleted();
            }
        }

        return table.toString();
    }
}
