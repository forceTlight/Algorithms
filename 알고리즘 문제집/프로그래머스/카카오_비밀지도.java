package 프로그래머스;

// 비밀지도 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호 해독필요
// 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 공백 또는 벽 두 종류로 이루어져 있다.
// 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
// 만약 지도 1 또는 지도 2중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
// 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
// 지도 1과 지도 2는 각각 정수 배열로 암호화되어 있다.
// 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
class 카카오_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            String map1 = getDecryptMap(arr1[i], n);
            String map2 = getDecryptMap(arr2[i], n);
            
            String realMap = getRealMap(map1, map2);
            answer[i] = realMap ;
        }
        
        return answer;
    }
    
    public String getDecryptMap(int encrypt, int n){
        String binary = Integer.toBinaryString(encrypt);
        StringBuilder sb = new StringBuilder(binary);
        int diff = n - binary.length();
        for(int i = 0; i < diff; i++){
            sb.insert(0, 0);
        }
        
        return sb.toString();
    }
    
    public String getRealMap(String map1, String map2){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < map1.length(); i++){
            if(map1.charAt(i) == '1' || map2.charAt(i) == '1'){
                sb.append("#");
            }else{
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}