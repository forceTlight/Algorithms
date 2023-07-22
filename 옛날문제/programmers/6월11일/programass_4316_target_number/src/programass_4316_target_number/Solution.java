package programass_4316_target_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int target = bf.read();
		String[] input_ = input.split(",");
		int num[] = new int[input_.length];
		for(int i = 0; i < input_.length; i++) {
			num[i] = Integer.parseInt(input_[i]);
			if(num[i] < 1 || num[i] > 50)
				return;
		}
		if(num.length < 1 || num.length > 50)
			return;
		if(target < 1 || target > 1000)
			return;
		int answer = solution(num, target);
	}
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		return answer;
	}
	public static void dfs(int num[], int start, int target) {
		for(int i = 0; )
	}
}
