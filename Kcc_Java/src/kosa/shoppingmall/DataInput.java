package kosa.shoppingmall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DataInput {

	private static BufferedReader br;

	public DataInput() {
	}

	public static BufferedReader getInstance() {
		if (br == null) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		return br;
	}
}
