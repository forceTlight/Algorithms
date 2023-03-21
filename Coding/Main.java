import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i = 0; i < n; i++){
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;

            if(answer == 1)
                break;
        }

        System.out.println(answer);
    }

    public static void dfs(int num, int depth){
        if(depth == 5 || answer == 1){
            answer = 1;
            return;
        }

        ArrayList<Integer> nodes = adj[num];

        for(int n : nodes){
            if(!visited[n]) {
                visited[n] = true;
                dfs(n, depth + 1);
                visited[n] = false;
            }
        }
    }
}