import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String args[]) throws IOException {
        ArrayList<Long> answers = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] nArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        int m = Integer.parseInt(br.readLine());
        long[] mArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(nArr);
        Arrays.sort(mArr);

        int np = 0, mp = 0;

        while(np < n && mp < m){
            if(nArr[np] > mArr[mp]){
                mp++;
            }else if(nArr[np] < mArr[mp]){
                np++;
            }else{
                answers.add(nArr[np++]);
            }
        }

        answers.forEach(a -> System.out.print(a + " "));
    }
}