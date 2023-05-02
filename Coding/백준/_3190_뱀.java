package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _3190_뱀 {
    static class Node{
        int a;
        int b;

        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }


    }
    static class Snake{

        LinkedList<Node> linkedList;

        int direction;

        public Snake(){
            linkedList = new LinkedList<>();
            linkedList.add(new Node(0,0 ));
            this.direction = 90;
        }

        // 0 -> 상, 90 -> 우, 180 -> 하, 270 -> 좌
        public void changeDirection(int direction){
            int sum = this.direction + direction;

            if(sum == 360)
                this.direction = 0;
            else if(sum == - 90)
                this.direction = 270;
            else
                this.direction = sum;
        }

        // 뱀의 몸통이랑 충돌 여부
        public boolean isCrash(Node node){
            for(Node n : linkedList){
                if(n.a == node.a && n.b == node.b)
                    return true;
            }

            return false;
        }

        public Node getHead(){
            return linkedList.getLast();
        }

        public Node getTail(){
            return linkedList.getFirst();
        }

        public void addHead(Node node){
            this.linkedList.add(node);
        }

        public void removeTail(){
            this.linkedList.removeFirst();
        }
    }
    static int[][] board;
    static HashMap<Integer, Integer> hashMap;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[n][n]; // 0 -> 빈 공간, 1 -> 사과
        hashMap = new HashMap<>();

        for(int i = 0; i < k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a - 1][b - 1] = 1;
        }

        int x = Integer.parseInt(br.readLine());
        for(int i = 0; i < x; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            int direction = st.nextToken().charAt(0) == 'L'? -90 : 90;

            hashMap.put(second, direction);
        }

        Snake snake = new Snake();

        int second = 0;
        while(true){
            second++;

            int direction = snake.direction;

            Node head = snake.getHead();

            int a = head.a;
            int b = head.b;

            switch(direction){
                case 0:
                    a--;
                    break;
                case 90:
                    b++;
                    break;

                case 180:
                    a++;
                    break;

                case 270:
                    b--;
                    break;
            }

            // 뱀의 머리가 벽에 부딪혔을 경우
            if(a < 0 || a >= n || b < 0 || b >= n){
                break;
            }

            // 뱀의 몸통에 부딪혔을 경우
            if(snake.isCrash(new Node(a, b))){
                break;
            }

            snake.addHead(new Node(a, b));

            if(board[a][b] == 1){
                board[a][b] = 0;
            }else{
                snake.removeTail();
            }

            if(hashMap.containsKey(second)){
                snake.changeDirection(hashMap.get(second));
            }
        }

        System.out.println(second);
    }
}