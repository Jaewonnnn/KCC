package kosa.thread;

public class MultithreadExample1 {

	public static void main(String[] args) {
		Thread thread = new digitThread();
		thread.start();
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}		
	}
}