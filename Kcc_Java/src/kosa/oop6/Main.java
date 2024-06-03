package kosa.oop6;

public class Main {

	public static void main(String[] args) {
		// MyType => 익명 내부 클래스로 구현해보자.
		MyType myType = new MyType() {

			@Override
			public void hello() {
				System.out.println("익명클래스 형식 입니다.");
			}
		};
		myType.hello();

		// 람다식으로 구현
		// 추상메서드가 1개만 있을 때 사용 가능
		MyType myType2 = () -> {
			System.out.println("람다식 형식 입니다.");
		};
		myType2.hello();

		MyType myType3 = () -> System.out.println("람다식 형식2 입니다.");
		myType3.hello();

		YourType you = (String massage) -> {
			System.out.println("메시지 : " + massage);
		};

		you.talk("안녕");

		YourType you2 = message -> System.out.println("메시지 : " + message);
		you2.talk("ㅎㅎ");

		MyNumber myNumber = (x, y) -> x > y ? x : y;
		System.out.println(myNumber.getMax(1, 2));

		// Runnable => 람다식 구현
		Runnable r = () -> {
			for (int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {}
				System.out.println(i);
			}
		};
		Thread t = new Thread(r);
		t.start();
	}
}
