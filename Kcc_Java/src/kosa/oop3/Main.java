package kosa.oop3;

public class Main {

	public static void main(String[] args) {
//		Person p = new Person("ddd", new Work());
//		Person p2 = new Person("ddd", new Student());
//		
//		p.doIt();
//		p2.doIt();
		
		Person p = new Person("홍길동", new Role() {
			
			@Override
			public void doing() {
				System.out.println("드라이빙 역할");
			}
		});
		
		p.doIt();
	}
}