package kosa.baseball;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Solution solution = new Solution();
		int[] input = new int[3];
		
		int count = 1;
		while(true) {
			System.out.println("숫자 3자리 정답을 입력해주세요");
			int num = sc.nextInt();
			int idx = 2;
			while(num > 0) {
				input[idx--] = num % 10;
				num /= 10;
			}
			
			String c = solution.checkCount(input);
			if(c.equals("3S")) {
				System.out.println(count +"번째 성공");
				break;
			}else {
				System.out.println(c);
			}
			count++;
		}
		sc.close();
	}
}