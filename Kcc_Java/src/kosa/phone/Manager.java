package kosa.phone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//전화번호 관리와 관련된 전반적인 기능
public class Manager {
	private List<PhoneInfo> list = new LinkedList<>();
	Scanner sc = DataInput.getInstance();

	public Manager() {

	}

	public void addPhoneInfo() {
		// 키보드로부터 이름, 전화번호, 생년월일을 입력받아
		// PhoneInfo객체를 생성해서 배열에 추가하는 것
		System.out.println("1.일반 2.회사 3.동창");
		String type = sc.nextLine();
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("전화번호 : ");
		String phoneNo = sc.nextLine();
		System.out.println("생년월일 : ");
		String birth = sc.nextLine();

		switch (type) {
		case "1":
			list.add(new PhoneInfo(name, phoneNo, birth));
			break;
		case "2":
			System.out.println("부서 : ");
			String dept = sc.nextLine();
			System.out.println("직책 : ");
			String position = sc.nextLine();
			list.add(new Company(name, phoneNo, birth, dept, position));
			break;
		case "3":
			System.out.println("전공 : ");
			String major = sc.nextLine();
			System.out.println("학번 : ");
			String year = sc.nextLine();
			list.add(new Universe(name, phoneNo, birth, major, year));
			break;
		}
	}

	public void listPhoneInfo() {
		System.out.println("1.전체 2.일반 3.회사 4.동창");
		String type = sc.nextLine();
		switch (type) {
		case "1":
			printAllList();
			break;
		case "2":
			for (int i = 0; i < list.size(); i++) {
				if (!(list.get(i) instanceof Company) && !(list.get(i) instanceof Universe)) {
					list.get(i).show();
				}
			}
			break;
		case "3":
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof Company) {
					list.get(i).show();
				}
			}
			break;
		case "4":
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof Universe) {
					list.get(i).show();
				}
			}
			break;
		}
	}
	public void download() {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("PhoneInfo.ser"));
			oos.writeObject(list);
			System.out.println("저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void upload() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("PhoneInfo.ser"));
			list = (LinkedList<PhoneInfo>)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {			try {
				ois.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void printAllList() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("이름 : " + list.get(i).getName());
			System.out.println("전화번호 : " + list.get(i).getPhoneNo());
			System.out.println("생년월일 : " + list.get(i).getBirth());
		}
	}

	public void printAllList(int i) {
		System.out.println("이름 : " + list.get(i).getName());
		System.out.println("전화번호 : " + list.get(i).getPhoneNo());
		System.out.println("생년월일 : " + list.get(i).getBirth());
	}

	public void searchPhoneInfo(String name) {
		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).getName()).equals(name)) {
				printAllList(i);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("찾을 수 없음");
		}
	}

	public void updatePhoneInfo(String name, int num, String updateContent) {
		int buf = searchIndex(name);
		if (buf == -1) {
			return;
		}

		if (num == 1) {
			list.get(buf).setName(updateContent);
		} else if (num == 2) {
			list.get(buf).setPhoneNo(updateContent);
		} else if (num == 3) {
			list.get(buf).setBirth(updateContent);
		} else {
			System.out.println("실패");
		}
	}

	public void deletePhoneInfo(String name) {
		int buf = searchIndex(name);
		list.remove(buf);
	}

	public int searchIndex(String name) {
		boolean flag = false;
		int buf = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				buf = i;
				flag = true;
				break;
			}
		}
		if (flag == false) {
			System.out.println("이름을 찾을 수 없음");
			return -1;
		} else {
			return buf;
		}
	}

	public void sortList() {
		System.out.println("오름차순 1.이름순 2.전화번호순 3.생년월일순");
		System.out.println("내림차순 4.이름순 5.전화번호순 6.생년월일순");
		String num = sc.nextLine();
		switch (num) {
		case "1":
			Collections.sort(list);
			break;
		case "2":
			Collections.sort(list, new Comparator<PhoneInfo>() {
				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {

					return o1.getPhoneNo().compareTo(o2.getPhoneNo());
				}
			});
			break;
		case "3":
			Collections.sort(list, new Comparator<PhoneInfo>() {
				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					return Integer.compare(Integer.parseInt(o1.getBirth()), Integer.parseInt(o2.getBirth()));
				}
			});
			break;
		case "4":
			Collections.sort(list, new Comparator<PhoneInfo>() {
				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					return o2.getName().compareTo(o1.getName());
				}
			});
			break;
		case "5":
			Collections.sort(list, new Comparator<PhoneInfo>() {
				@Override
				public int compare(PhoneInfo o1, PhoneInfo o2) {
					return o2.getPhoneNo().compareTo(o1.getPhoneNo());
				}
			});
			break;
		case "6":
			Collections.sort(list, (o1, o2) -> Integer.compare(Integer.parseInt(o2.getBirth()), Integer.parseInt(o1.getBirth())));
			break;
		default:
			System.out.println("다시 입력");
		}
	}
}