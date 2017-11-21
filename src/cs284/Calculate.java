package cs284;

import java.util.ArrayList;

public class Calculate {
	StdDiv cal;

	public Calculate(ArrayList<Double> list) {
		// TODO Auto-generated constructor stub
		cal = new StdDiv(list);
	}

	public String getGrade(double point) {
		if (point < cal.getMean() - cal.getDiv() * 3) {
			return "F";
		} else if (point < cal.getMean() - cal.getDiv() * 2) {
			return "D";
		} else if (point < cal.getMean() - cal.getDiv()) {
			return "D+";
		} else if (point < cal.getMean()) {
			return "C";
		} else if (point > cal.getMean()) {
			return "C+";
		} else if (point > cal.getMean() + cal.getDiv() * 2) {
			return "B";
		} else if (point > cal.getMean() + cal.getDiv() * 3) {
			return "B+";
		} else {
			return "A";
		}
	}
}
