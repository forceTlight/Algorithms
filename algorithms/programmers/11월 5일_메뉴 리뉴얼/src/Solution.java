import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @Author - Hyeong-Jun Kim
 * @level - programmers_level_2
 * @name - 2021 KAKAO BLIND - �޴� ������
 **/

public class Solution {
	static TreeMap<String, Integer> map = new TreeMap<>();
	static ArrayList<String> list = new ArrayList<String>();
	/*
	public static void main(String[] args) {
		solution(new String[] { "XYZ", "XWY", "WXA" }, new int[] { 2, 3, 5 });

	}*/
	public static String[] solution(String[] orders, int[] course) {
		String[] ansewer = {};
		for (int i = 0; i < course.length; i++) {
			int size = course[i];
			for (int j = 0; j < orders.length; j++) {
				String order = orders[j];
				int orderSize = order.length();
				boolean visited[] = new boolean[orderSize];
				combination(order, visited, 0, orderSize, size);
			}
		}
		process(course);
		// ����� ArrayList ����
		Collections.sort(list);
		return list.toArray(new String[list.size()]);
		/*Iterator iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());*/
	}

	// ���ڿ� course ������ŭ ���� ���ϱ�
	static void combination(String order, boolean visited[], int depth, int n, int r) {
		if (r == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == true) {
					sb.append(order.charAt(i));
				}
			}
			// ���ڿ� ����
			char[] chr = sb.toString().toCharArray();
			Arrays.sort(chr);
			String str = new String(chr);
			// hashMap�� count ����
			if (map.containsKey(str)) {
				int cnt = map.get(str);
				map.put(str, cnt + 1);
			} else {
				map.put(str, 1);
			}
			return;
		}
		if (depth == n) {
			return;
		}
		// Ž��
		visited[depth] = true;
		combination(order, visited, depth + 1, n, r - 1);

		visited[depth] = false;
		combination(order, visited, depth + 1, n, r);
	}

	// ���̺��� ī��Ʈ���� ����� ����
	static void process(int[] course) {
		ArrayList<String> array = new ArrayList<String>();
		for (int i = 0; i < course.length; i++) {
			int max = 0;
			array.clear();
			// max �� ã��
			for (String s : map.keySet()) {
				int count = course[i];
				if(s.length() == count && map.get(s) >= 2) {
					array.add(s);
					if(max < map.get(s))
						max = map.get(s);
				}
			}
			// course_map�� �ֱ�
			for(int j = 0; j < array.size(); j++) {
				if(map.get(array.get(j)) == max) {
					list.add(array.get(j));
				}
			}
		}
	}
}
