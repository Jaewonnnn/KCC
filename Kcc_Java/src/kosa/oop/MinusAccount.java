package kosa.oop;

public class MinusAccount extends Account {
	private int creditLine;// 마이너스 한도
	
	public MinusAccount() {}

	public MinusAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	/*
	 * 오버라이딩
	 * 1.상속관계에서만 가능
	 * 2.메서드의 시그니쳐(접근제어자, 리턴형, 이름, 파라미터) 일치
	 * 3.메서드의 내용이 불일치(재정의)
	 */
	@Override
	public int withdraw(int amount) throws Exception {
		if(getBalance() + creditLine < amount) {
			throw new Exception("잔액부족");
		}
		int balance = getBalance();
		setBalance(balance-amount);
		
		return amount;
	}
	
}
