package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _13414_수강신청 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<String> deque = new LinkedList<>();
        boolean[] visited = new boolean[m];
        HashMap<String, Integer> hashMap = new HashMap<>(); // 제일 마지막에 있는 위치를 나타냄
        for(int i = 0; i < m; i++){
            String stuNum = br.readLine();
            if(hashMap.containsKey(stuNum)){ // 후순위 대기열에 배치
                visited[hashMap.get(stuNum)] = true;
                hashMap.put(stuNum, i);
                deque.addLast(stuNum);
            }else{
                hashMap.put(stuNum, i);
                deque.addLast(stuNum);
            }
        }

        // 중복되는거 제거
        int cnt = 0;
        int size = deque.size();
        for(int i = 0; i < size; i++){
            String stuNum = deque.poll();
            if(!visited[i]){
                System.out.println(stuNum);
                cnt++;
            }

            if(cnt == n)
                break;
        }
    }
}