package 백준;

import java.io.*;
import java.util.StringTokenizer;

class _1002_터렛 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if(x1 == x2 && y1 == y2 && r1 == r2){
                bw.write("-1\n");
                continue;
            }

            int cnt = 0;
            // 두 원 사이의 거리 구하기
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 2, 1, 0 3가지 경우의 수 나옴
            int diff = Math.abs(r1 - r2);
            int plus = r1 + r2;

            if(diff < distance && distance < plus){
                bw.write("2\n");
            }else if(diff > distance || plus < distance || distance == 0){
                bw.write("0\n");
            }else{
                bw.write("1\n");
            }
        }

        bw.flush();
    }
}