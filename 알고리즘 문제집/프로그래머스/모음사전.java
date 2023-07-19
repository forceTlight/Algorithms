package 프로그래머스;

/**
 * 모음사전
 * 문제유형 : 완전 탐색
 * 난이도 : LEVLE 2
 * 풀이시간 : 15분
 */
class 모음사전 {
    static char[] arr;
    static int cnt = 0;
    static boolean check = false;
    static int answer = 0;
    
    public int solution(String word) {        
        arr = new char[5];
        arr[0] = 'A';
        arr[1] = 'E';
        arr[2] = 'I';
        arr[3] = 'O';
        arr[4] = 'U';
        
        dfs(0, word, new StringBuilder());
        
        return answer;
    }
    
    public void dfs(int depth, String word, StringBuilder sb){
        if(check)
            return;
        
        if(depth == 5){
            return;
        }
        
        for(int i = 0; i < 5; i++){
            sb.append(arr[i]);
            cnt++;
            if(sb.toString().equals(word)){
                answer = cnt;
                check = true;
            }
            
            dfs(depth+1, word, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}