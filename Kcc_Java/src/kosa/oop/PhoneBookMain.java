package kosa.oop;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		boolean flag = true;
		Manager manager = new Manager();
		xx :
			while(flag) {
			
			System.out.println("1.추가 2.전체출력 3.검색 4.종료");
			System.out.print(">메뉴 : ");
			Scanner sc = new Scanner(System.in);
			int menu = Integer.parseInt(sc.nextLine());
			
			switch(menu) {
			case 1:
				System.out.println("이름 : ");
				String name = sc.nextLine();
				System.out.println("전화번호 : ");
				String phoneNo = sc.nextLine();
				System.out.println("생년월일 : ");
				String birth = sc.nextLine();
				
				manager.addPhoneInfo(name, phoneNo, birth);
				continue;
			case 2:
				manager.listPhoneInfo();
				continue;
			case 3:
				System.out.println("검색 이름 : ");
				name = sc.nextLine();
				manager.searchPhoneInfo(name);
				continue;
			case 4:
				System.out.println("프로그램 종료");
				break xx;
			}
			sc.close();
		}
	}

}
