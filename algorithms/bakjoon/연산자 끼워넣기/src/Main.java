import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] oper_num;
    static boolean[] visited[];
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        oper_num = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++)
            oper_num[i] = Integer.parseInt(st.nextToken());
        dfs(num[0], 0);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    // 백트래킹
    public static void dfs(int sum, int idx) {
        if(idx == num.length-1){
            if(sum < MIN){
                MIN = sum;
            }
            if(sum > MAX){
                MAX = sum;
            }
        }
        for(int i = 0; i < 4; i++){
            if(oper_num[i] > 0){
                oper_num[i]--;
                switch(i){
                    case 0:
                        dfs(sum + num[idx+1], idx+1);
                        break;
                    case 1:
                        dfs(sum - num[idx+1], idx+1);
                        break;

                    case 2:
                        dfs(sum * num[idx+1], idx+1);
                        break;

                    case 3:
                        dfs(sum / num[idx+1], idx+1);
                        break;
                }
                oper_num[i]++;
            }
        }
    }
}
