package kosa.timeinout;

public class InOut {
	private String inTime;
	private String outTime;

	public InOut() {
	}

	public InOut inTime(String time) {
		inTime = time;
		System.out.println("출근 시간 : " + inTime);
		return this;
	}

	public InOut setOutTime(String time, InOut a) {
		outTime = time;
        System.out.println("퇴근 시간 : " + outTime);
        return this;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

}
