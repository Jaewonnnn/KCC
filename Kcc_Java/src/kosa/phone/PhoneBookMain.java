package kosa.phone;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		Manager manager = new Manager();
		Scanner sc = new Scanner(System.in);
		xx :
			while(true) {
			
			System.out.println("1.추가 2.전체출력 3.검색 4.종료");
			System.out.print(">메뉴 : ");
			
			String menu = sc.nextLine();
			
			switch(menu) {
			case "1":
				System.out.println("이름 : ");
				String name = sc.nextLine();
				System.out.println("전화번호 : ");
				String phoneNo = sc.nextLine();
				System.out.println("생년월일 : ");
				String birth = sc.nextLine();
				
				manager.addPhoneInfo(name, phoneNo, birth);
				continue;
			case "2":
				manager.listPhoneInfo();
				continue;
			case "3":
				System.out.println("검색 이름 : ");
				name = sc.nextLine();
				manager.searchPhoneInfo(name);
				continue;
			case "4":
				System.out.println("프로그램 종료");
				break xx;
			default :
				System.out.println("다시 입력하세요");	
			}
		}
		sc.close();
	}
}
