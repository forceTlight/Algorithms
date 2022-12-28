import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2_7_점수_계산 {
    public static void main(String args[]) throws IOException {
        /**
         * 내가 작성한 코드
         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        String[] input = br.readLine().split(" ");
//        int[] scores = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
//
//        int point = 0;
//        int sum = scores[0];
//        for(int i = 1; i < n; i++){
//            if(scores[i] == 1){
//                if(scores[i-1] == 1){
//                    point++;
//                }else{
//                    point = 0;
//                }
//                sum += 1 + point;
//            }
//        }
//
//        System.out.println(sum);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] scores = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == 1)
                sum += ++cnt;
            else
                cnt = 0;
        }
        System.out.println(sum);
    }
}
