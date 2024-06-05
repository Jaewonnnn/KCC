package kosa.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class ListExam {

	public static void main(String[] args) {
		// 1~45 중복되지 않는 로또번호를 6개 출력
		Random r = new Random();

		// 1. 배열로 구현
//		int[] numbers = new int[6];
//		int i = 1;
//		numbers[0] = (int) (Math.random() * 45) + 1;
//		xx:while (true) {
//			int number = (int) (Math.random() * 45) + 1;
//			for (int j = 0; numbers[j] != 0; j++) {
//				if (numbers[j] == number) {
//					continue xx;
//				}
//			}
//			numbers[i++] = number;
//			if(i == 6) break;
//		}
//		Arrays.sort(numbers);
//		for(int j = 0; j < 6; j++) {
//			System.out.println(numbers[j]);
//		}
		
		// 2. List로 구현
//		List<Integer> numbers = new ArrayList<>();
//		while(true) {
//			int number = r.nextInt(45) + 1;
//			if(!numbers.contains(number)) {
//				numbers.add(number);
//			}
//			if(numbers.size() >= 6)break;
//		}
//		Collections.sort(numbers);
//		System.out.println(numbers);
		
		// 3. set 구현
		Set<Integer> set = new TreeSet<Integer>(); //제네릭 -> 타입안정성 보장
		for(int i = 0; set.size() < 6; i++) {
			set.add(r.nextInt(45) + 1);
		}
		System.out.println(set);
	}
}