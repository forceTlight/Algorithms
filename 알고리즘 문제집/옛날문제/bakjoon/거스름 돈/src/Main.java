import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        if(m < 5 && m % 2 != 0){
            System.out.println(-1);
            return;
        }
        boolean check = false;
        int cnt = 0;
        while(true){
            if(m == 0)
                break;
            if(m >= 5 && !check){
                m -= 5;
                cnt++;
            }else if(m >= 2 && m % 2 == 0){
                m -= 2;
                cnt++;
            }else{
                check = true;
                m += 5;
                cnt--;
            }
        }
        System.out.println(cnt);
    }
}
