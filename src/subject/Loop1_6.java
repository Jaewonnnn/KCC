package subject;

import java.util.Scanner;

class Loop1_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int leng = number;
		for (int i = 0; i < number; i++) {
			int buf = 1;
			for (int j = 0; j < leng; j++) {
				System.out.print(buf++ + " ");
			}
			leng--;
			System.out.println();
		}
	}
}