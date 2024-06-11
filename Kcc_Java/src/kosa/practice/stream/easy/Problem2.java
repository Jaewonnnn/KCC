package kosa.practice.stream.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {

    /**
     * 주어진 정수 리스트의 각 요소를 제곱하여 새로운 리스트를 반환합니다.
     *
     * @param numbers 원본 정수 리스트
     * @return 각 요소를 제곱한 새 리스트
     */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= 5; i++) {
			list.add(i);
		}
		list = squareNumbers(list);
		for(int i:list) {
			System.out.println(i);
		}
	}
    public static List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream().map(s-> s = s * s).collect(Collectors.toList());
    }
}