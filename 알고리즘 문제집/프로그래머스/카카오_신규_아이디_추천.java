package 프로그래머스;
// output: 추천 아이디

// input: 신규 유저가 입력한 아이디
// input-size: 1 <= new_id <= 1000

// 문제 설명
// 카카오 아이디 규칙
// 1. 아이디의 길이는 3자 이상 15자 이하
// 2. 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있다.
// 3. 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없다.
// 7단계 규칙 존재

class 카카오_신규_아이디_추천 {
    public String solution(String new_id) {
        // 1단계
        String lowerId = new_id.toLowerCase();
        
        // 2단계
        StringBuilder sb = new StringBuilder();
        
        char prevChar = '0';
        for(int i = 0; i < lowerId.length(); i++){
            char c = lowerId.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' | c =='.'){
                if(prevChar == '.' && c == '.') // 3단계
                    continue;
                
                sb.append(c);
                prevChar = c;
            }
        }
                
        // 4단계
        while(sb.length() > 0 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
                        
        // 빈 문자열인지 검사
        if(sb.length() == 0)
            sb.append("a");
        
        // 6단계
        if(sb.length() >= 16){
            sb.delete(15, sb.length());
        }
        
        // 6단계-1 끝에 (.)가 위치하면 삭제
        if(sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);
        
        // 7단계
        while(sb.length() > 0 && sb.length() <= 2){
            sb.append(sb.charAt(sb.length() - 1));
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}