package 프로그래머스;

// 1. n을 k진수로 바꾸고 2의 조건에 맞는 소수가 몇 개인지 찾아야 함
// 2. 0P0, P0, 0P, P / P는 0을 포함하지 않는 소수

class k진수에서_소수_개수_구하기 {
    public int solution(int n, int k) {
        int answer = 0;
        
        // 양의 정수 n을 k 진수로 바꾸기
        // n이 0이 아닐 떄 까지 계속해서 k로 나누고, 나머지를 더해주는 형식으로 가야 함
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0){
            sb.insert(0, n % k);
            n /= k;
        }
        
        String digit = sb.toString();
        sb.setLength(0);
                        
        for(int i = 0; i < digit.length(); i++){
            char c = digit.charAt(i);
            if(c == '0' && sb.length() > 0){                
                long num = Long.parseLong(sb.toString());
                if(isPrime(num))
                    answer++;
                
                // 초기화
                sb.setLength(0);
            }else{
                sb.append(c);
            }
        }
        
        if(sb.length() > 0){
            long num = Long.parseLong(sb.toString());
            if(isPrime(num))
                answer++;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n){
        if(n <= 1)
            return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        
        return true;
    }
}