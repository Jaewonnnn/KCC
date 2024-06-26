package kosa.shoppingmall;

import java.io.BufferedReader;

public class Main {

	public static void main(String[] args) throws Exception {
		ShoppingMall shoppringMall = new ShoppingMall();

		BufferedReader br = DataInput.getInstance();
		
		while (true) {
			System.out.println("====================================");
			System.out.println("번호\t메뉴");
			System.out.println("====================================");
			System.out.println("1\t로그인\n2\t회원가입\n3\t종료");
			System.out.println("====================================");
			System.out.print("번호를 입력하세요 : ");
			String num = br.readLine();
			switch (num) {
			case "1":
				Person p = shoppringMall.signIn();
				if (p.getRole() == Role.USER) {
					shoppringMall.userStart();
				} else if (p.getRole() == Role.ADMIN) {
					shoppringMall.adminStart();
				}
				break;
			case "2":
				shoppringMall.signUp();
				break;
			case "3":
				System.out.println("====================================");
				System.out.println("프로그램 종료");
				System.out.println("====================================");
				return;
			}
		}
	}
}