package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _14499_주사위_굴리기 {
    static class Dice{
        int x;
        int y;
        LinkedList<Integer> verticalList;
        LinkedList<Integer> horizontalList;

        public Dice(int x, int y){
            this.x = x;
            this.y = y;
            verticalList = new LinkedList<>();
            horizontalList = new LinkedList<>();

            for(int i = 0; i < 4; i++)
                verticalList.add(0);

            for(int i = 0; i < 4; i++)
                horizontalList.add(0);
        }

        public void go(int n){
            n++;
            switch (n) {
                case 1: right(); break;
                case 2: left(); break;
                case 3: up(); break;
                case 4: down(); break;
            }
        }


        public void left(){
            y--;
            int e = verticalList.getFirst();
            verticalList.removeFirst();
            verticalList.addLast(e);


            horizontalList.set(1, verticalList.get(1));
            horizontalList.set(3, verticalList.getLast());
        }

        public void right(){
            y++;
            int e = verticalList.getLast();
            verticalList.removeLast();
            verticalList.addFirst(e);

            horizontalList.set(1, verticalList.get(1));
            horizontalList.set(3, verticalList.getLast());
        }


        public void up(){
            x--;
            int e = horizontalList.getFirst();
            horizontalList.removeFirst();
            horizontalList.addLast(e);

            verticalList.set(1, horizontalList.get(1));
            verticalList.set(3, horizontalList.getLast());
        }

        public void down(){
            x++;
            int e = horizontalList.getLast();
            horizontalList.removeLast();
            horizontalList.addFirst(e);

            verticalList.set(1, horizontalList.get(1));
            verticalList.set(3, horizontalList.getLast());
        }

        public void setBottomNumber(int num){
            verticalList.set(3, num);
            horizontalList.set(3, num);
        }

        public int getBottomNumber(){
            return horizontalList.getLast();
        }

        public int getUpNumber(){
            return horizontalList.get(1);
        }
    }
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(x, y);

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < k; i++){
            int d = Integer.parseInt(st.nextToken()) - 1;

            x = dice.x + dx[d];
            y = dice.y + dy[d];

            if(x >= 0 && x < n && y >= 0 && y < m){
                dice.go(d);

                if(arr[x][y] == 0){
                    arr[x][y] = dice.getBottomNumber();
                }else{
                    dice.setBottomNumber(arr[x][y]);
                    arr[x][y] = 0;
                }

                System.out.println(dice.getUpNumber());
            }
        }
    }
}