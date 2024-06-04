package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class DateMission {

	public static void main(String[] args) {
		// 키보드 => 날짜 입력 2014/06/04
		// 입사일을 입력받아 => 몇년 몇개월 재직 중
		Scanner sc = new Scanner(System.in);
		System.out.print("입사 년도 (YYYY) : ");
		String year = sc.nextLine();
		System.out.print("입사 월 (MM) : ");
		String month = sc.nextLine();
		System.out.print("입사 일 (DD) : ");
		String date = sc.nextLine();
		
		Calendar gc = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String[] arr = sdf.format(gc.getTime()).split("/");	
		System.out.println(sdf.format(gc.getTime()) + "기준");
		
		int a = (Integer.parseInt(arr[0]) - Integer.parseInt(year));
		int x = Integer.parseInt(arr[1]);
		int y = Integer.parseInt(month);
		int b = 0;
		if(x>=y) {
			b = x - y;
		}else {
			b = y - x;
			a--;
		}
		
		System.out.println(a + "년 " + b + "개월 재직중");
	}

}
