package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1700_멀티탭_스케줄링 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] input = new int[k];
        for(int i = 0; i < k; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> hashSet = new HashSet<>();

        int answer = 0;

        // i는 순서를 의미함
        for(int i = 0; i < k; i++){
            int item = input[i];

            if(hashSet.contains(item))
                continue;

            if(hashSet.size() < n){
                hashSet.add(item);
                continue;
            }

            int sequence = Integer.MIN_VALUE;
            int deleteItem = 0;

            // 사용 안하는 콘센트 있는지 확인
            boolean check = false;

            loop:
            for(int tmpItem : hashSet){
                for(int j = i + 1; j < k; j++){
                    if(input[j] == tmpItem){
                        continue loop;
                    }
                }

                check = true;
                deleteItem = tmpItem;
                break;
            }

            if(!check) {
                for (int tmpItem : hashSet) {
                    for (int j = i + 1; j < k; j++) {
                        // 가장 늦게 사용되는 콘센트 제거
                        if (input[j] == tmpItem) {
                            if(j < sequence)
                                break;
                            sequence = j;
                            deleteItem = tmpItem;
                            break;
                        }
                    }
                }
            }

            hashSet.remove(deleteItem);
            hashSet.add(item);
            answer++;
        }

        System.out.println(answer);
    }
}