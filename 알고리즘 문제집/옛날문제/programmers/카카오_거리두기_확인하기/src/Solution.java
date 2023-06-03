import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int a, b;
    int distance;
    Node(int a, int b, int distance){
        this.a = a;
        this.b = b;
        this.distance = distance;
    }
    public void setDistance(int distance){
        this.distance = distance;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getDistance(){
        return distance;
    }
}

public class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static String[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> distance = new ArrayList<>();

    static public int[] solution(String[][] places) {
        int a = places[0].length;
        int b = places[0][0].length();
        for(int i = 0; i < a; i++){
            char[][] place = new char[a][b];
            for(int j = 0; j < b; j++) {
                    place[j] = places[i][j].toCharArray();
            }
            bfs(place);
        }
        int[] answer = distance.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    static public void bfs(char[][] place) {
        boolean check = true;
        int n = place.length;
        int m = place[0].length;
        ArrayList<Node> people = new ArrayList<Node>(); // 사람이 앉아있는 좌표 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (place[i][j] == 'P')
                    people.add(new Node(i, j, 0));
            }
        }
        Queue<Node> q = new LinkedList<>();
        loop:
        for (int i = 0; i < people.size(); i++) {
            visit = new boolean[n][m];
            q.offer(people.get(i));
            while (!q.isEmpty()) {
                Node node = q.poll();
                int x = node.getA();
                int y = node.getB();
                visit[x][y] = true;
                for (int j = 0; j < 4; j++) {
                    int a = x + dx[j];
                    int b = y + dy[j];
                    int distance = node.getDistance()+1;
                    if (a >= 0 && a < n && b >= 0 && b < m) {
                        if(visit[a][b] == true)
                            continue;
                        if(place[a][b] == 'X') // 벽일 때
                            continue;
                        if(place[a][b] == 'P' && distance <= 2){ // 거리두기가 안지켜 졌을 때
                            check = false;
                            break loop;
                        }else if(distance <= 2){
                            q.offer(new Node(a, b, distance));
                        }
                    }
                }
            }
        }
        if(check){
            distance.add(1);
        }else{
            distance.add(0);
        }
    }
}
