package kosa.oop;

public class Book {
	// 상태 : 책 이름, 정가, 할인된 가격
	// 기능 : 할인된 가격을 산출, 책 정보를 출력
	String name;
	int price;
	int discountPrice;

	public Book(){
		
	}
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public void discount() {
		if (price >= 30000) {
			discountPrice =(int)(price * 0.75);
		} else if (price >= 20000 && price < 30000) {
			discountPrice =(int)(price * 0.8);
		} else if(price >= 15000 && price < 20000) {
			discountPrice =(int)(price * 0.85);
		}
	}

	public void printPrice() {
		System.out.println(name + " 교재의 정가는 " + price + "원. 할인된 가격은 " + discountPrice + "원 입니다.");
	}
}
