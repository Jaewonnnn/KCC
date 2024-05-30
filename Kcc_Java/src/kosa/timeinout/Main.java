package kosa.timeinout;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		Company kosa = new Company("kosa");

		User u1 = new User("유재원", "0710", "010");
		User u2 = new User("홍길동", "1234", "010");
		User u3 = new User("qqq", "1234", "010");

		kosa.addDepartment("1");
		kosa.addDepartment("2");
		kosa.addDepartment("3");
		kosa.addDepartment("4");
		kosa.addDepartment("5");

		kosa.joinCompany(u1);
		kosa.joinCompany(u2);
		kosa.joinCompany(u3);

		kosa.leaveCompany(u3);

		kosa.printUsers();

		u1.printUserInfo();

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String time = now.format(formatter);

		u1.goToWork("1");
		u1.goToHome("2");
		u1.goToWork("3");
		u1.goToHome("4");

		u1.requestVacation();
		
		u1.printUserInfo();
		
		u1.printAllLog();
	}

}
