package kosa.io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KosaWriter {

	public static void main(String[] args) throws IOException{
		// 키보드로부터 문자열을 입력 받아 파일에 쓰는 예제를 구현하자.
		// "q"를 입력하기 전까지 문자열을 파일에 쓰도록 하자.
		// FileWriter : write(문자열)
		// 파일명 : poem2.txt:미리 만들 필요 없다
		// 코드 실행 후 refresh해야 함. => 파일 생성 확인
		// close() 반드시 사용
		
		FileWriter writer = null;
		String str = "";
		Scanner sc = new Scanner(System.in);
		String poem = "";
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		try {
//			writer = new FileWriter("poem2.txt");
//			while(true) {
//				str = br.readLine();
//				if(str.equals("q"))break;
//				writer.write(str);
//				writer.write("\n");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			writer.close();
//		}
		while(!(str = sc.nextLine()).equals("q")) {
			poem += str;
			poem += "\n";
		}
		try {
			writer = new FileWriter("poem2.txt");
			writer.write(poem);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}

}
