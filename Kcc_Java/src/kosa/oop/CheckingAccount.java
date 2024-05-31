package kosa.oop;

public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount() {

	}

	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		// super가 없으면 부모의 디폴트 생성자를 호출함.
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) throws Exception {
		if (!this.cardNo.equals(cardNo) || getBalance() < amount) {
			throw new Exception("결제 불가");
		}
		return withdraw(amount);
	}
	@Override
	public void print() {
		System.out.println("자식");
	}
}
