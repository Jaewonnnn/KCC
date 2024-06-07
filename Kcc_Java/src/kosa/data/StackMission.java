package kosa.data;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class StackMission {

	public static void main(String[] args) throws IOException {
		// 키보드로부터 수식을 입력
		// ex) ((2+3)+10) =? 괄호일치, 불일치 판단

		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.size() == 0) {
					System.out.println("불일치");
					return;
				}
				stack.pop();
			}
		}
		System.out.println("일치");
	}
}