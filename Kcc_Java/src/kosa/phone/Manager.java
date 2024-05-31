package kosa.phone;

import java.util.Scanner;

//전화번호 관리와 관련된 전반적인 기능
public class Manager {
	private PhoneInfo[] arr = new PhoneInfo[10];
	private int idx;
	
	Scanner sc = DataInput.getInstance();

	public Manager() {

	}

	public void addPhoneInfo() {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력받아
		// PhoneInfo객체를 생성해서 배열에 추가하는 것
		System.out.println("1.일반 2.회사 3.동창");
		String type = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 : ");
		String phoneNo = sc.nextLine();
		System.out.println("생년월일 : ");
		String birth = sc.nextLine();
		
		switch(type) {
		case "1":
			arr[idx++] = new PhoneInfo(name, phoneNo, birth);
			break;
		case "2":
			System.out.println("부서 : ");
			String dept = sc.nextLine();
			System.out.println("직책 : ");
			String position = sc.nextLine();
			arr[idx++] = new Company(name, phoneNo, birth, dept, position);
			break;
		case "3":
			System.out.println("전공 : ");
			String major = sc.nextLine();
			System.out.println("학번 : ");
			String year = sc.nextLine();
			arr[idx++] = new Universe(name, phoneNo, birth, major, year);
			break;
		}
	}

	public void listPhoneInfo() {
		System.out.println("1.전체 2.일반 3.회사 4.동창");
		String type = sc.nextLine();
		switch(type) {
		case "1":
			printAllList();
			break;
		case "2":
			for(int i = 0; i < idx; i++) {
				if(!(arr[i] instanceof Company) && !(arr[i] instanceof Universe)) {
					arr[i].show();
				}
			}
			break;
		case "3":
			for(int i = 0; i < idx; i++) {
				if(arr[i] instanceof Company) {
					arr[i].show();
				}
			}
			break;
		case "4":
			for(int i = 0; i < idx; i++) {
				if(arr[i] instanceof Universe) {
					arr[i].show();
				}
			}
			break;
		}
	}
	
	public void printAllList() {
		for (int i = 0; i < idx; i++) {
			System.out.println("이름 : " + arr[i].getName());
			System.out.println("전화번호 : " + arr[i].getPhoneNo());
			System.out.println("생년월일 : " + arr[i].getBirth());
		}	
		
	}

	public void printAllList(int i) {
		System.out.println("이름 : " + arr[i].getName());
		System.out.println("전화번호 : " + arr[i].getPhoneNo());
		System.out.println("생년월일 : " + arr[i].getBirth());
	}

	public void searchPhoneInfo(String name) {
		boolean flag = false;
		for (int i = 0; i < idx; i++) {
			if (arr[i].getName().equals(name)) {
				printAllList(i);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("찾을 수 없음");
		}
	}

	public void updatePhoneInfo(String name, int num, String updateContent) {
		int buf = searchIndex(name);

		if (buf == -1) {
			return;
		}

		if (num == 1) {
			arr[buf].setName(updateContent);
		} else if (num == 2) {
			arr[buf].setPhoneNo(updateContent);
		} else if (num == 3) {
			arr[buf].setBirth(updateContent);
		} else {
			System.out.println("실패");
		}
	}

	public void deletePhoneInfo(String name) {
		int buf = searchIndex(name);
		if (buf == -1) {
			return;
		} else {
			for (int i = buf; i < idx; i++) {
				if (i == arr.length - 1) {
					arr[i] = null;
				} else
					arr[i] = arr[i + 1];
			}
			idx--;
		}
	}

	public int searchIndex(String name) {
		boolean flag = false;
		int buf = 0;
		for (int i = 0; i < idx; i++) {
			if (arr[i].getName().equals(name)) {
				buf = i;
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("이름을 찾을 수 없음");
			return -1;
		} else {
			return buf;
		}
	}
}
