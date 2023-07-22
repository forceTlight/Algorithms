import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int cnt = 0;
    static int n;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(map.containsKey(k)){
                int existValue = map.get(k);
                // 다른지 비교
                if(v != existValue){
                    cnt ++;
                    map.put(k, v);
                }
            }else{
                map.put(k, v);
            }
        }
        System.out.println(cnt);
    }
}
