import java.util.Iterator;

public class Solution {
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static StringBuilder answer_sb = new StringBuilder();
    /*
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        4-3. ')'를 다시 붙입니다.
        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        4-5. 생성된 문자열을 반환합니다.
     */
    public static void main(String args[]) {
        String s = "(()())()";
        System.out.println(solution(s));
    }

    public static String solution(String p) {
        String answer = dfs(p);
        return answer;
    }

    public static String dfs(String p){
        if(p == null)
            return null;
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        int idx = 0;
        int cnt_left = 0;
        int cnt_right = 0;
        // 2단계 수행 (문자열 u 분리)
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) == '('){
                cnt_left++;
                sb1.append(p.charAt(i));
            }else{
                cnt_right++;
            }
            // 올바른 괄호 문자열이 되었다면
            if(cnt_left == cnt_right){
                idx = i;
                break;
            }
        }
        // 2단계 수행 (문자열 v 분리)
        for(int i = idx; i < p.length(); i++){
            sb2.append(p.charAt(i));
        }
        // 재귀적으로 동작하는 함수 (3,4단계 진행)
        String u = sb1.toString();
        String v = sb2.toString();
        if(checkBalanceString(u)){ // 올바른 괄호 문자열이라면
            String s = dfs(v);
            sb1.append(s);
            return sb1.toString();
        }else{ // 올바른 괄호 문자열이 아니라면
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            String s = dfs(v);
            sb.append(")");
            sb1.deleteCharAt(0);
            sb1.deleteCharAt(u.length()-1);
            // 나머지 문자열의 괄호 방향 뒤집음
            for(int i = 0; i < sb1.length(); i++){
                char c = sb1.toString().charAt(i);
                if(c == '('){
                    sb1.insert(i, ')');
                }else{
                    sb1.insert(i, '(');
                }
            }
            return sb1.toString();
        }
    }

    // 올바른 괄호 문자열 체크
    public static boolean checkBalanceString(String p){
        boolean check = true;
        for(int i = 0; i < p.length() / 2; i++){
            if(p.charAt(i) == p.charAt(p.length() -1 -i)){ // 짝이 안맞으면
                check = false;
                break;
            }
        }
        return check;
    }
}
