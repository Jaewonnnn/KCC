package kosa.mission;

import java.util.Scanner;

public class Mission02 {
	static final int COUNT = 3;

	public static void main(String[] args) {
		// 성적관리 구현
		// 국어, 영어, 수학 점수를 키보드로 부터 입력 받고 총점과 평균을 출력하세요.
		// 단, 평균은 실수형
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int korean = Integer.parseInt(sc.nextLine());
		System.out.print("영어점수 : ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학점수 : ");
		int math = Integer.parseInt(sc.nextLine());

		int total = korean + eng + math;
		int avg = (int)(total / COUNT);

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
	}

}
