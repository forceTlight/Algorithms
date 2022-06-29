import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String L;
    static String R;
    static int min = Integer.MAX_VALUE;
    /*
        메커니즘
        1. 자릿수 다르면 무조건 8이 안들어가는 수 발생 함
        2. 자릿수 같으나, 하나하나 비교해서 다르면 8이 안들어가는 수 발생함
     */
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        L = st.nextToken();
        R = st.nextToken();
        int cnt = 0;
        // 자릿수 다른지 비교
        if(L.length() != R.length()){
            cnt = 0;
        }else{
            // 각 자릿수 같은지 비교
            int size = L.length();
            for(int i = 0; i < size; i++){
                if(L.charAt(i) == R.charAt(i) && L.charAt(i) == '8'){
                    cnt++;
                }else if(L.charAt(i) == R.charAt(i)){ // 같으면 continue
                    continue;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
