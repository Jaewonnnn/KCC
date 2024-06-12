package kosa.thread;

public class digitThread extends Thread {
	@Override
	public void run() {
		for (int cnt = 0; cnt < 10; cnt++) {
			System.out.print(cnt + " ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
