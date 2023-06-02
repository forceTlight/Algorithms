package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1011_Fly_me_to_the_Alpha_Centauri {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = b - a;
            int ans = 0;
            long num = 0;
            int p = 1;
            boolean check = false;

            while(num < dis){
                if(!check){
                    num += p;
                    check = true;
                }else{
                    check = false;
                    num += p;
                    p++;
                }

                ans++;
            }

            System.out.println(ans);
        }
    }
}