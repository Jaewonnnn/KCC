package kosa.shoppingmall;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingMall {
	private List<Product> productList;
	private List<Person> personList;
	private BufferedReader br = DataInput.getInstance();
	private Person p;

	public ShoppingMall() {
		productList = new ArrayList<Product>();
		personList = new ArrayList<Person>();
		personList.add(new Person("admin"));
		productList.add(new Product("nike1", 100000, Category.valueOf("OUTER")));
		productList.add(new Product("nike2", 100000, Category.valueOf("PANTS")));
		productList.add(new Product("nike3", 100000, Category.valueOf("DRESS")));
		productList.add(new Product("nike4", 100000, Category.valueOf("SHOES")));
		productList.add(new Product("nike5", 100000, Category.valueOf("BAG")));
	}

	public void userStart() throws IOException {
		while (true) {
			System.out.println("1.상품 보기 2.상품 주문하기 3.장바구니 추가하기 4.장바구니 삭제하기 5.장바구니 보기");
			System.out.println("6.구매 기록 보기 7.회원 정보 수정 8.회원 탈퇴");
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
					p.setOrderList(new Order(product));
					System.out.println(p.getOrderList().get(p.getOrderList().size() - 1).getProductName() + " 구매 완료");
				} else {
					System.out.println("구매 실패!");
				}
				break;
			case "3":
				System.out.println("장바구니에 추가 할 상품 번호를 입력하세요 : ");
				printProduct();
				int productNum = Integer.parseInt(br.readLine());
				if (productNum > productList.size()) {
					System.out.println("등록 실패!");
				} else {
					p.setBasket(findProduct(productNum));
					System.out.println(p.getBasket().getBasket().get(p.getBasket().getBasket().size() - 1).getName()
							+ " 장바구니 등록 완료");
				}
				break;
			case "4":
				System.out.println("장바구니에서 삭제 할 상품 번호를 입력하세요 : ");
				printBasketList();
				int idx = Integer.parseInt(br.readLine());
				if (idx > productList.size()) {
					System.out.println("삭제 실패!");
				} else {
					System.out.println(p.getBasket().getBasket().get(idx - 1).getName() + " 삭제 완료");
					p.deleteBasketList(idx);
				}
				break;
			case "5":
				printBasketList();
				break;
			case "6":
				printOrderList();
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
						p.setName(content);
						break;
					case 2:
						p.setAddress(content);
						break;
					}
				}
				break;
			case "8":
				System.out.println(deletePerson(p) + "님 회원 탈퇴 완료");
				System.out.println("프로그램 종료");
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
			System.out.println("1.상품 등록 2.상품 전체 조회 3.상품 삭제 4.종료");
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
				System.out.println("삭제 할 상품의 번호를 입력해주세요");
				printProduct();
				int idx = Integer.parseInt(br.readLine());
				if (idx > productList.size()) {
					System.out.println("삭제 실패!");
				} else {
					productList.remove(idx - 1);
				}
				break;
			case "4":
				System.out.println("프로그램 종료");
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

	public void printOrderList() {
		System.out.println("====================================");
		if (p.getOrderList().size() == 0) {
			System.out.println("구매 목록이 비어있습니다.");
		} else {
			System.out.println("번호\t주문번호\t\t상품명");
			System.out.println("====================================");
			for (int i = 0; i < p.getOrderList().size(); i++) {
				System.out.println((i + 1) + "\t" + p.getOrderList().get(i).getOrderNumber() + "\t"
						+ p.getOrderList().get(i).getProductName());
			}
		}
		System.out.println("====================================");
	}

	public Product findProduct(int idx) {
		return productList.get(idx - 1);
	}

	public void printBasketList() {
		if (p.getBasket().getBasket().size() == 0) {
			System.out.println("장바구니가 비어있습니다.");
		} else {
			System.out.println("====================================");
			System.out.println("번호\t카테고리\t상품이름\t가격");
			System.out.println("====================================");
			for (int i = 0; i < p.getBasket().getBasket().size(); i++) {
				System.out.println((i + 1) + "\t" + p.getBasket().getBasket().get(i).getCategory() + "t"
						+ p.getBasket().getBasket().get(i).getName() + "\t"
						+ p.getBasket().getBasket().get(i).getPrice());
			}
			System.out.println("====================================");
		}
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

	public void signUp() throws IOException {
		System.out.print("이름을 입력해주세요 : ");
		String name = br.readLine();
		System.out.print("주소를 입력해주세요 : ");
		String address = br.readLine();
		personList.add(new Person(name, address));
		System.out.println(personList.get(personList.size() - 1).getName() + "님 회원가입 완료");
		System.out.println("====================================");
	}

	public Person signIn() throws IOException {
		System.out.print("이름을 입력해주세요 : ");
		String name = br.readLine();
		findIndex(name);
		System.out.println(p.getName() + "님 환영합니다");
		System.out.println("====================================");
		return p;
	}

	public void findIndex(String name) {
		for (int i = 0; i < personList.size(); i++) {
			if (personList.get(i).getName().equals(name)) {
				p = personList.get(i);
			}
		}
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
