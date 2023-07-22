package blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2798 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		int N, M;
		int tmp;
		int min = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputs[] = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		// ����
		if(N<3 || N > 100 || M < 10 || M > 300000)
			return;
		int c[] = new int[N];
		String inputs2[] = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(inputs2[i]);
		}
		for(int k = 0; k < N-2; k++)
			for(int j = k+1; j < N-1; j++)
				for(int i = j+1; i < N; i++) {
					tmp = c[k] + c[j] + c[i];
					if(tmp > M)
						continue;
					if(Math.abs(M-min) > Math.abs(M-tmp))
						min = tmp;				
					}
		System.out.println(min);
	}
}
