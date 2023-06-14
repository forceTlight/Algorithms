package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 위상 정렬
 */
public class _2252_줄_세우기 {

    public static int[] indegree;
    public static ArrayList<Integer>[] graph;

    public static int n;
    public static int m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        indegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        topologicalSort();
    }

    public static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> resultList = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            resultList.add(node);

            for(int n : graph[node]){
                indegree[n]--;

                if(indegree[n] == 0)
                    q.offer(n);
            }
        }

        for(int n : resultList)
            System.out.print(n + " ");
    }
}