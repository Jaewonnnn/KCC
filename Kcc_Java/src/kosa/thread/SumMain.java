package kosa.thread;

public class SumMain {

	public static void main(String[] args) {
		//t1 : 1~50까지 합을 구하는 스레드
		//t2 : 51~100까지 합을 구하는 스레드
		//main : t1합 + t2합 => 합:5050출력 => 문제 : join()
		Thread t1 = new SumThread(1,50);
		Thread t2 = new SumThread(51,100);
		try {
			t1.start();
			t1.join();
			t2.start();						
			t2.join();			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(((SumThread)t1).getTotal() + ((SumThread)t2).getTotal());
	}

}
