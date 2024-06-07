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
		personList.add(new Person("관리자"));		
		productList.add(new Product("nike",100000,Category.valueOf("OUTER")));
		productList.add(new Product("nike",100000,Category.valueOf("PANTS")));
		productList.add(new Product("nike",100000,Category.valueOf("DRESS")));
		productList.add(new Product("nike",100000,Category.valueOf("SHOES")));
		productList.add(new Product("nike",100000,Category.valueOf("BAG")));
	}
	
	public void userStart() throws IOException {
		while(true) {
			System.out.println("1.상품 보기 2.상품 주문하기 3.장바구니 추가하기 4.장바구니 삭제하기 5.장바구니 보기");
			System.out.println("6.구매 기록 보기");
			String num = br.readLine();
			switch(num) {
			case "1":
				printCategory();
				System.out.print("카테고리를 입력해주세요 : ");
				String category = br.readLine();
				printProduct(category);
				break;
			case "2":
				System.out.print("구매 할 상품을 입력하세요 : ");
				String product = br.readLine();
				p.setOrderList(new Order(product));
				System.out.println(p.getOrderList().get(p.getOrderList().size()-1).getProductName() +  " 구매 완료");
				break;
			case "3":
				System.out.println("장바구니에 추가 할 상품 번호를 입력하세요 : ");
				p.setBasket(findProduct(Integer.parseInt(br.readLine())));
				System.out.println(p.getBasket().getBasket().get(p.getBasket().getBasket().size()-1).getName() + " 장바구니 등록 완료");
				break;
			case "4":
				System.out.println("장바구니에서 삭제 할 상품 번호를 입력하세요 : ");
				printBasketList();
				int idx = Integer.parseInt(br.readLine());
				System.out.println(p.getBasket().getBasket().get(idx-1).getName() + " 삭제 완료");
				p.deleteBasketList(idx);
				break;
			case "5":
				printBasketList();
				break;
			case "6":
				printOrderList();
				break;
			}
		}
	}
	public void printOrderList() {
		for(int i = 0; i < p.getOrderList().size(); i++) {
			System.out.println((i+1) + " : " + p.getOrderList().get(i).getProductName());
		}
	}
	public Product findProduct(int idx) {
		return productList.get(idx-1);
	}
	public void printBasketList() {
		for(int i = 0; i < p.getBasket().getBasket().size(); i++) {
			System.out.println((i + 1) + " : " + p.getBasket().getBasket().get(i).getName());
		}
	}
	public void printProduct(String category) {
		int num = 1;
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).getCategory() == Category.valueOf(category)) {
				System.out.println(num + " : " + productList.get(i).getName());
				num++;
			}
		}
	}
	public void adminStart() {
		
	}
	
	public void signUp() throws IOException {
		System.out.println("이름을 입력해주세요 : ");
		String name = br.readLine();
		System.out.println("주소를 입력해주세요 : ");
		String address = br.readLine();
		personList.add(new Person(name, address));
		System.out.println(personList.get(personList.size()-1).getName() + "님 회원가입 완료");
		System.out.println("=================");
	}
	public Person signIn() throws IOException{
		System.out.println("이름을 입력해주세요 : ");
		String name = br.readLine();
		findIndex(name);
		System.out.println(p.getName()+"님 환영합니다");
		System.out.println("=================");
		return p;
	}
	public void findIndex(String name) {
		for(int i = 0; i < personList.size(); i++) {
			if(personList.get(i).getName().equals(name)) {
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
		System.out.println("=================");
		printProduct();
	}
	public void printProduct() {
		for(int i = 0; i < productList.size(); i++) {
			System.out.println((i+1) + ". 카테고리 이름 : " + productList.get(i).getCategory() + " 상품 이름 : " + productList.get(i).getName() + " 가격 : " + productList.get(i).getPrice());
			
		}
	}
	
	public void printCategory() {
		Category[] arr = Category.values();
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
