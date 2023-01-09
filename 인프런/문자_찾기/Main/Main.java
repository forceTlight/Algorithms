import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String args[]) throws IOException {
        ArrayList<Integer> answers = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int m = Integer.parseInt(br.readLine());
        int[] mArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int p1 = 0, p2 = 0;

        while(p1 < n && p2 < m){
            if(nArr[p1] >= mArr[p2]){
                answers.add(mArr[p2++]);
            }else{
                answers.add(nArr[p1++]);
            }
        }

        while(p1 < n)
            answers.add(nArr[p1++]);

        while(p2 < m)
            answers.add(mArr[p2++]);

        answers.forEach(num -> System.out.print(num + " "));
    }
}