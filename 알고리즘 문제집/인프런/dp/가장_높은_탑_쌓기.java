package 인프런.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 가장_높은_탑_쌓기 {
    static class Brick implements Comparable<Brick>{
        int width;
        int height;
        int weight;

        public Brick(int width, int height, int weight){
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick b){
            return b.width - this.width;
        }
    }

    static int[] dp;
    static ArrayList<Brick> bricks;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        bricks = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bricks.add(new Brick(width, height, weight));
        }

        Collections.sort(bricks);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int value = getValue(i);
            dp[i+1] = value;

            max = Math.max(max, value);
        }

        System.out.println(max);
    }

    public static int getValue(int idx){
        Brick brick = bricks.get(idx);

        int max = 0;
        for(int i = 0; i <= idx; i++){
            if(bricks.get(i).weight >= brick.weight){
                max = Math.max(max, dp[i + 1]);
            }
        }

        return max + brick.height;
    }
}