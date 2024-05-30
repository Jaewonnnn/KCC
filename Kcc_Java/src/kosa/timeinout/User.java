package kosa.timeinout;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private String birth;
	private String phoneNumber;
	private String company;
	private String department;

	private List<InOut> list = new ArrayList<>();
	private InOut inOut;

	private Attendance attendance;

	public User(String name, String birth, String phoneNumber) {
		this.name = name;
		this.birth = birth;
		this.phoneNumber = phoneNumber;
		inOut = new InOut();
		attendance = new Attendance();
	}

	public void printUserInfo() {
		System.out.println("이름 : " + name);
		System.out.println("생일 : " + birth);
		System.out.println("전화번호 : " + phoneNumber);
		System.out.println("직장 명 : " + company);
		System.out.println("부서 명 : " + department);
		System.out.println("총 근무 일 : " + attendance.getWorkDay());
		System.out.println("남은 휴가 일 : " + attendance.getVacation());
		System.out.println("======================");
		System.out.println();
	}

	public void goToWork(String time) {
		InOut a = new InOut();
		list.add(a.inTime(time));
	}

	public void goToHome(String time) {
		InOut a = list.get(list.size() - 1);
		list.set(list.size() - 1, a.setOutTime(time, a));
		attendance.setWorkDay();
	}

	public void printAllLog() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getInTime());
			System.out.println(list.get(i).getOutTime());
		}
	}

	public void requestVacation() {
		attendance.requestVacation();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<InOut> getList() {
		return list;
	}

	public void setList(List<InOut> list) {
		this.list = list;
	}

	public InOut getInOut() {
		return inOut;
	}

	public void setInOut(InOut inOut) {
		this.inOut = inOut;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}
}
