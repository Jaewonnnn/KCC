package kosa.oop;

public class AccountMain {

	public static void main(String[] args) {
		Account account; // 참조형(클래스타입)
		// 메모리에 할당되면서 account변수에 주소가 저장됨
		account = new Account(); // 객체 생성(메모리 할당)
		// new 할 때 생성자가 호출 됨
		// 메모리 할당 / 생성자 호출 / 주소값 할당

//		account.accountNo = "111-111";
//		account.ownerName = "홍길동";
//		account.balance = 10000;

		// account.deposit(5000);

		try {
			account.withdraw(13000);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		System.out.println("계좌번호 : " + account.accountNo);
//		System.out.println("예금주 : " + account.ownerName);
//		System.out.println("잔액 : " + account.balance);
	}

}
