package cs284;


public class ExamPoint {
	private String name;
	private int value;
	private int point;
	private int max;
	public ExamPoint(String name,int value,int point,int max) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.value = value;
		this.point = point;
		this.max = max;
	}
	public double getExamPoint(){
		double toTotal = 0 ;
		toTotal = (point*value)/max;
		return toTotal;
	}
}
