package cs284;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private String name, type,grade, email;
	
	

	private boolean status;
	String code;
	private double totalPoint;
	private  ArrayList<Double> listOfScore = new ArrayList<>();
	
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
	public double getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(double ttScore) {
		this.totalPoint = ttScore;
	}
	
	
	public String getGrade() {
		return grade;
	}
	
	
	
	//method for list of score
	public boolean add(Double e) {
		return listOfScore.add(e);
	}

	public ArrayList<Double> getListOfScore() {
		return listOfScore;
	}

	public void add(int index, Double element) {
		listOfScore.add(index, element);
	}

	public void clear() {
		listOfScore.clear();
	}

	public Double get(int index) {
		return listOfScore.get(index);
	}

	public Double set(int index, Double element) {
		return listOfScore.set(index, element);
	}

	public int size() {
		return listOfScore.size();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}