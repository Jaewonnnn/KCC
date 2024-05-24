package kosa.basic;

import java.util.Scanner;

public class VariableExam02 {

	public static void main(String[] args) {
		// 키보드로부터 데이터 입력
		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		
//		//1번째 방법
//		int num = sc.nextInt(); // 10 + \n
//		
//		sc.nextLine(); // 엔터가 들어가기 때문
//		System.out.println("문자열 입력 : ");
//		String str = sc.nextLine();
//		
//		System.out.println(num);
//		
//		System.out.println(str);	
//		
//		//2번째 방법
//		// 문자열을 받아서 처리
//		// int num = Integer.parseInt(sc.nextLine());
		
		// int <==> char
		char ch = 'A';
		System.out.println((int)ch);
		//A~Z for문 이용하여 전체 출력
		for(int i = (int)'A'; i <= (int)'Z'; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println();
		
		String num2 = "100";
		int num3 = Integer.parseInt(num2);
		int result = num3 + 100;
		System.out.println(result);
		
		
		int num4 = 10;
		String num5 = String.valueOf(num4);
		String num6 = num4 + "";
		System.out.println(num6);
		
		
		String str = 7 + "7" + 7;
		System.out.println(str);
	}
	
}