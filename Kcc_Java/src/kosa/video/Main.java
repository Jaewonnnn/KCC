package kosa.video;

public class Main {

	public static void main(String[] args) {
		Video[] videos = {
				new Video(1, "트랜스포머3", "서봉수"),
				new Video(2, "쿵푸펜더2", "지성민")
		};
//		Video video1 = new Video(1, "트랜스포머3", "서봉수");
//		Video video2 = new Video(2, "쿵푸펜더2", "지성민");

		//GeneralMember와 SpecialMember를 함께 배열에 넣고
		//각각의 rental(), show() 호출해서 출력
		//SpecialMember는 spacialPrint() 호출하도록 하여라
		GeneralMember arr[] = {
				new GeneralMember("aaa", "홍길동", "동탄"),
				new SpecialMember("bbb", "김철수", "서울")
		};

		for(int i = 0; i < arr.length; i++) {
			arr[i].rentVideo(videos[i]);
			arr[i].printRentInfo();
			if(arr[i] instanceof SpecialMember) {
				((SpecialMember)arr[i]).spcialPrint();
			}
		}

//		GeneralMember generalMember = new GeneralMember("aaa", "홍길동", "동탄");
//		SpecialMember specialMember = new SpecialMember("bbb", "김철수", "서울");
//		generalMember.rentVideo(video1);
//		
//		specialMember.rentVideo(video2);
//
//		generalMember.printRentInfo();
//		specialMember.printRentInfo();
	}
}