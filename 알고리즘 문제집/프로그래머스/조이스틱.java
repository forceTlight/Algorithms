package 프로그래머스;

/**
 * 조이스틱
 * 문제유형 : DFS
 * 난이도 : LEVEL 2
 * 풀이시간 : 2시간
 */
class 조이스틱 {
    static boolean[] visited;
    static int distanceCnt = Integer.MAX_VALUE;

    public static void main(String args[]){
        System.out.println(solution("AAAA"));
    }
    public static int solution(String name) {
        int answer = 0;
        visited = new boolean[name.length()];
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(c == 'A')
                visited[i] = true;
        }

        // 모두 A인지 확인
        boolean check = true;
        for(boolean v : visited){
            if(!v)
                check = false;
        }

        if(check){
            return 0;
        }

        // 최적의 거리 구하기
        dfs(name, 0, 0);
        answer = distanceCnt;

        // 알파벳 카운트
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            if(c != 'A'){
                if(c - 'A' >= 13){
                    answer += 'Z' - c + 1;
                }else{
                    answer += c - 'A';
                }
            }
        }

        return answer;
    }

    public static void dfs(String word, int idx, int cnt){
        if(cnt > word.length())
            return;

        if(idx < 0){
            dfs(word, word.length() - 1, cnt);
            return;
        }

        if(idx == word.length()){
            dfs(word, 0, cnt);
            return;
        }

        // 모두 방문했는지 확인
        boolean check = true;
        for(boolean b : visited)
            if(!b)
                check = false;

        if(check){
            distanceCnt = Math.min(distanceCnt, cnt - 1);
            return;
        }

        if(!visited[idx]){
            visited[idx] = true;
            dfs(word, idx - 1, cnt + 1);
            dfs(word, idx + 1, cnt + 1);
            visited[idx] = false;
        }else{
            dfs(word, idx - 1, cnt + 1);
            dfs(word, idx + 1, cnt + 1);
        }
    }
}