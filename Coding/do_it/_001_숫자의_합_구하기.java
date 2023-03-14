package do_it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _001_숫자의_합_구하기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int sum = 0;
        for(char c: input.toCharArray())
            sum += Character.getNumericValue(c);

        System.out.println(sum);
    }
}