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
		
		
		// 90이상 ,=> A학점
		// 80이상 => B학점
		// 70이상 => C학점
		// 60이상 => D학점
		// 60이하 => F학점
		char grade = 'A';
		if(avg >= 90 && avg <= 100) grade = 'A';
		else if(avg <= 89 && avg >= 80) grade = 'B';
		else if(avg <= 79 && avg >= 70) grade = 'C';
		else if(avg <= 69 && avg >= 60) grade = 'D';
		else grade = 'F';
		
		System.out.println(grade);
		
	}

}
