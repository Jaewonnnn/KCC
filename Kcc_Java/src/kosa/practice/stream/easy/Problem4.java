package kosa.practice.stream.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class Problem4 {

    /**
     * 주어진 정수 리스트에서 최대값을 반환합니다.
     * 최소값을 찾는 것도 비슷한 방법으로 할 수 있습니다.
     *
     * @param numbers 원본 정수 리스트
     * @return 리스트의 최대값
     */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 5; i++) {
			list.add(i+1);
		}
		System.out.println(findMax(list).getAsInt());
	}
    public static OptionalInt findMax(List<Integer> numbers) {
    	
    	return numbers.stream().mapToInt(i -> i).max();
    }
}