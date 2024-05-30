package kosa.phone;

//전화번호 관리와 관련된 전반적인 기능
public class Manager {
	private PhoneInfo[] arr = new PhoneInfo[10];
	private int idx;
	public Manager() {
		
	}
	
	public void addPhoneInfo(String name, String phoneNo, String birth) {
		//키보드로부터 이름, 전화번호, 생년월일을 입력받아 
		//PhoneInfo객체를 생성해서 배열에 추가하는 것
		arr[idx++] = new PhoneInfo(name, phoneNo, birth);
	}

	public void listPhoneInfo() {
		for (int i = 0; arr[i] != null; i++) {
			System.out.println("이름 : " + arr[i].getName());
			System.out.println("전화번호 : " + arr[i].getPhoneNo());
			System.out.println("생년월일 : " + arr[i].getBirth());
		}
	}
	
	public void listPhoneInfo(int i) {
			System.out.println("이름 : " + arr[i].getName());
			System.out.println("전화번호 : " + arr[i].getPhoneNo());
			System.out.println("생년월일 : " + arr[i].getBirth());
	}

	public void searchPhoneInfo(String name) {
		boolean flag = false;
		for(int i = 0; arr[i] != null; i++) {
			if(arr[i].getName().equals(name)){
				listPhoneInfo(i);
				flag = true;
			}
		}
		if(flag == false) {
			System.out.println("찾을 수 없음");
		}
	}

	public void updatePhoneInfo(String name, int num, String updateContent) {
		int buf = searchIndex(name);
		
		if(buf == -1) {
			return;
		}
		
		if(num==1) {
			arr[buf].setName(updateContent);
		}else if(num==2) {
			arr[buf].setPhoneNo(updateContent);
		}else if(num==3) {
			arr[buf].setBirth(updateContent);
		}else {
			System.out.println("실패");
		}	
	}

	public void deletePhoneInfo(String name) {
		int buf = searchIndex(name);
		if(buf == -1) {
			return;
		}else {
			for(int i = buf; i < idx; i++) {
				arr[i] = arr[i+1];
			}
			idx--;
		}
	}
	public int searchIndex(String name) {
		boolean flag = false;
		int buf = 0;
		for(int i = 0; i < idx; i++) {
			if(arr[i].getName().equals(name)) {
				buf = i;
				flag = true;
				break;
			}
		}
		if(flag == false) {
			System.out.println("이름을 찾을 수 없음");
			return -1;
		}else {
			return buf;
		}
	}
}
