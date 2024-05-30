package kosa.timeinout;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String companyName;
	private List<String> departments;
	private List<User> users;

	public Company(String name) {
		this.companyName = name;
		departments = new ArrayList<>();
		users = new ArrayList<>();
	}

	public void addDepartment(String department) {
		departments.add(department);
	}

	public void joinCompany(User user) {
		if (!users.contains(user)) {
			users.add(user);
			user.setCompany(companyName);
			int num = (int) (Math.random() * 4) + 1;
			user.setDepartment(departments.get(num));
			System.out.println(user.getName() + " 입사 성공");
		}
	}

	public void leaveCompany(User user) {
		if (users.contains(user)) {
			users.remove(user);
			user.setCompany("백수");
			System.out.println(user.getName() + " 퇴사 성공");
		} else {
			System.out.println("찾을 수 없음");
		}
	}

	public void printUsers() {
		for (int i = 0; i < users.size(); i++) {
			System.out.print((i + 1) + ". " + users.get(i).getName());
		}
		System.out.println();
	}
}
