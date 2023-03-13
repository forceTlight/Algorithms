package 기타;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스_검사 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] store = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; st.hasMoreTokens(); i++)
            store[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int leader = Integer.parseInt(st.nextToken()); // 팀장 검사 수
        int worker = Integer.parseInt(st.nextToken()); // 팀원 검사 수

        // process
        long sum = 0;
        for(int i = 0; i < n; i++){
            int people = store[i];
            people -= leader;
            sum++;

            if(people > 0){
                sum += people / worker;
                if(people % worker != 0)
                    sum++;
            }
        }

        System.out.println(sum);
    }
}