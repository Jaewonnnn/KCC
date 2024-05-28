package kosa.oop;

public class Manager {
	PhoneInfo[] arr = new PhoneInfo[10];
	int i = 0;
	public Manager() {
	}

	public void addPhoneInfo(String name, String phoneNo, String birth) {
		arr[i++] = new PhoneInfo(name, phoneNo, birth);
	}

	public void listPhoneInfo() {
		for (int i = 0; arr[i] != null; i++) {
			System.out.println("이름 : " + arr[i].name);
			System.out.println("전화번호 : " + arr[i].phoneNo);
			System.out.println("생년월일 : " + arr[i].birth);
		}
	}
	
	public void listPhoneInfo(int i) {
			System.out.println("이름 : " + arr[i].name);
			System.out.println("전화번호 : " + arr[i].phoneNo);
			System.out.println("생년월일 : " + arr[i].birth);
	}

	public void searchPhoneInfo(String name) {
		for(int i = 0; arr[i] != null; i++) {
			if(arr[i].name.equals(name)){
				listPhoneInfo(i);
				return;
			}	
		}
		System.out.println("찾을 수 없음");
	}
}
