import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int j = 0; j < m; j++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        if(crane.get(0) < box.get(0)){
            System.out.println("-1");
        }else{
            int time = 0;
            while(!box.isEmpty()){
                int idx = 0;
                for(int i = 0; i < crane.size();){
                    if(idx == box.size())
                        break;
                    else if(crane.get(i) >= box.get(idx)){
                        box.remove(idx);
                        i++;
                    }else{
                        idx++;
                    }
                }
                time++;
            }
            System.out.println(time);
        }
    }
}
