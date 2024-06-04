package kosa.api;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("홍길동", 20);
		
		if(p1.equals(p2)) { // Object의 equals를 사용하기 때문에 다르다
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		// System.out.println는 객체를 넣으면 기본적으로 toString()을 호출함.
		System.out.println(p1); //kosa.api.Person@5aaa6d82
		 
	}
}
