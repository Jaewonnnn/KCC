package kosa.shoppingmall;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private String address;
	private List<Order> orderList;
	private Basket basket;
	private Role role;

	public Person() {
	}

	public Person(String name) {

		this.name = name;
		this.role = Role.ADMIN;

	}

	public Person(String name, String address) {
		this.name = name;
		this.address = address;
		orderList = new ArrayList<Order>();
		basket = new Basket();
		this.role = Role.USER;
	}
	public void deleteBasketList(int idx) {
		basket.getBasket().remove(idx-1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Order order) {
		orderList.add(order);
	}


	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Product p) {
		basket.setBasket(p);
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

}