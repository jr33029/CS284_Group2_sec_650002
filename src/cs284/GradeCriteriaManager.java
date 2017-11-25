package cs284;

import java.util.ArrayList;

public class GradeCriteriaManager {

	StdDiv stdDivMng;
	
	
	ArrayList<Student> studentList;
	ArrayList<Double>	totalScoreList;
	public GradeCriteriaManager() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GradeCriteriaManager(ArrayList<Student> studentList) {
		// TODO Auto-generated constructor stub
		this.studentList = studentList;
		totalScoreList = new ArrayList<>();
		for (Student student : studentList) {
			totalScoreList.add(student.getTotalPoint());
		}
		
		
		stdDivMng = new StdDiv(totalScoreList);  
		
	}
	
	public void  gradeRealize() {
		
		for (Student student : studentList) {
			if(student.getTotalPoint() >= stdDivMng.getMean() && student.getTotalPoint() < stdDivMng.getMean()+ stdDivMng.getDiv()/2.0) {
				student.setGrade("C+");
			}else if(student.getTotalPoint() >= stdDivMng.getMean()+ stdDivMng.getDiv()/2.0 && student.getTotalPoint() < stdDivMng.getMean()+ stdDivMng.getDiv()) {
				student.setGrade("B");
			}else if(student.getTotalPoint() >= stdDivMng.getMean()+ stdDivMng.getDiv() && student.getTotalPoint() < stdDivMng.getMean()+ stdDivMng.getDiv()*1.5) {
				student.setGrade("B+");
			}else if(student.getTotalPoint() >= stdDivMng.getMean()+ stdDivMng.getDiv()*1.5 ) {
				student.setGrade("A");
			}else if(student.getTotalPoint() >= stdDivMng.getMean()- stdDivMng.getDiv()/2.0 && student.getTotalPoint() < stdDivMng.getMean()) {
				student.setGrade("C");
				
			}else if(student.getTotalPoint() >= stdDivMng.getMean()- stdDivMng.getDiv() && student.getTotalPoint() < stdDivMng.getMean()- stdDivMng.getDiv()/2.0) {
				student.setGrade("D+");
				
			}else if(student.getTotalPoint() >= stdDivMng.getMean()- stdDivMng.getDiv()*1.5 && student.getTotalPoint() < stdDivMng.getMean()- stdDivMng.getDiv()) {
				student.setGrade("D");
				
			}else {
				student.setGrade("F");
			}
		}
		
	}
}
