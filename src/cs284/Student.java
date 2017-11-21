package cs284;

public class Student {
	
	private String name, type,grade;
	private boolean status;
	String code;
	private int totalPoint;
	
	public Student(String code,String name) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.type = "N/A";
		status = true;
		totalPoint = 0;
	}

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCode(String code) {
        this.code = code;
    }
	
	
	public Student(String code,String name,String type) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.type = type;
		status = true;
		totalPoint = 0;
	}
	public Student(String code,String name,String type,int totalPoint,boolean status) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.type = type;
		this.status = status;
		this.totalPoint = 0;
	}
	public Student(String code,String name,String type,int totalPoint,boolean status,String grade) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.name = name;
		this.type = type;
		this.status = status;
		this.totalPoint = 0;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
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