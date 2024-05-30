package kosa.bank;

public class Account {
	private String id;
	private long balance;
	
	public Account() {
		
	}

	public Account(String id, long balance) {
		this.id = id;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public boolean withdraw(long balance) {
		if(this.balance > balance) {
			this.balance -= balance;
			return true;
		}
		return false;
	}

	public void deposit(long balance) {
		this.balance += balance;
	}



}
