package kosa.bank;

import java.util.Arrays;

public class MyBank {
	private Customer[] customers;
	private int customersNum; // 고객 수
	
	public MyBank() {
		customers = new Customer[10];
	}
	
	public void addCustomer(String id, String name, long balance) {
		customers[customersNum++] = new Customer(id, name, balance);
	}

	public Customer getCustomer(String id) {
		for(int i = 0; i < customersNum; i++) {
			if(customers[i].getName().equals(id)) {
				return customers[i];
			}
		}
		return null;
	}
	public Customer[] getAllCustomers() {
		Customer[] arr = new Customer[customersNum];
		
//		for(int i = 0; i < customersNum; i++) {
//			arr[i] = customers[i];
//		}
		
//		System.arraycopy(customers, 0, arr, 0, customersNum);
		
		arr = Arrays.copyOf(customers, customersNum);
		return arr; 
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public int getCustomersNum() {
		return customersNum;
	}

	public void setCustomersNum(int customersNum) {
		this.customersNum = customersNum;
	}
}
