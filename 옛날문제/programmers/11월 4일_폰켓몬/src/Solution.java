import java.util.ArrayList;
/**
 * 
 * @author Neo
 * 프로그래머스 Level1 - 폰켓몬
 */
public class Solution {
	public static void main(String args[]) {
		System.out.println(solution(new int[]{3,3,3,2,2,4}));
	}
	public static int solution(int[] nums) {
        int answer = 0;
        
        int size = nums.length;
        ArrayList<Integer> num = new ArrayList<>();
        num.add(nums[0]);
        for(int i = 1; i < size; i++) {
        	if(i == size-1) {
        		if(!num.contains(nums[i]))
        			num.add(nums[i]);
        	}
        	if(nums[i] != nums[i+1] && !num.contains(nums[i])) {
        		num.add(nums[i]);
        	}
        }
        /*for(int i = 1; i < size; i++) {
        	for(int j = i; j >= 0; j--) {
        		if(nums[i] != nums[j] && !num.contains(nums[i])) {
        			num.add(nums[i]);
        		}
        	}
        }*/
        // 결과 값 처리
        int choice = size/2;
        if(num.size() >= choice) {
        	answer = choice;
        }else {
        	answer = num.size() + 1;
        }
        return answer;
    }
}
