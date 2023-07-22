import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int max_cnt = 0;
    static char[] candy = {'C', 'P', 'Z', 'Y'};

    public static void main(String args[]) throws IOException {
        char[][] board;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            String input = bf.readLine();
            for (int j = 0; j < input.length(); j++) {
                board[i][j] = input.charAt(j);
            }
        }
        // 첫 탐색
        // 스왑, 탐색
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size - 1; k++) {
                // 가로
                swap(board, i, k, i, k + 1);
                // 세로
                swap(board, k, i, k + 1, i);
            }
        }
        System.out.println(max_cnt+1);
    }

    public static void swap(char[][] board, int a1, int b1, int a2, int b2) {
        char tmp1 = board[a1][b1];
        char tmp2 = board[a2][b2];
        board[a1][b1] = tmp2;
        board[a2][b2] = tmp1;
        search(board);
        // 원위치
        board[a1][b1] = tmp1;
        board[a2][b2] = tmp2;
    }

    // 가로, 세로 탐색
    public static void search(char[][] board) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size = board.length;
        int row_cnt = 0;
        int column_cnt = 0;
        for (int j = 0; j < candy.length; j++) {
            for (int i = 0; i < size; i++) {
                row_cnt = 0;
                column_cnt = 0;
                for (int k = 0; k < size-1; k++) {
                    // 가로 탐색
                    if (board[i][k] == board[i][k+1] && board[i][k] == candy[j]) {
                        row_cnt++;
                    }else{
                        if (max_cnt < row_cnt) {
                            max_cnt = row_cnt;
                        }
                        row_cnt = 0;
                    }
                    // 세로 탐색
                    if (board[k][i] == board[k+1][i] && board[k][i] == candy[j]) {
                        column_cnt++;
                    }else{
                        if (max_cnt < column_cnt) {
                            max_cnt = column_cnt;
                        }
                        column_cnt = 0;
                    }
                }
                if (max_cnt < row_cnt) {
                    max_cnt = row_cnt;
                }
                if (max_cnt < column_cnt) {
                    max_cnt = column_cnt;
                }
            }
        }
    }
}
