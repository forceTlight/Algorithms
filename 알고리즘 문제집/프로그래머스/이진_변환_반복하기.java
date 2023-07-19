package 프로그래머스;

/**
 * 이진 변환 반복하기
 * 문제유형 : 이진수, 문져열
 * 난이도 : LEVLE 2
 * 풀이시간 : 8분
 */
class 이진_변환_반복하기 {
    public static void main(String args[]){
        int[] arr = solution("110010101001");
        System.out.print(arr[0] + " " + arr[1]);
    }
    public static int[] solution(String s) {
        int[] answer = new int[2];

        StringBuilder sb = new StringBuilder(s);

        int num = 0;
        int zeroNum = 0;
        while(!sb.toString().equals("1")){
            num++;
            StringBuilder tmpSb = new StringBuilder();
            for(int i = 0; i < sb.toString().length(); i++){
                char c = sb.charAt(i);
                if(c == '1'){
                    tmpSb.append(c);
                }else{
                    zeroNum++;
                }
            }

            // 이진수 변환
            int len = tmpSb.length();
            String binaryNum = Integer.toBinaryString(len);
            sb.setLength(0);
            sb.append(binaryNum);
        }

        answer[0] = num;
        answer[1] = zeroNum;
        return answer;
    }
}