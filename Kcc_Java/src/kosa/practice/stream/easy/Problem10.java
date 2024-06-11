package kosa.practice.stream.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import kosa.practice.stream.easy.resources.Customer;


public class Problem10 {

    /**
     * 주어진 Customer 객체 리스트를 나이(age)별로 그룹화하여 Map으로 반환합니다.
     *
     * @param customers Customer 객체 리스트
     * @return 나이별로 그룹화된 Map
     */
	public static void main(String[] args) {
		List<Customer> list = Arrays.asList(new Customer(1, "zz", 123), new Customer(2, "aa", 333), new Customer(3, "aa", 22));
		for(Entry<Integer, List<Customer>> i : groupCustomersByAge(list).entrySet()) {
			System.out.println(i.getKey());
			System.out.println(i.getValue());
		}
	}
    public static Map<Integer, List<Customer>> groupCustomersByAge(List<Customer> customers) {
        return customers.stream().collect(Collectors.groupingBy(Customer::getAge));
    }
}