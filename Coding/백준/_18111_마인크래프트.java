package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;

class Block implements Comparable<Block> {
    private int i;
    private int j;
    private int height;

    public Block(int i, int j, int height) {
        this.i = i;
        this.j = j;
        this.height = height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Block o) {
        return this.height <= o.height ? 1 : -1;
    }
}
/**
 * 테스트 케이스는 맞으나, 시간 복잡도에서 통과를 못해 다시한번 봐야함
 */
public class _18111_마인크래프트 {
    static int n;
    static int m;
    static PriorityQueue<Block> queue;
    static int time = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new PriorityQueue<>();

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int[][] arr = new int[n][m];

        int b = Integer.parseInt(input[2]);

        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                minHeight = Math.min(minHeight, arr[i][j]);

                queue.add(new Block(i, j, arr[i][j]));
            }
        }

        // 위에서 부터 땅 파기, 블록 갯수 충족하면 스탑
        while (!queue.isEmpty()) {
            // 남은 블록 및 땅 파야하는 횟수 구하기
            int blockCnt = 0, digCnt = 0;
            if (queue.peek().getHeight() != maxHeight) {
                maxHeight = queue.peek().getHeight();

                Iterator<Block> iter = queue.iterator();
                while (iter.hasNext()) {
                    Block ib = iter.next();
                    blockCnt += maxHeight - ib.getHeight();
                    digCnt += ib.getHeight() - minHeight;
                }

                if (blockCnt <= digCnt && b >= blockCnt) {
                    time += blockCnt;
                    break;
                }
            }

            Block block = queue.poll();
            maxHeight = block.getHeight();

            if (maxHeight == minHeight || maxHeight == 0)
                break;

            time += 2;
            b++;

            block.setHeight(block.getHeight() - 1);
            queue.add(block);
        }

        System.out.println(time + " " + maxHeight);
    }
}
