package kosa.data;

public class Order {
	private Food food;
	private static int amount;
	
	public Order() {}

	public Order(Food food) {
		this.food = food;
		this.amount += food.getPrice();
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
