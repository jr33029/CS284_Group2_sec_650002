package cs284;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {
	private ArrayList<Collect> grade = new ArrayList<>();

	public Calculate() {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner("Grader");
		while (sc.hasNext()) {
			String G = sc.next();
			grade.add(new Collect(G, sc.nextInt()));
		}
	}

	public String getGrade(int point) {
		if (point >= grade.get(0).getMin()) {
			return grade.get(0).getGRADE();
		} else if (point >= grade.get(1).getMin()) {
			return grade.get(1).getGRADE();
		} else if (point >= grade.get(2).getMin()) {
			return grade.get(2).getGRADE();
		} else if (point >= grade.get(3).getMin()) {
			return grade.get(3).getGRADE();
		} else if (point >= grade.get(4).getMin()) {
			return grade.get(4).getGRADE();
		} else if (point >= grade.get(5).getMin()) {
			return grade.get(5).getGRADE();
		} else if (point >= grade.get(6).getMin()) {
			return grade.get(6).getGRADE();
		} else if (point >= grade.get(7).getMin()) {
			return grade.get(7).getGRADE();
		} else {
			return "FALSE";
		}
	}

	public class Collect {
		private int min;
		private String GRADE;

		public Collect(String GRADE, int min) {
			// TODO Auto-generated constructor stub
			this.GRADE = GRADE;
			this.min = min;
		}

		public int getMin() {
			return min;
		}

		public String getGRADE() {
			return GRADE;
		}

	}
}
