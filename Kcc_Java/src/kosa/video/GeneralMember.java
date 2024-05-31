package kosa.video;

public class GeneralMember {
	private String id;
	private String name;
	private String address;
	private Video rentVideo;

	public GeneralMember() {
	}

	public GeneralMember(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public void rentVideo(Video video) {
		rentVideo = video;
	}

	public void printRentInfo() {
		System.out.println("회원의 아이디 : " + id);
		System.out.println("회원의 이름 : " + name);
		System.out.println("회원의 주소 : " + address);
		rentVideo.showVideo();
		System.out.println("-------------------------------");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Video getRentVideo() {
		return rentVideo;
	}

	public void setRentVideo(Video rentVideo) {
		this.rentVideo = rentVideo;
	}
	
}
