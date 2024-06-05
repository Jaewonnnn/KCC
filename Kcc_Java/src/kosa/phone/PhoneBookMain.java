package kosa.phone;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		Manager manager = new Manager();
		
		Scanner sc = DataInput.getInstance();
		
		xx: while (true) {
			System.out.println("1.추가 2.전체출력 3.검색 4.수정 5.삭제 6.종료");
			System.out.print(">메뉴 : ");

			String menu = sc.nextLine();

			switch (menu) {
			case "1":
				manager.addPhoneInfo();
				continue;
			case "2":
				manager.listPhoneInfo();
				continue;
			case "3":
				System.out.println("검색 이름 : ");
				String name = sc.nextLine();
				manager.searchPhoneInfo(name);
				continue;
			case "4":
				manager.listPhoneInfo();
				System.out.println("수정 할 이름 입력");
				name = sc.nextLine();
				System.out.println("수정 할 항목 입력");
				System.out.println("1.이름 2.전화번호 3.생년월일");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("수정 할 내용 입력");
				String updateContent = sc.nextLine();

				manager.updatePhoneInfo(name, num, updateContent);

				continue;
			case "5":
				manager.listPhoneInfo();
				System.out.println("삭제 할 이름 입력");
				name = sc.nextLine();
				manager.deletePhoneInfo(name);
				continue;
			case "6":
				System.out.println("프로그램 종료");
				break xx;
			default:
				System.out.println("다시 입력하세요");
			}
		}
		sc.close();
	}
}