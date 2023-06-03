import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder tmpSb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                String result = tmpSb.reverse().toString();
                sb.append(result);
                tmpSb.setLength(0);
                for (int j = i; ; j++) {
                    sb.append(input.charAt(j));
                    if(input.charAt(j) == '>'){
                        i = j;
                        break;
                    }
                }
                continue;
            } else if (input.charAt(i) == ' ') {
                String result = tmpSb.reverse().toString();
                sb.append(result + ' ');
                tmpSb.setLength(0);
                continue;
            } else if (i == input.length() - 1) {
                tmpSb.append(input.charAt(i));
                String result = tmpSb.reverse().toString();
                sb.append(result);
                break;
            }
            tmpSb.append(input.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
