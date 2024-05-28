package kosa.oop;

public class Member {
	// 회원 정보에 대한 클래스와 객체를 생성 후 출력해 봅시다.
	// 상태, 행동 구성
	String userName;
	int age;
	String address;
	
	public void printUserInfo() {
		System.out.println("이름 : " + userName);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
	}
}
