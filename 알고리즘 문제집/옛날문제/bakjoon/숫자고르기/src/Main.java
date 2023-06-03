import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static boolean find = false;
    static int n;
    static int num[];
    static int arr[];
    static boolean visit[];
    static ArrayList<Integer> list;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        arr = new int[n];
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            num[i] = i+1;
        }
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = n-1; i >= 0; i--){
            if(find)
                break;
            combine(0, 0, i);
        }
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
    static void combine(int idx, int cnt, int m){
        if(cnt == m){
            compare();
            return;
        }
        for(int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combine(idx + 1, cnt + 1, m);
                visit[i] = false;
            }
        }
    }
    static void compare(){
        ArrayList<Integer> num_list = new ArrayList<>();
        ArrayList<Integer> arr_list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visit[i] == true){
                if(arr_list.contains(arr[i])){ // 값이 중복해서 있을 경우
                    return;
                }
                num_list.add(num[i]);
                arr_list.add(arr[i]);
            }
        }
        if(num_list.containsAll(arr_list)){
            list = num_list;
            find = true;
        }
    }
}
