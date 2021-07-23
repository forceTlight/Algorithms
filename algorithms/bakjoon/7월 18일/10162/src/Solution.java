import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int a = 300, b = 60, c = 10;
		int a_count = 0, b_count = 0, c_count = 0;
		while(true) {
			if(t/a >= 1) {
				a_count++;
				t -= a;
				continue;
			}else if(t/b >= 1) {
				b_count++;
				t -= b;
				continue;
			}else if(t/c >= 1) {
				c_count++;
				t -= c;
				continue;
			}
			if(t == 0) {
				System.out.print(a_count +" " + b_count +" " + c_count);
				break;
			}else {
				System.out.println("-1");
				break;
			}
		}
	}
}