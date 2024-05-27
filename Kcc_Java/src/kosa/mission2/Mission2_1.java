package kosa.mission2;

import java.util.Scanner;

public class Mission2_1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int leng = Integer.parseInt(sc.nextLine());
		String[] numbers = sc.nextLine().split(" ");

		System.out.print(numbers[0] + " ");
		for (int i = 1; i < leng; i++) {
			if (Integer.parseInt(numbers[i]) > Integer.parseInt(numbers[i - 1])) {
				System.out.print(numbers[i] + " ");
			}
		}
		// System.arraycopy(원본배열, 몇번째부터, 복사배열, 몇번째부터, 길이);
	}
}
