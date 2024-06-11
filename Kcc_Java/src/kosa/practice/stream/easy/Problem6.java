package kosa.practice.stream.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    /**
     * 주어진 정수 리스트에서 중복된 값을 제거하고 유일한 값들만 포함하는 리스트를 반환합니다.
     *
     * @param numbers 원본 정수 리스트
     * @return 중복 없는 정수 리스트
     */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		list.add(2);
		removeDuplicates(list).stream().forEach(System.out::println);
	}
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().collect(Collectors.toList());
    }
}