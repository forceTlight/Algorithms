import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int map[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        map = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; st.hasMoreTokens(); i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int stuNum = Integer.parseInt(br.readLine());
        for(int i = 0; i < stuNum; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int stuNumIput = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            if(stuNumIput == 1){
                manSwitch(switchNum);
            }else if(stuNumIput == 2){
                girlSwitch(switchNum);
            }
        }
        for(int i = 0; i < n; i++){
            if(i == n -1){
                System.out.print(map[i] + ' ');
            }else{
                System.out.print(map[i]);
            }
        }
    }

    public static void manSwitch(int num){
        for(int i = 0; i < map.length; i++){
            if(i+1 % num == 0) {
                changeNum(num);
            }
        }
    }

    public static void girlSwitch(int num){
        int left = num - 1;
        int right = num + 1;
        searchSwitch(left, right, num);
    }

    public static void searchSwitch(int left, int right, int num){
        if(left < 0 || right >= map.length){
            return;
        }
        if(map[left] == map[right]){
            changeNum(left);
            changeNum(right);
            searchSwitch(left -1, right +1, num);
        }else{
            // 처음에 바로 끝났을 경우
            if(left == num - 1 && right == num + 1){
                changeNum(num);
            }
            return;
        }
    }

    public static void changeNum(int num){
        if(map[num] == 1){
            map[num] = 0;
        }else{
            map[num] = 1;
        }
    }
}
