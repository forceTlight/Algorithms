package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 의좋은_형제 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n1 = Integer.parseInt(st.nextToken()); // 진우
        int n2 = Integer.parseInt(st.nextToken()); // 선우
        int day = Integer.parseInt(br.readLine());


        for(int i = 0; i < day; i++){
            if(i % 2 == 0){ // 진우- 선우+
                n2 += Math.round((double) n1 / 2);
                n1 /= 2;
            }else{ // 선우- 진우+
                n1 += Math.round((double) n2 / 2);
                n2 /= 2;
            }
        }

        System.out.println(n1 + " " + n2);
    }
}