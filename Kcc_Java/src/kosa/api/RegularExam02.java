package kosa.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExam02 {

	public static void main(String[] args) {
		String data[] = {
				"bat", "bba", "bbg", "bonus",
				"CA", "ca", "c232", "car",
				"date", "dic", "diraaa"
		};
		
		// c로 시작, 숫자 x
//		Pattern p = Pattern.compile("c[a-z]*");
//		for(int i = 0; i < data.length; i++) {
//			Matcher m = p.matcher(data[i]);
//			if(m.matches()) {
//				System.out.println(data[i]);
//			}
//		}
		
//		String source = "ab?cd?ef?gh";
//		String reg = "(\\w*)";
//		
//		Pattern p = Pattern.compile(reg);
//		Matcher m = p.matcher(source);
//		while(m.find()) {
//			System.out.println(m.group());
//		}
		
		String source = "HP: 010-1111-1111, HOME: 02-222-2222";
		String reg = "0\\d{1,2}-\\d{3,4}-\\d{4}";
		
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(source);
		while(m.find()) {
			System.out.println(m.group());
		}
	}
}