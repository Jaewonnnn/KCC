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
	
}