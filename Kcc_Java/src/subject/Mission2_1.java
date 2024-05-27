package subject;

import java.util.Scanner;

public class Mission2_1 {

	public static void main(String[] args) {
		// 국어, 영어, 수학 => 키보드로 입력받아서 배열로 구현하자
		// 총점, 평균 구하기 => 메서드 정의해서 구현
		int score[] = new int[3];
		Scanner sc = new Scanner(System.in);

		System.out.print("국어점수 : ");
		score[0] = Integer.parseInt(sc.nextLine());
		System.out.print("영어점수 : ");
		score[1] = Integer.parseInt(sc.nextLine());
		System.out.print("수학점수 : ");
		score[2] = Integer.parseInt(sc.nextLine());

		System.out.println();

		avgScore(totalScore(score), score);
		
		sc.close();
	}

	public static int totalScore(int score[]) {
		int sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i];
		}
		System.out.println("총점 : " + sum);
		return sum;
	}

	public static void avgScore(int total, int score[]) {
		double avg = (double) total / score.length;
		System.out.printf("평균 : " + avg);
	}

}
