package kosa.oop;

public class StaticExam {
	
	int total;
	static int grandTotal;
	
	public static void add() {
		grandTotal += 10;
//		total += 20; // Static 메소드이기 때문에 메모리에 생성되는 시점이 달라서 사용 불가
	}

	public static void main(String[] args) {
		add();
	}
}
