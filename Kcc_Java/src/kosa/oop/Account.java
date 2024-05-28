package kosa.oop;

public class Account {
	// 계좌객체 생성하기 위해
	// 만들고자 하는 객체로부터 공통된 데이터 구조와 기능을 추출
	// 상태(데이터) : 계좌번호, 예금주, 잔액 => 멤버변수
	// 행동(기능) : 입금하기, 출금하기 => 멤버메서드

	String accountNo; // 계좌번호
	String ownerName; // 예금주
	int balance; // 잔액

	// 입금하기
	public void deposit(int amount) {
		balance += amount;
	}
	// 생성자
	public Account() {	} // 디폴트 생성자 아무 생성자가 없을 때 JVM이 자동으로 만들어 준다
	// 하지만 다른 생성자가 존재하면 오류
	// 클래스를 생성하면 디폴트 생성자를 무조건 만드는 습관을 들이자
	
	// accountNo는 생성자가 끝나면 사라짐, 필드에 선언되어있는 accountNo는 객체가 사라지는 시점에 사라짐
	// 오버로딩 : 이름은 같지만 파라미터의 갯수나 데이터 타입이 다르면 서로 다른 것으로 구분
	public Account(String accountNo, String ownerName, int balance) { 
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}

//	public Account(String string, String string2, double d) {
//
//	}
	// 출금하기
	public int withdraw(int amount) throws Exception {
		if (balance < amount) {
			throw new Exception("잔액 부족");
		}
		
		balance -= amount;
		return balance;
	}
}