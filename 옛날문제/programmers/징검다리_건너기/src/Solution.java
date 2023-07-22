public class Solution {
    public static void main(String args[]){
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3));
    }
    public static int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0; int right = 200000000;
        int mid;
        while(left <= right){
            mid = (left + right) / 2;
            if(isPromising(stones, k, mid)){
                left = mid + 1;
                answer = Math.max(mid, answer);
            }else{
                right = mid - 1;
            }
        }
        return answer;
    }
    public static boolean isPromising(int[] stones, int k, int mid){
        int cnt = 0;
        for(int stone: stones){
            if(stone - mid < 0){
                cnt++;
            }else{
                cnt = 0;
            }
            if(cnt == k)
                return false;
        }
        return true;
    }

}
