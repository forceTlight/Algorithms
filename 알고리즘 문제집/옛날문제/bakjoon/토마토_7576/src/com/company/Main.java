package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    int idx, distance;
    public Node(int idx, int distance){
        this.idx = idx;
        this.distance = distance;
    }
    public int getIdx(){
        return idx;
    }
    public int getDistance(){
        return distance;
    }
}
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int[][] map;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> q = new LinkedList<>();
        // 익은 토마토 큐에 집어넣기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1){
                    q.offer(new Node(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.getIdx();
            int y = node.getDistance();
            for(int i = 0; i < 4; i++){
                int a = x + dx[i];
                int b = y + dy[i];
                if(a >= 0 && a < n && b >= 0 && b < m) {
                    if (map[a][b] == 0) {
                        q.offer(new Node(a, b));
                        map[a][b] = map[x][y] + 1;
                    }
                }
            }
        }
        // max 값 찾기
        int max = -1;
        loop:
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    max = 0;
                    break loop;
                }
                if(max < map[i][j]){
                    max = map[i][j];
                }
            }
        }
        if(max == -1 || max == 0){
            return -1;
        }else{
            return max-1;
        }
    }
}
