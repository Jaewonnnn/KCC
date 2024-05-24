package kosa.mission;

import java.util.Scanner;

public class Mission04 {
	public static void main(String[] agrs) {
		// 문자열 비교
		String a = "abc";
		String b = "abc";
		// String타입을 리터럴로 초기화 시 같은 문자열이 있으면 같은 주소를 참조
//		if (a == b) {
//			System.out.println("같다");
//		}else {
//			System.out.println("다르다");
//		}
		if(a.equals(b)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		// 두 정수와 연산자 문자열을 입력받아
		// 사칙연산 결과를 출력하시오(계산기)
		// ex) 정수 1 : 10
		//     정수2 : 20
		//     연산자 : +
		// 결과 : 30
		int result = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 1: ");
		int first = Integer.parseInt(sc.nextLine());
		System.out.println("정수 2: ");
		int second = Integer.parseInt(sc.nextLine());
		System.out.println("연산자 : ");
		char c = sc.nextLine().charAt(0);
		
//		if(c == '+') {
//			System.out.println(first + second);
//		}
//		else if(c == '-') {
//			System.out.println(first - second);
//		}
//		else if(c == '*') {
//			System.out.println(first * second);
//		}
//		else if(c == '/') {
//			System.out.println((double)first / second);
//		}
		switch(c) {
		case '+':
			System.out.println(first + second);
			break;
		case '-':
			System.out.println(first - second);
			break;
		case '*':
			System.out.println(first * second);
			break;
		case '/':
			System.out.println((double)first / second);
			break;
		}
	}
}
