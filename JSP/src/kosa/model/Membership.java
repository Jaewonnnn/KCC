package kosa.model;

public class Membership {
	private String userName;
	private String userID;
	private String userPass;
	private String userPassCheck;
	private String email;
	private String contact;
	private boolean subscribe;
	
	
	public Membership() {}


	public Membership(String userName, String userID, String userPass, String userPassCheck, String email,
			String contact, boolean subscribe) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.userPass = userPass;
		this.userPassCheck = userPassCheck;
		this.email = email;
		this.contact = contact;
		this.subscribe = subscribe;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserPass() {
		return userPass;
	}


	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}


	public String getUserPassCheck() {
		return userPassCheck;
	}


	public void setUserPassCheck(String userPassCheck) {
		this.userPassCheck = userPassCheck;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public boolean isSubscribe() {
		return subscribe;
	}


	public void setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
	}


	@Override
	public String toString() {
		return "Membership [userName=" + userName + ", userID=" + userID + ", userPass=" + userPass + ", userPassCheck="
				+ userPassCheck + ", email=" + email + ", contact=" + contact + ", subscribe=" + subscribe + "]";
	}
	
	
}
