package kosa.oop6;

interface A {
	void abc();
}

class B {
	void bcd() {
		System.out.println("메서드 호출");
	}
}

public class Main2 {

	public static void main(String[] args) {
		// 1.익명클래스를 이용해서 abc() 오버라이딩 -> B를 생성해서 bcd()를 호출해 주세요
//		A a = new A() {
//			@Override
//			public void abc() {
//				B b = new B();
//				b.bcd();
//			}
//		};
		
		// 2. 해당 내용을 동일하게 람다식으로 표현
//		A a = () -> {
//			B b = new B();
//			b.bcd();
//		};
//		a.abc();
		
		// 3. 인스턴스 참조 구현
		B b = new B();
		A a = b::bcd;
		a.abc();
	}

}
