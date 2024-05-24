package kosa.basic;

public class VariableExam03 {

	public static void main(String[] args) {
		// 지역(로컬) 변수 특징 2가지
		// 1. 반드시 초기화 후 사용해야 한다.
		// 2. 선언된 변수는 정의된 범위 안에서만 사용 가능하다.

		// num이 초기화 되지 않아서 error발생
//		int num;
//		num = num + 1;
//		System.out.println(num);

		int num = 0;
		num = num + 1;
		System.out.println(num);

		// 스코프 밖에서 a 참조 불가능
//		if(num == 1) {
//			int a = 100;
//		}
//		System.out.println("a: " + a);

		int a = 0;
		if (num == 1) { // 조건문 안에서 초기화 불가능
			a = 100;
		}
		System.out.println("a: " + a);

		int i = 1;
		for (; i <= 10; i++) {
			System.out.print(i + ", ");
		}
		System.out.println("최종 i값: " + i);

		// 변수 사용 시 고민?
		// 1. 어떤 종류의 데이터인가? => 데이터타입 선언 결정
		// 2. 데이터를 어디까지 사용? => 변수 선언 위치 결정

		// 연산자 %
		System.out.println(10 % 3); // 1

		if (11 % 2 == 0) {
			System.out.println("2의 배수");
		} else {
			System.out.println("2의 배수 아님");
		}

		int num2 = 1;
//		num2 = num2 + 1;
//		num2 += 1;
		num2++;
		System.out.println(num2);

		double d = 3.14 + 1;
		System.out.println(d);
		if (d == 4.14) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		} // 부동소수점

		int b = 40;
		int c = 20;

		int max = (b > c) ? b : c;
		System.out.println(max);
	}

}
