import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int l;
    static ArrayList<Integer> rest;
    static int max = Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        rest = new ArrayList<>();
        rest.add(0); // min
        rest.add(l); // max
        for(int i = 0; st.hasMoreTokens(); i++){
            rest.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(rest);
        binarySearch(1, l);
    }
    public static void binarySearch(int low, int high){
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(isPromising(mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(low);
    }
    public static boolean isPromising(int key){
        int cnt = 0;
        for(int i = 0; i < rest.size()-1; i++){
            cnt += (rest.get(i+1) - rest.get(i) - 1) / key;
        }
        if(cnt > m)
            return true;
        return false;
    }
}
