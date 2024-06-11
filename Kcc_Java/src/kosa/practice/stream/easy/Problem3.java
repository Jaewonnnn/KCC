package kosa.practice.stream.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    /**
     * 주어진 Double 리스트의 모든 요소의 합계를 반환합니다.
     *
     * @param numbers 원본 Double 리스트
     * @return 요소들의 합계
     */
	public static void main(String[] args) {
		List<Double> list = new ArrayList<Double>();
		for(int i = 0; i < 5; i++) {
			list.add((double)i+1);
		}
		System.out.println(sumOfList(list));
	}
    public static double sumOfList(List<Double> numbers) {
        return numbers.stream().mapToDouble(d->d).sum();
    }
}