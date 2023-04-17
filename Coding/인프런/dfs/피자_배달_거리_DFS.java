package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 피자_배달_거리_DFS {
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static boolean[] visited;
    static ArrayList<Node> pizzaList;
    static ArrayList<Node> homeList;
    static Node[] choice;
    static int answer = Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pizzaList = new ArrayList<>();
        homeList = new ArrayList<>();
        choice = new Node[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int p = Integer.parseInt(st.nextToken());
                if(p == 1){
                    homeList.add(new Node(i, j));
                }else if(p == 2){
                    pizzaList.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[pizzaList.size()];
        dfs(0, 0);

        System.out.println(answer);
    }

    // 피자집 m개 선택하기
    public static void dfs(int depth, int idx){
        if(depth == m){
            int sum = 0;
            for(int i = 0; i < homeList.size(); i++){
                Node home = homeList.get(i);
                int minDistance = Integer.MAX_VALUE;
                for(int j = 0; j < choice.length; j++){
                    Node pizza = choice[j];
                    int distance = Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y);
                    minDistance = Math.min(minDistance, distance);
                }
                sum += minDistance;
                if(sum >= answer)
                    return;
            }

            answer = Math.min(answer, sum);
            return;
        }

        for(int i = idx; i < pizzaList.size(); i++) {
            if (!visited[i]) {
                choice[depth] = pizzaList.get(i);
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}