package kosa.basic;

public class VariableExam {

	public static void main(String[] args) {
		// ������ �����͸� ��� �׸� ex) ȫ�浿 100, 3.14, true
		// byte, short, int, long, float, double, boolean, char
		int num; // ���� ���� : �޸� �Ҵ� primitive type
		int arr[]; // �迭 ���� : Object Type
		
		num = 10;
		System.out.println(num); // ���������� �ݵ�� �ʱ�ȭ�� ����� �Ѵ�.
		
		int num2 = 100; // ���� ���� �� �ʱ�ȭ
		
		String name = "ȫ�浿";
		System.out.println(name + "��");
		
		// �������� ���ǻ���
		// ������ : Ư������X, ���ڷ� ���� X, �ҹ��� ����, _����
		
		// �⺻ ���ͷ� : 100 => int, "" => String, '' => char, true => boolean, 3.14 => double �� �ڵ����� ������ Ÿ���� ������ �ִ�.
		float a = 3.14f;
		
		// casting (����ȯ)
		// ���� : byte < short < int < long < float < double ���� �Ϳ��� ū ������ ĳ���� ���� / int <=> char �ƽ�Ű�ڵ� ������ ĳ���� ����
		double b = 100; // �⺻���ͷ��� int���ε� double�� ĳ���� ���� // �Ϲ��� ����ȯ
		int c = (int)3.14; // ���� ����ȯ �ʿ� (�Ҽ��� �߸�), �������� �ս��� �߻���
		
		System.out.println(c);
		
		float num3 = 3.14f;
		long num4 = 100l;
		
		int num5 = 010; // 8������ �� 
		System.out.println(num5);
	}

}
