import java.util.Scanner;

public class _2231 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int min, max = 0;
		int tmp;
		int tmp1, tmp2 = 0;
		int answer = 0; // �� ����
		int sum = 0; // �� �ڸ��� ���
		int count = 0;
		int cnt = 1;
		boolean check = true;
		int r; // �Է°����� ���� �� �������� �� ����
		if (n < 1 || n > 1000000)
			return;
		r = n - (n % 10);
		int j = 0;
		//�ڸ� �� ���
		tmp1 = n;
		while (tmp1 != 0) {
			tmp1 /= 10;
			count++;
		}
		// process
		while (check) {
			tmp2 = r - j;
			tmp1 = tmp2;
			sum = 0;
			while (tmp1 != 0) {
				sum += (tmp1 % 10);
				tmp1 /= 10;
			}
			min = tmp2 + sum;
			max = tmp2 + sum + (2 * 9);
			if (n >= min && n <= max) {
				for (int i = 0; i <= 9; i++) {
					tmp = tmp2 + sum + (2 * i);
					if (tmp == n) {
						answer = tmp2 + i;
						break;
					}
				}
			} else {
				if(cnt < count) {
					j = j + 10;
					cnt++;
					continue;
				}
				check = false;
			}
			j = j + 10;
			cnt++;
		}
		if(answer <= 0)
			answer = 0;
		System.out.println(answer);
	}
}
