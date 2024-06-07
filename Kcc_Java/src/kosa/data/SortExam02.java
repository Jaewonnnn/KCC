package kosa.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExam02 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("김길동", 80));
		list.add(new Person("박길동", 30));
		list.add(new Person("최길동", 20));
		list.add(new Person("수길동", 10));
		list.add(new Person("연길동", 70));
		
//		Collections.sort(list, new Comparator<Person>() {
//			//이름을 기준으로 오름차순
//			//String : 앞쪽문자열.compareTo(뒷쪽문자열)
//			//0 => 앞쪽(AAA) == 뒷쪽(AAA)
//			//-1 => 앞쪽(AAA) < 뒷쪽(AAA)
//			//1 => 앞쪽(ABB) > 뒷쪽(AAA)
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		
//		Collections.sort(list);
		System.out.println(list.toString());
	}
}