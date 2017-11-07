package cs284;

public class Student {
	private String name, lastname,grade;
	private boolean status;
	String code;
	private int totalPoint;
	public Student(String code,String name,String lastname) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.lastname = lastname;
		status = true;
		totalPoint = 0;
	}
	public Student(String code,String name,String lastname,int totalPoint,boolean status) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.lastname = lastname;
		this.status = status;
		this.totalPoint = 0;
	}
	public Student(String code,String name,String lastname,int totalPoint,boolean status,String grade) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.lastname = lastname;
		this.status = status;
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
	public String getCode() {
		return code;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	
}