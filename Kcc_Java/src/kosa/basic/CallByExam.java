package kosa.basic;

public class CallByExam {

	public static int change(int num) { // callbyvalue
		num += 10;
		return num;
	}

	public static void change2(int arr[]) {// callbyreference
		arr[0] = 200;
		// return할 필요가 없다
	}

	public static void main(String[] args) {
//		int num = 10;
//		num = change(num);
//		System.out.println(num);

//		int arr[] = { 100 };
//		change2(arr);
//		System.out.println(arr[0]);

		int arr[] = { 1, 2, 3 };
		int brr[] = arr;
		brr[0] = 100;
		System.out.println(arr[0]);
	}
}