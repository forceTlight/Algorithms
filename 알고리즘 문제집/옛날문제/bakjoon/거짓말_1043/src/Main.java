import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    Union Find
 */
public class Main {
    static int n; // people number
    static int m; // party number
    static int[] parent;
    static boolean[] truth;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] parties = new ArrayList[m+1];
        for(int i = 0; i < m; i++){
            parties[i] = new ArrayList<>();
        }
        parent = new int[n+1];
        for(int i = 1; i < parent.length; i++){
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int truth_num = Integer.parseInt(st.nextToken());
        truth = new boolean[n+1];
        for(int i = 0; i < truth_num; i++){
            truth[Integer.parseInt(st.nextToken())] = true;
        }
        // 파티 정보 집어넣기
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int p = Integer.parseInt(st.nextToken());
                parties[i].add(p);
            }
            // union
            for(int j = 0; j < parties[i].size()-1; j++){
                int a = parties[i].get(j);
                int b = parties[i].get(j+1);
                if(find(a) != find(b)){
                    union(a, b);
                }
            }
        }
        // 연관관계 있는 사람 잡아내기
        boolean[] visited = new boolean[n+1];
        for(int i = 1; i < n+1; i++){
            if(truth[i] && !visited[i]){
                int root = find(i);
                for(int j = 1; j < n+1; j++){
                    if(find(j) == root) {
                        truth[j] = true;
                        visited[j] = true;
                    }
                 }
            }
        }
        // 과장된 이야기 할 수 있는 갯수 count
        int cnt = 0;
        for(int i = 0; i < m; i++){
            boolean check = true;
            for(int j = 0; j < parties[i].size(); j++){
                int p = parties[i].get(j);
                if(truth[p]){
                    check = false;
                    break;
                }
            }
            if(check)
                cnt++;
        }
        System.out.println(cnt);
    }
    // 특정 원소가 속한 집합 찾기
    public static int find(int idx){
        if(parent[idx] == idx)
            return idx;
        return find(parent[idx]);
    }
    // 합치기
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a > b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
    }
}
