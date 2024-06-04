package kosa.api;

import java.util.Scanner;

public class Mission02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String arr[] = sc.nextLine().split(" ");

		System.out.println(solution(arr));
	}
	public static String solution(String[] arr) {
		String answer = "";
		for(int i = 0; i < arr.length;i++) {
			if(answer.length() < arr[i].length()) {
				answer = arr[i];
			}
		}
		return answer;
	}
}