package kosa.shoppingmall;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<Product> basket;

	public Basket() {
		basket = new ArrayList<Product>();
	}

	public List<Product> getBasket() {
		return basket;
	}

	public void setBasket(Product p) {
		basket.add(p);
	}

	public void printBasketList() {
		if (basket.size() == 0) {
			System.out.println("====================================");
			System.out.println("장바구니가 비어있습니다.");
		} else {
			System.out.println("====================================");
			System.out.println("번호\t카테고리\t상품이름\t가격");
			System.out.println("====================================");
			for (int i = 0; i < basket.size(); i++) {
				System.out.println((i + 1) + "\t" 
						+ basket.get(i).getCategory() + "\t"
						+ basket.get(i).getName() + "\t"
						+ basket.get(i).getPrice());
			}
		}
		System.out.println("====================================");
	}

}