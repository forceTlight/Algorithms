import java.util.Scanner;

public class Example {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.nextLine();
		String num2 = sc.nextLine();
		
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		System.out.println(sum);
		
	}
}

