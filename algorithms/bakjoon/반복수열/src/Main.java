import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int num = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] inputs = input.split(" ");
        int d = Integer.parseInt(inputs[0]);
        int p = Integer.parseInt(inputs[1]);
        ArrayList list = new ArrayList<Integer>();
        dfs(d, p, list);
        System.out.print(num);
    }
    public static void dfs(int d, int p, List<Integer> list){
        if(list.contains(d)){
            num = list.indexOf(d);
            return;
        }
        list.add(d);
        int sum = 0;
        String ds = Integer.toString(d);
        for(int i = 0; i < ds.length(); i++){
            int n = Character.getNumericValue(ds.charAt(i));
            sum += Math.pow(n, p);
        }
        d = sum;
        dfs(d, p, list);
    }
}
