import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws IOException {
		
	}
	public int solution(String word) {
        int answer = 0;
        return answer;
    }
	public void process(int digit, int idx[]) {
		if(idx.length == digit) {
			idx = new int[digit+1];
			process(digit+1, idx);
		}
		if(idx[0] == 4 && idx[idx.length] == 4) {
			
		}
		if(idx[idx.length] == 4) {
			for(int i = idx.length-1; i >= 0; i--) {
				if(idx[i] < 4) {
					idx[i]
				}
					process(digit, idx);
			}
		}
	}
}
