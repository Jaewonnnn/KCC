package kosa.phone;

import java.util.Scanner;

public class DataInput {
	private static Scanner sc = new Scanner(System.in);
	
	private DataInput() {
		
	}
	public static Scanner getInstance() {
		if(sc == null)
			sc = new Scanner(System.in);
		return sc;
	}
}
