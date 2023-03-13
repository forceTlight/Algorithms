package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Country {
    int x, y;
    int value;

    public Country(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
}

public class _16234_인구_이동 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Country> guildQueue = new LinkedList<>();
        Queue<Country> queue = new LinkedList<>();

        int cnt = 0;

        while (true) {
            boolean isVisited = false;
            boolean visited[][] = new boolean[n][n];
            for (int k = 0; k < n; k++) {
                for (int m = 0; m < n; m++) {
                    guildQueue.clear();
                    if (!visited[k][m]) {
                        Country country = new Country(k, m, arr[k][m]);
                        queue.add(country);
                        guildQueue.add(country);
                        visited[k][m] = true;
                    }

                    while (!queue.isEmpty()) {
                        Country country = queue.poll();

                        int x = country.getX();
                        int y = country.getY();
                        int value = country.getValue();
                        for (int j = 0; j < 4; j++) {
                            int a = x + dx[j];
                            int b = y + dy[j];

                            if (a >= 0 && a < n && b >= 0 && b < n && !visited[a][b]) {
                                int diff = Math.abs(arr[a][b] - value);
                                if (diff >= l && diff <= r) {
                                    visited[a][b] = true;
                                    queue.add(new Country(a, b, arr[a][b]));
                                    guildQueue.add(new Country(a, b, arr[a][b]));
                                    isVisited = true;
                                }
                            }
                        }
                    }
                    if (!guildQueue.isEmpty() && guildQueue.size() != 1) {
                        // 인구이동 정보 업데이트
                        int people = guildQueue.stream().mapToInt(Country::getValue).sum() / guildQueue.size();
                        while (!guildQueue.isEmpty()) {
                            Country country = guildQueue.poll();
                            int x = country.getX();
                            int y = country.getY();

                            arr[x][y] = people;
                        }
                    }
                }
                }
            if (!isVisited)
                break;

            cnt++;
        }

        System.out.println(cnt);
    }
}