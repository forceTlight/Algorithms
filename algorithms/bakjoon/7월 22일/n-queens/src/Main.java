import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		int board[][] = new int[n][n];
	}

	public static void queens(int board[][], int queen) {
		if (queen == n)
			return;
		for (int i = 0+queen; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 1;
				if (promising(board, queen)) {
					queens(board, queen + 1);
				}else {
					board[i][j] = 0;
				}
			}
		}
	}

	public static boolean promising(int board[][], int q) {
		boolean check = true;
		while(check) {
			int i, j;
			
		}
		return check;
	}
}
