package subject;

import java.util.Scanner;

class Loop2_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int buf = number - 1;
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				if (j < buf) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			buf--;
			System.out.println();
		}
	}
}