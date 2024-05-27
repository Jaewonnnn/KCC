package kosa.mission;

import java.util.ArrayList;
import java.util.Scanner;

public class Mission05 {

	public static void main(String[] args) {
		// 메뉴를 선택해서 해당 메뉴 명령문을 실행해 보자.
		// 1. 추가 / 2. 출력 / 3.검색 / 4. 종료

		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		ArrayList<String> menuList = new ArrayList<>();
		
		while(flag) {
			System.out.println("1.추가 2.출력 3.검색 4.종료");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1:
				System.out.print("추가할 메뉴를 입력하세요 : ");
				String menu = sc.nextLine();
				menuList.add(menu);
				break;
			case 2:
				for(int i = 0; i < menuList.size(); i++) {
					System.out.print(i+1 + "번 메뉴 :" + menuList.get(i) + " ");
				}
				System.out.println();
				break;
			case 3:
				System.out.println("검색할 메뉴를 입력하세요 : ");
				String search = sc.nextLine();
				for(int i = 0; i < menuList.size(); i++) {
					if(menuList.get(i).equals(search)) {
						System.out.println(search + "는 " + (i+1) + "번 메뉴 입니다.");
						break;
					}
				}
				break;
			case 4:
				flag = false;
				break;
			}
		}
		System.out.println("종료되었습니다.");
	}

}
