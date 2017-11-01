package cs284;

public class Student {
	private String name, lastname,grade;
	private boolean status;
	private int code, rawPoint, totalPoint;
	public Student(int code,String name,String lastname) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.lastname = lastname;
		status = true;
		rawPoint = 0;
		totalPoint = 0;
	}
	public Student(int code,String name,String lastname,int rawPoint,int totalPoint,boolean status) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.lastname = lastname;
		this.status = status;
		this.rawPoint = 0;
		this.totalPoint = 0;
	}
	public Student(int code,String name,String lastname,int rawPoint,int totalPoint,boolean status,String grade) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.lastname = lastname;
		this.status = status;
		this.rawPoint = 0;
		this.totalPoint = 0;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCode() {
		return code;
	}
	public int getRawPoint() {
		return rawPoint;
	}
	public void setRawPoint(int rawPoint) {
		this.rawPoint = rawPoint;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	
}