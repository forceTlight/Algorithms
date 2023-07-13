package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 15787 - 기차가 어둠을 헤치고 은하수를
 * 문제유형 : 구현
 * 난이도 : SILVER 2
 * 풀이시간 : 1시간
 */
public class _15787_기차가_어둠을_헤치고_은하수를 {
    static StringBuilder[] trains;
    static HashSet<String> hashSet;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 기차 수
        int m = Integer.parseInt(st.nextToken()); // 명령 수

        hashSet = new HashSet<>(); // 중복 체크를 위한 Set
        trains = new StringBuilder[n];

        for(int i = 0; i < n; i++){
            trains[i] = new StringBuilder("00000000000000000000");
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if(op == 1 || op == 2){
                int tId = Integer.parseInt(st.nextToken()) -1;
                int sId = Integer.parseInt(st.nextToken()) -1;

                if(op == 1){
                    addPerson(tId, sId);
                }else{
                    deletePerson(tId, sId);
                }
            }else{
                int tId = Integer.parseInt(st.nextToken()) -1;

                if(op == 3){
                    backAllPerson(tId);
                }else{
                    frontAllPerson(tId);
                }
            }
        }

        // 은하수를 건널 수 있는 기차 검사
        for(int i = 0; i < n; i++){
            StringBuilder sb = trains[i];
            hashSet.add(sb.toString());
        }

        System.out.println(hashSet.size());
    }

    // 1번 명령어 - i 번째 기차 x 좌석에 사람을 태워라, 이미 사람이 타있다면, 아무런 행동을 하지 않는다
    public static void addPerson(int tId, int sId){
        StringBuilder sb = trains[tId];
        if(sb.charAt(sId) == '0'){// 사람이 타있지 않으면
            sb.setCharAt(sId, '1');
        }
    }

    // 2번 명령어 - i번째 기차 x번째 앉은 사람은 하차한다. 만약, 아무도 그 자리에 앉아있지 않으면 아무런 행동을 하지 않는다.
    public static void deletePerson(int tId, int sId){
        StringBuilder sb = trains[tId];
        if(sb.charAt(sId) == '1'){ // 사람이 타있으면
            sb.setCharAt(sId, '0');
        }
    }

    // 3번 명령어 - i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. 만약 20번째 사람이 있으면 명령 후 하차한다.
    public static void backAllPerson(int tId){
        StringBuilder sb = trains[tId];
        for(int i = 19; i > 0; i--){
            char tmp = sb.charAt(i - 1);
            sb.setCharAt(i, tmp);
        }

        sb.setCharAt(0, '0');
    }

    // 4번 명령어 - i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로 간다. 만약 1번째 자리에 사람이 앉았다면 명령 후 하차한다.
    public static void frontAllPerson(int tId){
        StringBuilder sb = trains[tId];
        for(int i = 0; i < 19; i++){
            char tmp = sb.charAt(i+1);
            sb.setCharAt(i, tmp);
        }

        sb.setCharAt(19, '0');
    }
}