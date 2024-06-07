package kosa.shoppingmall;

public class Order {
	private int orderNumber;
	private String productName;
		
	public Order() {}
	
	public Order(String name) {
		orderNumber = (int)(Math.random() * 210000000) + 1;
		productName = name;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}
