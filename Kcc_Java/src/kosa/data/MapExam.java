package kosa.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
	public static void main(String[] args) {
		//Map : (key,value),  => HashMap
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "KIA");
		map.put("2", "LG");
		map.put("3", "SAMSUNG");
		
		System.out.println("요소의 사이즈 : " + map.size());
		if(map.containsValue("LG")) {
			map.remove("2");
		}
		System.out.println("요소의 사이즈 : " + map.size());
		System.out.println("삼성팀 : " + map.get("3"));
		
		// 맵의 전체 목록을 출력하고 싶을 때(key,value) : key없이
		//Map => Set => Iterator
		//key => keySet() :Set
		//value => values() :Collection
		//(key,value) => entrySet() :set
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			Map.Entry<String, String> e = (Map.Entry<String, String>)iter.next(); // 내부클래스
			System.out.println("key : " + e.getKey() + ", value : " + e.getValue());
		}
	}
}
