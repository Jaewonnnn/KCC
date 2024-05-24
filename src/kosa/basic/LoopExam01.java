package kosa.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class LoopExam01 {

	public static void main(String[] args) {
		// while : 초기식 -> 조건식 -> 명령문 -> 증감식 : 수직방향
		// 1~10까지 합
//		int sum = 0;
//		int i = 1;
//		while(i <= 10) {
//			sum += i;
//			i++;
//		}
//		System.out.println("1~10까지 합 : " + sum);

		// 구구단 7단 출력
		// 7 * 1 = 7
		// 7 * 2 = 14
//		int i = 1;
//		while (i <= 9) {
//			System.out.println("7 * " + i + " = " + (7*i));
//			i++;
//		}

		// for문 : 초기식 -> 조건식 -> 명령문 -> 증감식 : 수평 방향
//		int sum = 0;
//		for(int i = 1; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println("1~10까지 합 : " + sum);

		// 1 ~ 100까지 2의 배수와 3의 배수가 아닌 것만 숫자만 출력하시오
//		for (int i = 1; i <= 100; i++) { // not 연산자 사용
//			if (!(i % 2 == 0) && !(i % 3 == 0)) {
//				System.out.print(i + ", ");
//			}
//		}

//		for (int i = 0; i <= 100; i++) { // continue 사용
//			if (i % 2 == 0 || i % 3 == 0) {
//				continue;
//			}
//			System.out.print(i + ", ");
//		}

		// do while : 적어도 1번 실행하기 위함
		// Validation check
		// 키보드로 부터 숫자를 입력받기
		// 음수를 입력하면 새로 입력 받도록 하기 위함
//		Scanner sc = new Scanner(System.in);
//		int n = 0;
//
//		do {
//			System.out.println("입력 : ");
//			n = sc.nextInt();
//		} while (n < 0);
//
//		System.out.println("입력 결과 : " + n);
//	}
		// 2개의 정수를 입력받아 b - a 결과 출력 하자
		// 항상 b>a가 되도록 입력받아야 함 => a가 b보다 크면 새로 입력받도록
//		int a = 0;
//		int b = 0;
//		do {
//			System.out.println("b : ");
//			b = sc.nextInt();
//			System.out.println("a : ");
//			a = sc.nextInt();
//		} while (b - a <= 0);
//		
//		System.out.println(b - a);

		int n = (int) (Math.random() * 9) + 1;
		System.out.println(n);

		// 임의의 난수 3개를 받아서 서로 중첩되지 않도록 출력하기
		int a = 0;
		int b = 0;
		int c = 0;

		for (int i = 0; i < 2; i++) {
			a = (int) (Math.random() * 9) + 1;
			do {
				b = (int) (Math.random() * 9) + 1;
			} while (a == b);
			do {
				c = (int) (Math.random() * 9) + 1;
			} while (a == c || b == c);
		}
		System.out.println(a + " " + b + " " + c);

		ArrayList<Integer> list = new ArrayList<>();
	}
}
