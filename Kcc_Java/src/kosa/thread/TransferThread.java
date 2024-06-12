package kosa.thread;

public class TransferThread extends Thread{
	SharedArea sharedArea;
	
	public TransferThread(SharedArea area) {
		this.sharedArea = area;
	}
	public void run() {
		for(int cnt = 0; cnt < 12; cnt++) {
			synchronized (sharedArea) {
				sharedArea.account1.withdraw(1000000);
				System.out.println("이몽룡 계좌 : 100만원 인출,");
				sharedArea.account2.deposit(1000000);
				System.out.println("성춘향 계좌 : 100만원 입금");				
			}
		}
	}
}
