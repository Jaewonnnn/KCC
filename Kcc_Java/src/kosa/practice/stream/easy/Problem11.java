package kosa.practice.stream.easy;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Problem11 {

    /**
     * 주어진 정수 Set에서 첫 번째로 10보다 큰 수를 찾아 반환합니다.
     *
     * @param numbers 정수 Set
     * @return 10보다 큰 첫 번째 수 (존재하지 않으면 Optional.empty())
     */
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(12);
		set.add(14);
		set.add(9);
		set.add(3);
		System.out.println(findFirstGreaterThanTen(set).get());
	}
    public static Optional<Integer> findFirstGreaterThanTen(Set<Integer> numbers) {
        return numbers.stream().filter(s->s>9).findFirst();
    }
}