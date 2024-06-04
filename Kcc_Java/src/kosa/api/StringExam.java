package kosa.api;

import java.util.Arrays;

public class StringExam {

	public static void main(String[] args) {
		// 1.String 객체 생성 방법과 차이점
		String str = "ABC";
		String str2 = "ABC";
		String str3 = new String("ABC");

		// String constant pool
		if (str == str2) { // 똑같은 리터럴 형식으로 선언하면 같은 주소를 가리킨다.
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		if (str == str3) { // new 연산자로 생성하면, 내용이 같더라도 힙영역에 객체가 생성된다
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		// 2.String 클래스 불변성 특징
		// String 클래스의 어떠한 메서드를 사용하더라도 자기 자신은 바뀌지 않는다.
		// 메서드들은 값을 리턴하기 위해서 사용하는 것(새로운 문자열을 만들어서 리턴)
		str.concat("DEF");
		System.out.println(str); // ABC

		// StringBuffer, StringBuilder(가변성)
		StringBuffer sb = new StringBuffer("ABC");
		sb.append("DEF");
		System.out.println(sb);

		// 연산자(+) 변경 가능
		String sql = "select * from board ";
		int num = 10;
		if (num == 10) {
			sql += "where num = 10";
		}
		System.out.println(sql);

		// 해당 문자열의 위치를 파악 => indexOf("문자열") => 해당 문자열의 인덱스 번호 리턴, 없으면 -1 리턴
		System.out.println(sql.indexOf("board")); // 14

		// 문자열 길이
		System.out.println(sql.length()); // 34

		for (int i = 0; i < sql.length(); i++) {
			System.out.print(sql.charAt(i));
		}
		System.out.println();

		// 문자열 부분 추출 : subString(5), subString(5, 10)
		// sql 변수의 board 문자열만 출력
		System.out.println(sql.substring(sql.indexOf("board"), sql.indexOf("board") + 5));

		String fileName = "kosa.jpg";

		String head = fileName.substring(0, fileName.indexOf("."));
		String pattern = fileName.substring(fileName.indexOf(".") + 1);
		System.out.println(head + ":" + pattern);

		String id = "kosa";
		String m_id = "Kosa ";
		if (id.equalsIgnoreCase(m_id.trim())) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}

		// 문자열 ==> String[] 변환
		String fruits = "사과,포도,수박,배";
		String[] arr = fruits.split(",");
		System.out.println(Arrays.toString(arr));

		// 문자열 ==> Character[] 변환
		String str5 = "abcdef";
		char[] arr2 = str5.toCharArray();
		System.out.println(Arrays.toString(arr2));

		// 문자열 ==> byte[] 변환
		String str6 = "abcdef";
		byte arr3[] = str5.getBytes(); // 아스키코드값 반환
		System.out.println(Arrays.toString(arr3));

		// 문자열 <==> 정수형
		String str7 = "100";
		int num2 = Integer.parseInt(str7);
		System.out.println(num2);
		int num3 = 10;
//		String str8 = String.valueOf(num3);
		String str8 = 10 + "";
		System.out.println(str8);
	}
}