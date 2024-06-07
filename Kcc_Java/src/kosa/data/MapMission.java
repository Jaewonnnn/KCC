package kosa.data;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapMission {

	public static void main(String[] args) {
		//이름, 점수를 한 쌍으로 Map 자료구조로 구현하시오
		//ex) 김자바 : 90, 박자바 : 60
		//1. 시험 응시자만 출력
		//2. 총점, 평균, 최고점수, 최저점수 출력
		// Collections => max(), min()
		Map<String, Integer> map = new HashMap<>();
		map.put("김자바", 90);
		map.put("박자바", 60);
		map.put("최자바", 70);
		map.put("수자바", 10);
		map.put("연자바", 100);
		
		Set<String> set = map.keySet();
		System.out.println("응시자 명단 : " + set);
		
		Collection<Integer> values = map.values();
		Iterator<Integer> iter = values.iterator();
		
		int total = 0;
		while(iter.hasNext()) {
			total += iter.next();
		}
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + total / map.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
		
		
//		int total = 0;
//		int max = Integer.MIN_VALUE;
//		int min = Integer.MAX_VALUE;
//
//		for(Entry<String, Integer> i : map.entrySet()) {
//			System.out.println(i.getKey());
//			total += i.getValue();
//			if(max < i.getValue()) max = i.getValue();
//			if(min > i.getValue()) min = i.getValue();
//		}
//		
//		
//		double avg = (double)total / map.size();
//		System.out.println("총점 : " + total);
//		System.out.println("평균 : " + avg);
//		System.out.println("최고점수 : " + max);
//		System.out.println("최저점수 : " + min);
	}
}