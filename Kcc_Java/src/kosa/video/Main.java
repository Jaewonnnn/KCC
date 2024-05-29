package kosa.video;

public class Main {

	public static void main(String[] args) {
		Video video1 = new Video(1, "트랜스포머3", "서봉수");
		Video video2 = new Video(2, "쿵푸펜더2", "지성민");

		GeneralMember generalMember = new GeneralMember("aaa", "홍길동", "동탄");
		generalMember.rentVideo(video2);

		generalMember.printRentInfo();
	}
}