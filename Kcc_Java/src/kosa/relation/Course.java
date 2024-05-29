package kosa.relation;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String subName;
	private List<Student> students;

	public Course() {

	}

	public Course(String subName) {
		this.subName = subName;
		students = new ArrayList<Student>();
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public void removeStudent(Student student) {
		students.remove(student);
	}

	public void printCourse() {
		System.out.println("과목명 : " + subName);
		for (Student student : students) {
			System.out.println("수강신청 학생명 : " + student.getName());
		}
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

}
