import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10_가장_짧은_문자거리 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = br.readLine().split(" ");
//        String s = input[0];
//        char t = input[1].charAt(0);
//
//        char[] c = s.toCharArray();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        for(int i = 0; i < c.length; i++){
//            if(c[i] == t)
//                list.add(i);
//        }
//
//        for(int i = 0; i < c.length; i++){
//            int min = 999;
//            for(int j = 0; j < list.size(); j++){
//                int distance = Math.abs(i - list.get(j));
//                if(min > distance)
//                    min = distance;
//            }
//            System.out.print(min + " ");
//        }

        /**
         * t 값을 기준으로 왼쪽, 오른쪽으로 탐색해서 풀기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String s = input[0];
        char t = input[1].charAt(0);

        char[] c = s.toCharArray();
        int[] answer = new int[c.length];

        // left
        int p = 1000;

        for(int i = 0; i < c.length; i++){
            if(c[i] == t)
                p = 0;

            answer[i] = p++;
        }

        // right
        p = 1000;

        for(int i = c.length - 1; i >= 0; i--){
            if(c[i] == t)
                p = 0;

            answer[i] = Math.min(answer[i], p++);
        }

        // print
        for(int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }
}
