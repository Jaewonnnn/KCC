package kosa.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExam {

	public static void main(String[] args) {
//		GregorianCalendar gc = new GregorianCalendar();
		Calendar gc =  Calendar.getInstance();
//		System.out.println(gc);
		
		String now = gc.get(Calendar.YEAR) + "년 " 
		+ (gc.get(Calendar.MONTH) + 1) + "월 "
		+ gc.get(Calendar.DATE) + "일 "
		+ gc.get(Calendar.HOUR) + "시 "
		+ gc.get(Calendar.MINUTE) + "분";
		
		System.out.println("현재시간 : " + now);
		
		gc.add(Calendar.DATE, 100);
		String future = gc.get(Calendar.YEAR) + "년 " 
				+ (gc.get(Calendar.MONTH) + 1) + "월 "
				+ gc.get(Calendar.DATE) + "일 "
				+ gc.get(Calendar.HOUR) + "시 "
				+ gc.get(Calendar.MINUTE) + "분";
				
		System.out.println("100일 후 : " + future);
		
		gc.set(2022, 5, 4);
		gc.add(Calendar.DATE, 1000);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str = sdf.format(gc.getTime());
		
		System.out.println(str);
		
		// 2024 ~ 2030년까지 자신의 생일이 무슨 요일?
		// Calendar.DAY_OF_WEEK => 요일(일1 월2 화3 수4 목5 금6 토7 일8)
		char week[] = {'일','월','화','수','목','금','토','일'};
		for(int i = 2024; i <= 2030; i++) {
			gc.set(i, 6, 10); //(년도, 월-1, 일)
			int day = gc.get(Calendar.DAY_OF_WEEK);
			System.out.println(i +"년 : "+ week[day-1]);
		}
	}
}
