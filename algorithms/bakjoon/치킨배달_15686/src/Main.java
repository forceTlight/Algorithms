import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int a;
    int b;

    Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Node> chiken = new ArrayList<>();
    static ArrayList<Node> home = new ArrayList<>();
    static ArrayList<Node> chiken_list = new ArrayList<>();
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int idx = Integer.parseInt(st.nextToken());
                if (idx == 1) {
                    home.add(new Node(i, j)); // 집 좌표 설정
                } else if (idx == 2) {
                    chiken.add(new Node(i, j)); // 치킨집 좌표 설정
                }
            }
        }
        visit = new boolean[chiken.size()];
        dfs(0);
        System.out.println(min);
    }

    // 백트래킹 경우의 수 찾는 함수
    public static void dfs(int idx) {
        if (chiken_list.size() == m) {
            calculate();
            return;
        }
        for (int i = idx; i < chiken.size(); i++) {
            if (visit[i] == false) {
                visit[i] = true;
                chiken_list.add(chiken.get(i));
                dfs(i + 1);
                visit[i] = false;
                chiken_list.remove(chiken.get(i));
            }
        }
    }

    // 최단거리 계산하는 함수
    public static void calculate() {
        int answer = 0;
        for (int i = 0; i < home.size(); i++) {
            int min_cal = Integer.MAX_VALUE;
            for (Node chiken: chiken_list) {
                min_cal = Math.min(Math.abs(home.get(i).getA() - chiken.getA()) + Math.abs(home.get(i).getB() - chiken.getB()), min_cal);
                if (min_cal == 1) {
                    min_cal = 1;
                    break;
                }
            }
            answer += min_cal;
        }
        min = Math.min(answer,min);
    }
}

