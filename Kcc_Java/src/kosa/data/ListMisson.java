package kosa.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListMisson {

	public static void main(String[] args) throws IOException {
		// LIst자료구조를 활용하여 키보드로부터 문자열을 입력받아 처리하자.
		// 1. 데이터추가 2.데이터삭제 3.데이터출력(for, iterator)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> list = new LinkedList<>();
		xx: while (true) {
			System.out.println("1.데이터추가 2.데이터삭제 3.데이터출력 4.종료");
			String menu = br.readLine();
			switch (menu) {
			case "1":
				System.out.print("입력 : ");
				String str = br.readLine();
				if (!checkString(list, str))
					list.add(str);
				break;
			case "2":
				if (list.size() != 0) {
					printList(list);
					while (true) {
						System.out.println("입력 : ");
						str = br.readLine();
						if (checkString(list, str)) {
							list.remove(str);
							break;
						} else {
							System.out.println("잘 못 입력");
						}
					}
				} else {
					System.out.println("삭제 할 데이터 없음");
				}
				break;
			case "3":
				if (list.size() != 0)
					printList(list);
				else
					System.out.println("출력 할 데이터 없음");
				break;
			case "4":
				System.out.println("종료");
				br.close();
				return;
			default:
				System.out.println("잘 못 입력");
			}
		}
	}

	public static void printList(List<String> list) {
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

	public static boolean checkString(List<String> list, String str) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str))
				return true;
		}
		return false;
	}

}
