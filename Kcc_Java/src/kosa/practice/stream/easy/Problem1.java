package kosa.practice.stream.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {

    /**
     * 주어진 문자열 리스트에서 길이가 5 이상인 문자열만을 포함하는 리스트를 반환합니다.
     *
     * @param strings 원본 문자열 리스트
     * @return 길이가 5 이상인 문자열만 포함하는 리스트
     */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("zqwerewfd");
		list.add("zz");
		list.add("qwert");
		list = filterStrings(list);
		for(String i : list) {
			System.out.println(i);
		}
		
	}
    public static List<String> filterStrings(List<String> strings) {
        return strings.stream().filter(s->s.length() >= 5).collect(Collectors.toList());
    }
}
