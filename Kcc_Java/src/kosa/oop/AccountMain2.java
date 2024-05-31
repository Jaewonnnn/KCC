package kosa.oop;

public class AccountMain2 {

	public static void main(String[] args) {

		Account arr[] = { 
				new Account("111", "홍길동", 10000), 
				new CheckingAccount("111-111", "홍길동", 10000, "222-222"),
				new MinusAccount("333-333", "김길동", 10000, 10000) 
				};

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] instanceof CheckingAccount) { // arr[i]가 CheckingAccount로 캐스팅이 가능한지?
				try {
					((CheckingAccount)arr[i]).pay("222-222", 5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(arr[1].getBalance());

		// 업캐스팅
//		Account ca = new CheckingAccount("111-111", "홍길동", 10000, "222-222");

//		ca.print();

//		CheckingAccount ca = new CheckingAccount("111-111", "홍길동", 10000, "222-222");
//		
//		자식으로 강제 형변환
//		CheckingAccount ca2 = (CheckingAccount)ca;

		// ClassCastException
//		Account ca = new Account("111", "김길동", 1000);

		// 부모로 형변환 후 자신만이 가지고 있는 메소드는 더 이상 접근할 수 없음
//		CheckingAccount ca2 = (CheckingAccount)ca; // 강제 형변환(다운캐스팅)
//		try {
//			if(ca2 instanceof CheckingAccount) {
//				((CheckingAccount)ca2).pay("222-222", 3000);				
//			}else {
//				System.out.println("형변환 불가");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(ca2.getBalance());
	}
}
