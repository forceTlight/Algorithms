import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int ans;
    static int start, end;
    static ArrayList<City>[] cities;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cities = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            cities[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cities[a].add(new City(b, w));
            cities[b].add(new City(a, w));
            max = Math.max(max, w);
        }
        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // Binary Search
        int low = 0;
        int high = max;
        int mid;
        while(low <= high){
            mid = (low + high) / 2;
            ans = -1;
            dfs(start, new boolean[n+1], mid);
            if(ans != -1){ // 이동이 가능하면 중량 올리기
                low = mid + 1;
            }else{ // 불가능 하면 중량 줄이기
                high = mid - 1;
            }
        }
        System.out.println(high);
    }
    public static void dfs(int idx, boolean visited[], int weight){
        if(idx == end){
            ans = idx;
            return;
        }
        for(City c: cities[idx]){
            idx = c.to;
            if(!visited[idx] && weight <= c.weight){
                visited[idx] = true;
                dfs(idx, visited, weight);
            }
        }
    }
}
class City{
    int to;
    int weight;
    City(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}
