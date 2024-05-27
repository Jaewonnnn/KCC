package kosa.mission;

import java.util.Scanner;

public class Mission2_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int arr[][] = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int buf1 = 0;
		int buf2 = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			buf1 = 0;
			buf2 = 0;
			for (int j = 0; j < arr[i].length; j++) {
				buf1 += arr[i][j];
				buf2 += arr[j][i];
			}
			max = Integer.max(Integer.max(max, buf1), buf2);
		}

		buf1 = 0;
		buf2 = 0;

		for (int i = 0; i < arr.length; i++) {
			buf1 += arr[i][i];
			buf2 += arr[i][arr.length - i - 1];
		}
		max = Integer.max(Integer.max(max, buf1), buf2);

		System.out.println(max);
	}
}
