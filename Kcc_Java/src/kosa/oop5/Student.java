package kosa.oop5;

public class Student extends Man {

	public Student() {
	}

	public Student(String name) {
		super(name);
	}

	public String speak() {
		return super.getName() + " 공부나 열심히해";
	}

}
