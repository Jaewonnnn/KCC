package subject;

import java.util.Scanner;

class Loop1_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int buf = 1;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(buf++ + " ");
			}
			System.out.println();
		}
	}
}