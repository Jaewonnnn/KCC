package kosa.basic;

public class MethodExam {

	// 메서드 정의(중복된 코드 삭제, 재사용성)
	// 접근제어자, (static), 리턴타입(void), 메서드 이름(파라미터(인자))
	public static void printCharacter(int num, char alp) {
		for (int i = 0; i < num; i++) {
			System.out.print(alp);
		}
		System.out.println();
	}

	public static int add(int num1, int num2) {
		int sum = num1 + num2;

		return sum;
	}

	public static void main(String[] args) {
		printCharacter(5, '!');
		
		int sum = add(10, 20);
		
		System.out.println(sum);
	}
}