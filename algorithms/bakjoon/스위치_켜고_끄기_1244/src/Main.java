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
        for (int i = 0; st.hasMoreTokens(); i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int stuNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < stuNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int stuNumIput = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            if (stuNumIput == 1) {
                manSwitch(switchNum);
            } else if (stuNumIput == 2) {
                girlSwitch(switchNum);
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 20 == 0) {
                System.out.print(map[i]);
                System.out.println();
            } else {
                System.out.print(map[i]);
                System.out.print(' ');
            }
        }
    }

    public static void manSwitch(int num) {
        for (int i = 0; i < map.length; i++) {
            if ((i + 1) % num == 0) {
                changeNum(i);
            }
        }
    }

    public static void girlSwitch(int num) {
        int idx = num - 1;
        int left = idx;
        int right = idx;
        changeNum(idx);
        for (int i = 0; i < map.length; i++) {
            left--;
            right++;
            if (left < 0 || right >= map.length) {
                return;
            }
            if (map[left] == map[right]) {
                changeNum(left);
                changeNum(right);
            } else {
                break;
            }
        }
    }

    public static void changeNum(int num) {
        if (map[num] == 1) {
            map[num] = 0;
        } else {
            map[num] = 1;
        }
    }
}
