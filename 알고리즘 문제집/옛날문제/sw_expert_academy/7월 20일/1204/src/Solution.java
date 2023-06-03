import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(bf.readLine());
		while(c>0) {
			int max_arr = 0;
			int count = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int cnt = st.countTokens();
			int[] arr = new int[101];
			while(cnt>0) {
				int i =Integer.parseInt(st.nextToken());
				arr[i]++;
				cnt--;
			}
			int max = 0;
			for(int i = 0; i < arr.length; i++) {
				if(max <= arr[i]) {
					max = arr[i];
					max_arr = i;
				}
			}
			System.out.println("#"+count +" " +max_arr);
			c--;
		}
	}
}
