package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class _2021_최소_환승_경로 {
    static boolean[] stationVisited;
    static boolean[] lineVisited;
    static int[] distance;
    static ArrayList<Integer>[] stationAdj; // 역 인접 리스트
    static ArrayList<Integer>[] lineAdj; // 노선 인접 리스트
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 역의 개수
        int m = Integer.parseInt(st.nextToken()); // 노선의 개수
        stationAdj = new ArrayList[n+1]; // 인접 리스트 생성
        lineAdj = new ArrayList[m+1]; // 인접 리스트 생성
        lineVisited = new boolean[m+1];
        stationVisited = new boolean[n+1];
        distance = new int[n+1];

        for(int i = 0; i <= m; i++)
            lineAdj[i] = new ArrayList<>();

        for(int i = 0; i <= n; i++)
            stationAdj[i] = new ArrayList<>();

        for(int i = 1; i <= m; i++){ // n은 역의 개수이고 m은 노선의 개수이다,
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int s = Integer.parseInt(st.nextToken());
                if(s == -1)
                    break;

                lineAdj[i].add(s); // adj[i]
                stationAdj[s].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int startStation = Integer.parseInt(st.nextToken());
        int endStation = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(startStation);
        loop:
        while(!q.isEmpty()){
            int station = q.poll();
            int dis = distance[station];
            // 해당 역을 가지고 있는 노선
            for(int line : stationAdj[station]) {
                if (!lineVisited[line]) {
                    lineVisited[line] = true;
                    for (int s : lineAdj[line]) {
                        if (!stationVisited[s]) {
                            distance[s] = dis + 1;
                            stationVisited[s] = true;
                            q.offer(s);

                            // 목적지에 도달했을 때
                            if(s == endStation){
                                break loop;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(distance[endStation] - 1);
    }
}