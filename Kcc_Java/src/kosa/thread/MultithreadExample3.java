package kosa.thread;

public class MultithreadExample3 {

	public static void main(String[] args) {
		SmallLetters sl = new SmallLetters();
		Thread thread = new Thread(sl);
		thread.start();

		for (int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
	}
}