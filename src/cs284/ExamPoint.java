package cs284;

public class ExamPoint {
	private String name;
	private int value;
	private int point;
	public ExamPoint(String name,int value,int point) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
		this.point = point;
	}
	public int getExamPoint(){
		int toTotal;
		toTotal = point*value/100;
		return toTotal;
	}
}
