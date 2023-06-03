import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
    static int cnt = 0;
    static boolean[][] network;
    static boolean[] virus;
    static boolean[][] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        network = new boolean[n][n];
        visit = new boolean[n][n];
        virus = new boolean[n];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a - 1][b - 1] = true;
        }
        dfs(0,0);
        for(int i = 1; i < n; i++){
            if(virus[i]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int a, int b) {
        for(int i = 0; i < n; i++) {
            if (!virus[i]) {
                if (network[i][b] == true && !visit[i][b]) {
                    visit[i][b] = true;
                    virus[i] = true;
                    dfs(i, b);
                }
                if (network[b][i] == true && !visit[b][i]) {
                    visit[b][i] = true;
                    virus[i] = true;
                    dfs(b, i);
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(!virus[i]) {
                if (network[a][i] == true && !visit[a][i]) {
                    visit[a][i] = true;
                    virus[i] = true;
                    dfs(a, i);
                }
                if (network[i][a] == true && !visit[i][a]) {
                    visit[i][a] = true;
                    virus[i] = true;
                    dfs(i, a);
                }
            }
        }
    }
}
