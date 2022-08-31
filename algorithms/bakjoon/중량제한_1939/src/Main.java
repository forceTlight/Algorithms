import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<City>[] cities = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            cities[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a =
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
