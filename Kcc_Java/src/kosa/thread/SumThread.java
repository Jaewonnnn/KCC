package kosa.thread;

public class SumThread extends Thread {
	private int start;
	private int end;
	private int total;
	public SumThread() {
		// TODO Auto-generated constructor stub
	}
	
	public SumThread(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			total += i;
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
