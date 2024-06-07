package kosa.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

	public static void main(String[] args) {
		LinkedList<Order> order = new LinkedList<>();
		List<Food> foodList = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		foodList.add(new Food("1", 7000));
		foodList.add(new Food("2", 5000));
		foodList.add(new Food("3", 3000));

		String menu = "";
		while (true) {
			System.out.println("1.주문요청 2.주문처리 3.주문대기 4.매출액 5.종료");
			
			switch (sc.nextLine()) {
			case "1":
				System.out.println("메뉴이름 : ");
				menu = sc.nextLine();
				Food f = findFood(foodList, menu);
				if (f == null) {
					System.out.println("없는 메뉴");
					break;
				} else {
					order.offer(new Order(f));
				}
				break;
			case "2":
				if (order.isEmpty()) {
					System.out.println("주문 없음");
				} else {
					System.out.println(order.poll().getFood().getFoodName() + " 완성");
				}
				break;
			case "3":
				if (order.isEmpty()) {
					System.out.println("주문 없음");
				} else {
					for (int i = 0; i < order.size(); i++) {
						System.out.println((i + 1) + ". " + order.get(i).getFood().getFoodName() + "");
					}
				}
				break;
			case "4":
				System.out.println("현재 매출액 : " + new Order().getAmount());
				break;
			case "5":
				System.out.println("퇴근 축하");
				return;
			default:
				System.out.println("다시입력");
				break;
			}
		}
	}

	public static Food findFood(List<Food> list, String name) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFoodName().equals(name)) {
				return list.get(i);
			}
		}

		return null;
	}

}
