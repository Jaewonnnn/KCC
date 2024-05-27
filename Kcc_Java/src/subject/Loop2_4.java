package subject;

import java.util.Scanner;

public class Loop2_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			int buf = number - (i + 1);
			for (int k = 0; k < buf; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i+(i+1); j++) {
				System.out.print("*");
			}
			for(int k = 0; k < buf; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
