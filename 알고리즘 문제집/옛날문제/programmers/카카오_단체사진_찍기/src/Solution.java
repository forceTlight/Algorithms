class Solution {
    static char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visit;
    static int[] ch;
    static int answer = 0;
    static int n;
    static String[] data;
    public static void main(String args[]){
        String[] data = {"N~F=0", "R~T>2"};
        solution(2, data);
        System.out.println(answer);
        data = new String[]{"M~C<2", "C~M>1", "R~T>2"};
        solution(3, data);
        System.out.println(answer);
    }
    static int solution(int n_, String[] data_) {
        n = n_;
        data = data_;
        answer = 0;
        visit = new boolean[8];
        ch = new int[8];
        dfs(0);
        return answer;
    }

    // 첫번째 조합 (6자리 뽑기)
    static void dfs(int idx) {
        if (idx == 8) {
            for(int i = 0; i < n; i++){
                if (!check(data[i])){
                    return;
                }
            }
            answer++;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ch[idx] = i;
                dfs(idx + 1);
                visit[i] = false;
            }
        }
    }

    static boolean check(String data) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 8; i++)
            sb.append(arr[ch[i]]);
        int c1_num = 0;
        int c2_num = 0;
            char c1 = data.charAt(0);
            char c2 = data.charAt(2);
            char sign = data.charAt(3);
            int n = Character.getNumericValue(data.charAt(4));
            for (int j = 0; j < 8; j++) {
                if (c1 == sb.toString().charAt(j)) {
                    c1_num = j;
                } else if (c2 == sb.toString().charAt(j)) {
                    c2_num = j;
                }
            }
            int cal = Math.abs(c1_num - c2_num) - 1;
            switch (sign) {
                case '=':
                    if (cal == n)
                        return true;
                    break;
                case '>':
                    if (cal > n)
                        return true;
                    break;
                case '<':
                    if (cal < n)
                        return true;
                    break;
            }
            return false;
    }
}