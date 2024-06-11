package kosa.practice.stream.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {

    /**
     * 주어진 문자열 리스트를 하나의 문자열로 연결하여 반환합니다.
     *
     * @param strings 원본 문자열 리스트
     * @return 연결된 문자열
     */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String str = "asd qwe er rwe wqr";
		String arr[] = str.split(" ");
		list = Arrays.asList(arr);
		System.out.println(concatenateStrings(list));
	}
    public static String concatenateStrings(List<String> strings) {
    	
    	return strings.stream().collect(Collectors.joining());
    }
}