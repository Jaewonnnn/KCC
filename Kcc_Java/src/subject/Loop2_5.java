package subject;

import java.util.Scanner;

public class Loop2_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		for (int i = 0; i < number * 2; i++) {
			int buf = number - (i + 1);
			if (i < number) {
				for (int j = 0; j < buf; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < i + (i + 1); j++) {
					System.out.print("*");
				}
				for (int j = 0; j < buf; j++) {
					System.out.print(" ");
				}
			}else {
				int buf2 = 0;
				for(int j = i - number; j >= 0; j--) {
					System.out.print(" ");
					buf2++;
				}
				for (int j = 0 ; j < i - (i + 1); j++) {
					System.out.print("*");
				}
				for (int j = i - number; j >= 0; j--) {
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}

	}

}
