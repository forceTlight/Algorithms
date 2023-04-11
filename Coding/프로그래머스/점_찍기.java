package 프로그래머스;

public class 점_찍기 {
    public long solution(int k, long d) {
        long answer = 0;

        for(long i = 0; i <= d; i+=k){
            double diff = Math.floor(Math.sqrt(d*d - i*i));
            answer += diff / k + 1;
        }

        return answer;
    }
}