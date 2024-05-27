package kosa.mission;

import java.util.Scanner;

public class Galaga {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0;
		int b = 0;
		for(int i = 0; i < n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(a == b) {
				System.out.println("#" + (i+1) + " " + 1);
			}else {
				int count = 0;
				while(a > b) {
					a *= 2;
					b *= 3;
					count++;
				}
				System.out.println("#" + (i+1) + " " + count);
			}
		}
	}

}
