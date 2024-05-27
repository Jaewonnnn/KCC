package kosa.basic;

public class ExceptionExam {

	public static void noEquals(int a, int b) throws Exception {
		if(a == b) {
			throw new Exception("같은 값 안돼");
		}
	}
	
	public static void main(String[] args) {
		try {// 예외발생 1345 / 발생 x 1245
			System.out.println("1");
			noEquals(10, 10);
			System.out.println("2");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("3");
		} finally {
			System.out.println("4");
		}
		System.out.println("5");
	}
}