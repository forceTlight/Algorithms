package fuction_develop;

import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) {
		int progresses[] = { 93, 30, 55, 60, 40, 65 };
		int speeds[] = {1, 30, 5 , 10, 60, 7};
		int answer[] = solution(progresses, speeds);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> speed = new ArrayList<Integer>();
		
		for (int i = 0; i < progresses.length; i++) {
			array.add(progresses[i]);
			speed.add(speeds[i]);
		}
		for (int i = 0; i < progresses.length; i++)
			progresses[i] = array.get(i);
		// process
		while (!array.isEmpty()) {
			int size = array.size();
			while (array.get(0) < 100) {
				for (int i = 0; i < size; i++)
					array.set(i, array.get(i) + speed.get(i));
			}
			// arrayList 초기화 후 다시 배열 삽입

			// 100 넘는지 체크
			int count = 0;
			for (int i = 0; i < size; i++) {
				if (array.get(i) >= 100) {
					for (int j = i + 1; j < size; j++) {
						array.set(j, array.get(j));
						speed.set(j, speed.get(j));
					}
					array.remove(0);
					speed.remove(0);
					size = array.size();
					count++;
					i = -1;
				} else {
					break;
				}
			}
			if (count > 0)
				cnt.add(count);
		}
		// answer에 값 저장
		int[] answer = new int[cnt.size()];
		for (int i = 0; i < cnt.size(); i++) {
			answer[i] = cnt.get(i);
		}
		return answer;
	}
}
