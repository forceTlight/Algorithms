import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2_11_임시_반장_정하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[n];
        int[][] arr = new int[n][5];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        /**
         * 내가 작성한 코드
         */
//        for(int i = 0; i < n; i++){
//            boolean visited[] = new boolean[n];
//            for(int j = 0; j < 5; j++){
//                for(int k = 0; k < n; k++){
//                    if(k == i)
//                        continue;
//
//                    if(!visited[k] && arr[i][j] == arr[k][j]){
//                        cnt[i]++;
//                        visited[k] = true;
//                    }
//                }
//            }
//        }
//
//        int max = Integer.MIN_VALUE;
//        int answer = 0;
//        for(int i = 0; i < n; i++){
//            if(max < cnt[i]){
//                max = cnt[i];
//                answer = i + 1;
//            }
//        }
//        System.out.println(answer);

        /**
         * 강의에서 알려준 코드
         */
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < 5; k++){
                    if(arr[i][k] == arr[j][k]){
                        count++;
                        break;
                    }
                }
            }

            if(max < count){
                max = count;
                answer = i;
            }
        }

        System.out.println(answer + 1);
    }
}
