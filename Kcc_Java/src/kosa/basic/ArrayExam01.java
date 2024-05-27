package kosa.basic;

import java.util.Scanner;

public class ArrayExam01 {
	public static void main(String[] agrs) {
		// 1.배열 선언, 생성 분리
		// 식별자(arr)은 메모리에 배열의 주소값을 저장
		// arr = new int[5] => 메모리에 int형 5칸을 생성하고 arr에 주소값 할당
		int arr[];
		arr = new int[5];// 배열 생성(메모리 할당)

		// 2.배열 선언과 생성을 함께
		int arr2[] = new int[5];

		// 3.배열 선언과 생성 및 초기화
		int arr3[] = { 1, 2, 3, 4, 5 };

		// 배열에 있는 내용을 출력할 때 보통 for문 사용
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "]=" + arr3[i]);
		}

		// 향상된 for문
		for (int n : arr3) {
			System.out.print(n + ", ");
		}
		// 인덱스 값을 알거나 활용해야 할 경우에는 전체 for문 사용
		// 안에 있는 값만 순서대로 뽑으면 된다면 향상된 for문 사용

		// 배열 사용 방법
		// 1. 배열에 사용될 데이터 타입을 결정한다.
		// 2. 배열의 크기를 결정한다. (한번 선언하면 배열의 크기를 늘리거나 줄일 수 없다)
		// => ArrayIndexOfBoundsException 예외 발생
		// 3. 배열 생성 방법 선택 => 1, 2, 3번 중 선택
		// 4. 배열을 어떻게 초기화 할 것인지 => 직접 인덱스 접근, for문, 생성과 초기화
		// 5. 배열의 데이터 어떻게 출력할 것인지 => for문, 향상된 for문, 직접 인덱스 접근
		
		// 키보드로 부터 문자열을 입력 받아 배열에 추가한 후 전체를 출력
		// "q"를 입력할 때 까지 입력받는다
		//>입력 : 홍길동
		//>입력 : 박길동
		//>입력 : q
		//>출력 : 홍길동, 박길동
		Scanner sc = new Scanner(System.in);
		String[] word = new String[100];
		int i = 0;
		System.out.println();
		while(true) {
			System.out.print(">입력 : ");
			String buf = sc.nextLine();
			if(buf.equals("q")){
				break;
			}
			word[i++] = buf;
		}
		System.out.print(">출력 : ");
		for(int j = 0; j < i; j++) {
			System.out.print(word[j] + ", ");
		}
	}
}
