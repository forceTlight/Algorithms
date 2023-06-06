package 프로그래머스;

class n_n_배열_자르기 {  
    public int[] solution(int n, long left, long right) {        
        int length = (int) (right - left);
        int[] arr = new int[length + 1];
        
        int idx = 0;
        for(long i = left; i <= right; i++){
            int a = (int)(i / n); // 몫
            int b = (int)(i % n); // 나머지
            
            int num = 0;
            if(a >= b){
                num = a + 1;
            }else{
                num = b + 1;
            }
                        
            arr[idx++] = num;
        }
        
        return arr;
    }
}
    
  
