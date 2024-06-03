package kosa.oop5;

public class Main {

	public static void main(String[] args) {

		Object obj[] = { new Reader("둘리"), new Work("길동"), new Student("마이콜") };

		for (Object i : obj) {
			if (i instanceof Speakable) {
				System.out.println(((Speakable) i).speak());
			}
		}
	}

}
