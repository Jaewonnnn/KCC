package kosa.bank;

public class Customer {
	private String id;
	private String name;
	private Account account;
	
	public Customer() {
		
	}

	public Customer(String id, String name, long account) {
		this.id = id;
		this.name = name;
		this.account = new Account(id, account);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
