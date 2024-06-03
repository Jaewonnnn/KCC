package kosa.oop6;

interface AA{
	BB abc(String a);
}
class BB{
	BB(int a){
		System.out.println("BB 생성자");
	}
	BB(String a){
		System.out.println(a);
	}
}

public class Main3 {

	public static void main(String[] args) {
		// 1. 익명내부클래스 
//		AA a = new AA() {
//			@Override
//			public BB abc() {
//				return new BB();
//			}
//		};
//		a.abc();
		
		// 2.람다식
//		AA a2 = () -> new BB();
//		a2.abc();
		
		// 인스턴스 참조
		AA a3 = BB::new;
		a3.abc("123");
	}
}