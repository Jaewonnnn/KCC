package kosa.mission;

import java.util.Scanner;

public class Mission03 {
	public static void main(String[] agrs) {
		// 임의의 정수값에 대해서 전체 자리수 중 짝수, 홀수의 개수를 구하자.
		// 5자리수 ex)12345

		int even = 0;
		int odd = 0;
		System.out.print("5자리 숫자 입력 : ");
		Scanner sc = new Scanner(System.in);
		int number = Integer.parseInt(sc.nextLine());

		while (number > 0) {
			if ((isEven(number % 10))) {
				even++;
			} else {
				odd++;
			}
			number /= 10;
		}
		System.out.println("짝수 : " + even + " 홀수 : " + odd);

	}

	public static boolean isEven(int a) {
		if (a % 2 == 0)
			return true;
		return false;
	}
}