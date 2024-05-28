package kosa.oop;

public class BookMain {

	public static void main(String[] args) {
		int totalPrice = 0;
		
		Book[] arr = {
				new Book("JAVA", 30000),
				new Book("jsp", 20000),
				new Book("Oracle", 15000)
				};
		
		for(Book book : arr) {
			book.discount();
			book.printPrice();
			
			totalPrice += book.discountPrice;
		}
		System.out.println("총 금액 : " + totalPrice);	
	}
}