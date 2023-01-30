import java.io.*;
import java.util.*;

public class _2075_N번째_큰수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
            {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // solution
        // 최소 값, 최댓 값 찾기
        List<Integer> candidateList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if (arr[0][i] > max) {
                max = arr[0][i];
            } else if (arr[0][i] < min) {
                min = arr[0][i];
            }
            candidateList.add(arr[0][i]);
        }
        int max_size = max - min;

        loop:
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                if(max_size >= candidateList.size())
                    break loop;

                if(arr[j][i] < max){
                    candidateList.add(arr[j][i]);
                }
            }
        }

        Collections.sort(candidateList);

        System.out.println(candidateList.get(n-1));

    }
}
