package kosa.timeinout;

public class Attendance {
	public int workDay;
	public int vacation;

	public Attendance() {
		this.workDay = 0;
		this.vacation = 15;
	}

	public void requestVacation() {
		vacation--;
		System.out.println("남은 휴가 일 : " + vacation);
	}

	public void setWorkDay() {
		workDay++;
	}

	public int getWorkDay() {
		return workDay;
	}

	public void setWorkDay(int workDay) {
		this.workDay = workDay;
	}

	public int getVacation() {
		return vacation;
	}

	public void setVacation(int vacation) {
		this.vacation = vacation;
	}
	
}
