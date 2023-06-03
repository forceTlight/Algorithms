package 인프런.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 순열_구하기 {
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;
    static boolean visited[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0);
    }

    public static void dfs(int depth){
        if(depth == m){
            for(int a : answer)
                System.out.print(a + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[depth] = arr[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}