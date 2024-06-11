package kosa.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
	Member m;

	// 객체 직렬화
	public void insert() {
		m = new Member("홍길동", 20, new Video(1, "서울의봄", "정우성"));
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object.ser"));
			oos.writeObject(m);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 객체 역직렬화
	public void show() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("object.ser"));
			m = (Member) ois.readObject(); // Object타입 반환하기 때문에 캐스팅 필요함
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.insert();
		main.m = null;

		main.show();

		System.out.println(main.m);
	}

}
