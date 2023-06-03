package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_구하기 {
    static int n;
    static int r;
    static boolean[] visited;
    static int[] answer;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        answer = new int[r];

        dfs(0, 1);
    }

    public static void dfs(int depth, int idx){
        if(depth == r){
            for(int i = 0; i < r; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i <= n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = i;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}