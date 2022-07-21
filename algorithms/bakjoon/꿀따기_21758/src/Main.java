import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        int max = Integer.MIN_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int honey[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            honey[i] = Integer.parseInt(st.nextToken());

        // 꿀벌 1 왼쪽, 꿀벌 2 오른쪽 고정, 꿀통 위치 선택
        int sum = 0;
        for(int i = 1; i < n-1; i++){
            sum = 0;
            for(int j = 1; j <= i; j++){
                sum += honey[j];
            }
            for(int j = i; j < n-1; j++){
                sum += honey[j];
            }
            max = Math.max(max, sum);
        }

        //꿀통 제일 왼쪽에 고정, 꿀벌 1 오른쪽 고정, 꿀벌 2 이동
        for(int i = 0; i < n-1; i++){
            sum = 0;
            for(int j = 0; j < i; j++){
                sum += honey[j];
            }
            for(int j = 0; j < n-1; j++){
                if(j == i)
                    continue;
                sum += honey[j];
            }
            max = Math.max(max, sum);
        }

        //꿀통 제일 오른쪽에 고정, 꿀벌 1 왼쪽 고정, 꿀벌 2 이동
        for(int i = 1; i < n; i++){
            sum = 0;
            for(int j = i+1; j < n; j++){
                sum += honey[j];
            }
            for(int j = 1; j < n; j++){
                if(j == i)
                    continue;
                sum += honey[j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
