package kosa.mission;

public class Mission2_2 {

	public static void main(String[] args) {
		// 성적 관리 프로그램에서 여러명의 성적을 구현해 보자
		// 번호 국어 영어 수학 총점 평균
		// 1 90 80 70 240 80
		// 2 50 40 30 120 40
		// ============================
		// 140 120 100
		// 70 60 50
		int score[][] = { { 90, 80, 70 }, { 50, 40, 30 } };

		System.out.println("번호 국어 영어 수학 총점 평균");
		printScore(score);
		System.out.println("========================");
		printSub(score);

	}

	public static void printScore(int[][] score) {
		for (int i = 0; i < score.length; i++) {
			int total = 0;
			double avg = 0;
			System.out.print((i + 1) + " ");
			for (int j = 0; j < score[i].length; j++) {
				total += score[i][j];
				System.out.print(+score[i][j] + " ");
			}
			avg = (double) total / score[i].length;
			System.out.print(total + " " + avg + "\n");
		}
	}

	public static void printSub(int[][] score) {
		int[] total = new int[3];
		double[] avg = new double[3];
		for (int i = 0; i < score[0].length; i++) {
			for (int j = 0; j < score.length; j++) {
				total[i] += score[j][i];
			}
			avg[i] = (double) total[i] / score.length;
		}
		for (int i = 0; i < total.length; i++) {
			System.out.printf("%d ", total[i]);
		}
		System.out.println();
		for (int i = 0; i < total.length; i++) {
			System.out.printf("%.1f ", avg[i]);
		}
	}

}
