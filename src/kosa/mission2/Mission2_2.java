package kosa.mission2;

import java.util.Scanner;

public class Mission2_2 {

	public static int solution(String[] numbers) {
		int count = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			int num = Integer.parseInt(numbers[i]);
			if (max < num) {
				count++;
				max = num;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int leng = Integer.parseInt(sc.nextLine());
		String[] numbers = sc.nextLine().split(" ");

		System.out.println(solution(numbers));
	}
}