import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    static boolean visit[];
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);
        System.out.println(min);
    }
    public static void combi(int idx, int count){
        if(count == n / 2){
            diff();
            return;
        }
        for(int i = idx; i < n; i++) {
            // 방문하지 않았다면
            if (!visit[i]) {
                visit[i] = true;
                combi(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
    public static void diff(){
        int start_sum = 0;
        int link_sum = 0;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++)
            if(visit[i] == true && visit[j] == true){
                start_sum += arr[i][j];
                start_sum += arr[j][i];
            }else if(visit[i] == false && visit[j] == false){
                link_sum += arr[i][j];
                link_sum += arr[j][i];
            }
        }
        int sum = Math.abs(start_sum - link_sum);
        /*
            만약 두 팀 차이가 0이면 최소이기 때문에 바로 나가면 됨
         */
        if(sum == 0){
            System.out.println(sum);
            System.exit(0);
        }
        min = Math.min(sum, min);
    }
}
