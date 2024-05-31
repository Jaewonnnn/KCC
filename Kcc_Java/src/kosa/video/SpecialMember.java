package kosa.video;

public class SpecialMember extends GeneralMember {
	private int point;

	public SpecialMember() {
	
	}
	public SpecialMember(String id, String name, String address) {
		super(id, name, address);
		this.point = 0;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public void printRentInfo() {
		System.out.println("회원의 아이디 : " + getId());
		System.out.println("회원의 이름 : " + getName());
		System.out.println("회원의 주소 : " + getAddress());
		getRentVideo().showVideo();
		System.out.println("회원의 보너스 포인터 적립 : " + point);
		System.out.println("-------------------------------");		
	}
	
	@Override
	public void rentVideo(Video video) {
		setRentVideo(video);
		point+=10;
	}
	
	public void spcialPrint() {
		System.out.println("스페셜 멤머");
	}
}
