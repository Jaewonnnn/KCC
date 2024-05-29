package kosa.video;

public class Video { //1개의 video를 위해서
	private int videoNumber;
	private String title;
	private String actor;

	public Video() {
	}

	public Video(int videoNumber, String title, String actor) {
		this.videoNumber = videoNumber;
		this.title = title;
		this.actor = actor;
	}
	
	public void showVideo() {
		System.out.println("회원이 대여한 비디오 번호 : " + videoNumber);
		System.out.println("회원이 대여한 비디오 제목 : " + title);
		System.out.println("회원이 대여한 비디오 주인공 : " + actor);
	}

	public int getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(int videoNumber) {
		this.videoNumber = videoNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}
}