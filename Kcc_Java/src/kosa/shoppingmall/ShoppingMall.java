package kosa.shoppingmall;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingMall {
	private List<Product> productList;
	private List<Person> personList;
	private BufferedReader br;
	private Person person;

	public ShoppingMall() {
		productList = new ArrayList<Product>();
		personList = new ArrayList<Person>();
		br = DataInput.getInstance();
		personList.add(new Person("admin"));
		productList.add(new Product("nike1", 100000, Category.valueOf("OUTER")));
		productList.add(new Product("nike2", 100000, Category.valueOf("PANTS")));
		productList.add(new Product("nike3", 100000, Category.valueOf("DRESS")));
		productList.add(new Product("nike4", 100000, Category.valueOf("SHOES")));
		productList.add(new Product("nike5", 100000, Category.valueOf("BAG")));
	}

	public void userStart() throws IOException {
		while (true) {
			System.out.println("번호\t메뉴");
			System.out.println("====================================");
			System.out.println("1.\t상품 보기\n2.\t상품주문\n3.\t장바구니추가\n4.\t장바구니삭제\n5.\t장바구니보기\n6.\t구매기록보기\n7.\t회원정보수정\n8.\t회원탈퇴\n9.\t로그아웃");
			System.out.println("====================================");
			System.out.print("번호를 입력해주세요 : ");
			String num = br.readLine();
			switch (num) {
			case "1":
				printCategory();
				System.out.print("카테고리를 입력해주세요 : ");
				String category = br.readLine();
				if (containsCategory(category)) {
					printProduct(category);
				} else {
					System.out.println("없는 카테고리입니다.");
				}
				break;
			case "2":
				printProduct();
				System.out.print("구매 할 상품을 입력하세요 : ");
				String product = br.readLine();
				if (productValid(product)) {
					person.setOrderList(new Order(product));
					System.out.println(person.getOrderList().get(person.getOrderList().size() - 1).getProductName() + " 구매 완료");
				} else {
					System.out.println("구매 실패!");
				}
				break;
			case "3":
				printProduct();
				System.out.println("장바구니에 추가 할 상품 번호를 입력하세요 : ");
				int productNum = Integer.parseInt(br.readLine());
				if (productNum > productList.size()) {
					System.out.println("등록 실패!");
				} else {
					person.setBasket(findProduct(productNum));
					System.out.println("====================================");
					System.out.println(person.getBasket().getBasket().get(person.getBasket().getBasket().size() - 1).getName()
							+ " 장바구니 등록 완료");
				}
				System.out.println("====================================");
				break;
			case "4":
				person.printBasketList();
				System.out.println("장바구니에서 삭제 할 상품 번호를 입력하세요 : ");
				int idx = Integer.parseInt(br.readLine());
				if (idx > person.getBasket().getBasket().size()) {
					System.out.println("삭제 실패!");
				} else {
					System.out.println(person.getBasket().getBasket().get(idx - 1).getName() + " 삭제 완료");
					person.deleteBasketList(idx);
				}
				break;
			case "5":
				person.printBasketList();
				break;
			case "6":
				person.printOrderList();
				break;
			case "7":
				System.out.println("수정 할 목록 번호를 입력해주세요");
				System.out.println("1.이름 2.주소");
				int updateNum = Integer.parseInt(br.readLine());
				if (updateNum > 2) {
					System.out.println("수정 실패!");
				} else {
					System.out.println("수정 할 내용을 입력해주세요");
					String content = br.readLine();
					switch (updateNum) {
					case 1:
						person.setName(content);
						break;
					case 2:
						person.setAddress(content);
						break;
					}
				}
				break;
			case "8":
				System.out.println("====================================");
				System.out.println(deletePerson(person) + "님 회원 탈퇴 완료");
				System.out.println("====================================");
				return;
			case "9":
				System.out.println("====================================");
				System.out.println("로그아웃");
				System.out.println("====================================");
				return;
			}

		}
	}

	private boolean containsCategory(String category) {
		Category[] arr = Category.values();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].toString().equals(category)) {
				return true;
			}
		}
		return false;
	}

	public boolean productValid(String productName) {
		for (int i = 0; i < productList.size(); i++) {
			if (productName.equals(productList.get(i).getName()))
				return true;
		}
		return false;
	}

	public void adminStart() throws IOException {
		while (true) {
			System.out.println("1.상품 등록 2.상품 전체 조회 3.상품 삭제 4.고객 정보 조회 5.로그아웃");
			String num = br.readLine();
			switch (num) {
			case "1":
				System.out.println("추가 할 상품의 카테고리를 입력해주세요 : ");
				printCategory();
				String category = br.readLine();
				System.out.println("추가 할 상품 이름을 입력해주세요 : ");
				String productName = br.readLine();
				System.out.println("상품의 가격을 입력해주세요 : ");
				int price = Integer.parseInt(br.readLine());
				productList.add(new Product(productName, price, Category.valueOf(category)));
				System.out.println("상품 추가 완료");
				break;
			case "2":
				printProduct();
				break;
			case "3":
				printProduct();
				System.out.println("삭제 할 상품의 번호를 입력해주세요");
				int idx = Integer.parseInt(br.readLine());
				if (idx > productList.size()) {
					System.out.println("삭제 실패!");
				} else {
					System.out.println("====================================");
					System.out.println(productList.get(idx - 1).getName() + "삭제 완료");
					productList.remove(idx - 1);
					System.out.println("====================================");
				}
				break;
			case "4":
				printPersonList();
				break;
			case "5":
				System.out.println("====================================");
				System.out.println("로그아웃");
				System.out.println("====================================");
				return;
			}
		}
	}

	public String deletePerson(Person p) {
		for (int i = 0; i < personList.size(); i++) {
			if (p.getName().equals(personList.get(i).getName())) {
				personList.remove(i);
				return p.getName();
			}
		}
		return "";
	}

	public void printPersonList() {
		System.out.println("====================================");
		if (personList.size() == 1) {
			System.out.println("유저가 없습니다");
		} else {
			System.out.println("번호\t이름\t주소");
			for (int i = 1; i < personList.size(); i++) {
				System.out.println(i + "\t" + personList.get(i).getName() + "\t" + personList.get(i).getAddress());
			}
		}
		System.out.println("====================================");
	}

	public Product findProduct(int idx) {
		return productList.get(idx - 1);
	}

	public void signUp() throws IOException {
		System.out.print("이름을 입력해주세요 : ");
		String name = br.readLine();
		System.out.print("주소를 입력해주세요 : ");
		String address = br.readLine();
		personList.add(new Person(name, address));
		System.out.println("====================================");
		System.out.println(personList.get(personList.size() - 1).getName() + "님 회원가입 완료");
		System.out.println("====================================");
	}

	public Person signIn() throws IOException {
		System.out.print("이름을 입력해주세요 : ");
		String name = br.readLine();
		if (findForPersonList(name)) {
			System.out.println("====================================");
			System.out.println(person.getName() + "로그인 완");
			System.out.println("====================================");
			return person;
		} else {
			System.out.println("====================================");
			System.out.println("로그인 실패!");
			System.out.println("====================================");
			return new Person();
		}
	}

	public boolean findForPersonList(String name) {
		boolean flag = false;
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getName().equals(name)) {
				person = personList.get(i);
				return true;
			}
		}
		return false;
	}

	public void insertProduct() throws IOException {
		System.out.println("상품 카테고리를 입력하세요");
		printCategory();
		Category category = Category.valueOf(br.readLine());
		System.out.println("상품 이름을 입력하세요");
		String productName = br.readLine();
		System.out.println("상품 가격을 입력하세요");
		int price = Integer.parseInt(br.readLine());
		productList.add(new Product(productName, price, category));
		System.out.println("상품 등록 완료");
		System.out.println("====================================");
		printProduct();
	}

	public void printProduct() {
		System.out.println("====================================");
		System.out.println("번호\t카테고리\t상품이름\t가격");
		System.out.println("====================================");
		for (int i = 0; i < productList.size(); i++) {
			System.out.println((i + 1) + "\t" + productList.get(i).getCategory() + "\t" + productList.get(i).getName()
					+ "\t" + +productList.get(i).getPrice());
		}
		System.out.println("====================================");
	}

	public void printProduct(String category) {
		int num = 1;
		System.out.println("====================================");
		System.out.println("번호\t상품이름\t가격");
		System.out.println("====================================");
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getCategory() == Category.valueOf(category)) {
				System.out.println(num + "\t" + productList.get(i).getName() + "\t" + productList.get(i).getPrice());
				num++;
			}
		}
		System.out.println("====================================");
	}

	public void printCategory() {
		Category[] arr = Category.values();
		System.out.println("================");
		System.out.println("번호\t카테고리");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "\t" + arr[i]);
		}
		System.out.println("================");
	}

}
