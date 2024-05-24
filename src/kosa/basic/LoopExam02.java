package kosa.basic;

public class LoopExam02 {

	public static void main(String[] args) {
		// 중첩 for문
		// 전체 구구단 출력
//		for(int i = 1; i <= 9; i++) {
//			System.out.println("2 * " + i + " =" + (2 * i));
//		}

//		// 중첩 for문을 이용해서 구구단 출력
//		for(int i = 2; i <= 9; i++) {
//			for(int j = 1; j <= 9; j++) {
//				System.out.println(i + " * " + j + " = " + (i*j));
//			}
//		}

		// 4x + 5y = 60 => x,y의 모든 해
//		for(int i = 0; i <= 15; i++) {
//			for(int j = 0; j <= 12; j++) {
//				if((4*i) + (5*j) == 60) {
//					System.out.println(i + ", " + j);
//				}
//			}
//		}
		// 라벨
//		outerLabel:
//		for(int i = 0; i <= 15; i++) {
//		for(int j = 0; j <= 12; j++) {
//			if((4*i) + (5*j) == 60) {
//				System.out.println(i + ", " + j);
//				break outerLabel;
//			}
//		}

		// 별찍기
		for (int i = 0; i < 5; i++) {
			for (int j = 1; j <= i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < 5; i++) {
			for (int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
