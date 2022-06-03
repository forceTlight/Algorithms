import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n; // people number
    static int m; // party number
    static int cnt = 0;
    static HashMap<Integer, Boolean> people = new HashMap<Integer, Boolean>();
    static int[][] party;
    static int truth_num;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        party = new int[m][n];
        // hashmap 초기화
        for(int i = 0; i < n; i++)
            people.put(i+1, false);
        st = new StringTokenizer(br.readLine(), " ");
        truth_num = Integer.parseInt(st.nextToken());
        for(int i = 0; i < truth_num; i++)
            people.put(Integer.parseInt(st.nextToken()), true);
        for(int i = 0; i < m; i++){
            String input = br.readLine();
            String[] inputs = input.split(" ");
            for(int j = 1; j < inputs.length-1; j++){ // 파티 정보 담기
                party[i][j] = Integer.parseInt(inputs[j]);
            }
            int n = Integer.parseInt(inputs[0]);
            for(int j = 0; j < n; j++){
                for(Integer p: people.keySet()){
                    if(people.get(Integer.parseInt(inputs[j])) == true){ // 진실을 알고있는 사람이 파티에 있다면
                        for(int k = 0; k < n; k++){ // 그 파티에 있는사람 진실을 알고있다고 변경
                            people.put(Integer.parseInt(inputs[k+1]), true);
                            break;
                        }
                    }
                }
            }
        }
        // 거짓말 할 수 있는 파티 수 구하기
        for(int i = 0; i < party.length; i++){
            boolean check = true;
            for(int j = 0; j < party[0].length; j++){
                int p = party[i][j];
                if(p == 0)
                    break;
                if(people.get(p) == true){
                    check = false;
                    break;
                }
            }
            if(check)
                cnt++;
        }
        System.out.println(cnt);
    }
}
