import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer substition = new StringTokenizer(br.readLine(), "-");
        int sum = Integer.MAX_VALUE;
        while(substition.hasMoreTokens()){
            int tmp = 0;
            StringTokenizer addition = new StringTokenizer(substition.nextToken(), "+");
            while(addition.hasMoreTokens()){
                tmp += Integer.parseInt(addition.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            }else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
