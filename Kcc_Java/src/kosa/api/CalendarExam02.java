package kosa.api;

import java.util.Calendar;

public class CalendarExam02 {

	public static void main(String[] args) {
		//2024 6월 달력 만들기
		//<2024년 6월>
		//일 월 화 수 목 금 토
		//           1
		//2 3 4 5 6 7 8
		
		Calendar gc = Calendar.getInstance();
//		int n = gc.getActualMaximum(Calendar.DATE);			
//		int year = gc.get(Calendar.YEAR);
//		int month = gc.get(Calendar.MONTH);
//		System.out.println("<" + year + "년" + (month+1) + "월>");
//		System.out.println("일\t월\t화\t수\t목\t금\t토");		
//		
//		int j = 0;
//		for(int i = 1; i <= n;) {
//			gc.set(year, month, i);
//			n = gc.getActualMaximum(Calendar.DATE);
//			int date = gc.get(Calendar.DAY_OF_WEEK);
//			for(j = 1; j < date; j++) {
//				System.out.print("\t");
//			}
//			for(;j <= 7; j++) {
//				System.out.print(i++ + "\t");
//				if(i > n) break;
//			}
//			System.out.println();
//			j = 0;
//		}
		int n = gc.getActualMaximum(Calendar.DATE);
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH);
		gc.set(year,month,1);
		int week = gc.get(Calendar.DAY_OF_WEEK);
		System.out.println("<" + year + "년" + (month+1) + "월>");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		for(int i = 1; i <= n; i++) {
			System.out.print(i + "\t");
			if(((week + i - 1) % 7) == 0) {
				System.out.println();
			}
		}
	}

}
