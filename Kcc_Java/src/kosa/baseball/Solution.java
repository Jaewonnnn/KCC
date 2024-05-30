package kosa.baseball;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Integer> solution = new ArrayList<>();

	public Solution() {
		while(solution.size() < 3){
			int num = (int) ((Math.random() * 9)) + 1;
			if (!solution.contains(num)) {
				solution.add(num);
			}
		}
		System.out.print(solution.toString());
	}

	public String checkCount(int[] input) {
		int s = 0;
		int b = 0;
		xx: for (int i = 0; i < solution.size(); i++) {
			for (int j = 0; j < solution.size(); j++) {
				if (solution.get(i) == input[i]) {
					s++;
					continue xx;
				} else if (solution.get(i) == input[j]) {
					b++;
					continue xx;
				}
			}
		}

		if (s == 3) {
			return "3S";
		} else
			return "S" + s + "B" + b;
	}
}
