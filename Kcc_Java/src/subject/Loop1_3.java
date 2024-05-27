package subject;

import java.util.Scanner;

public class Loop1_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int result = 1;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				System.out.print(result + " ");
				result += 2;
			}
			System.out.println();
		}
	}

}
