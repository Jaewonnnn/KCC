package kosa.api;

import java.util.Scanner;

public class Mission01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().toLowerCase();
		char c = Character.toLowerCase(sc.nextLine().charAt(0));
		System.out.println(solution(s,c));
	}
	public static int solution(String s, char c) {
		int count = 0;
//		for(int i = 0; i < s.length(); i++) {
//			if(s.charAt(i) == c) {
//				count++;
//			}
//		}
		for(char x : s.toCharArray()) {
			if(x == c) count++;
		}
		return count;
	}
}