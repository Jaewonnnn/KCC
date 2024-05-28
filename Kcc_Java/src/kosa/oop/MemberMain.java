package kosa.oop;

public class MemberMain {

	public static void main(String[] args) {
		Member member1 = new Member(); // 객체 생성 => 인스턴스화 : m1 => 인스턴스 변수
		member1.userName = "홍길동"; // 객체 초기화
		member1.age = 100;
		member1.address = "서울";

		member1.printUserInfo();
		
		member1 = null; // GC가 메모리에서 자동으로 할당 해제함
		
		Member member2 = new Member();
		member2.userName = "박길동";
		member2.age = 10;
		member2.address = "경기도";

		member2.printUserInfo();
	}
}