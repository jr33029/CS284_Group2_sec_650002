package cs284;

import java.util.ArrayList;
import java.util.Collections;

public class StdDiv {
	double max = 0;
	double min = 0;
	double std = 0;
	double size = 0;
	ArrayList<Double> list;
	
	public StdDiv(ArrayList<Double> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
		max = Collections.max(list).doubleValue();
		min = Collections.min(list).doubleValue();
		size = list.size();
		
	}

	public double getDiv() {
		double sum = 0;
		for (Double double1 : list) {
			sum += Math.pow(double1- getMean(), 2);
		}
		
		
		return Math.sqrt(sum/list.size());
	}
	
	public double getMean(){
		double sum = 0;
		for (Double double1 : list) {
			sum += double1.doubleValue();
		}
		
		return sum/size;
	}
	
	public double getSum() {
		double sum = 0;
		for (Double double1 : list) {
			sum += double1.doubleValue();
		}
		return sum;
	}
	
	public double getMax(){
		
		
		
		return max;
		
		
		
		
	}
	
	public double getMin(){
		
		return min;
	}
	
	public double getRange(ArrayList<Double> list){
		double Range = 0;
		Range = getMax() - getMin();
		return Range;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Double> testList = new ArrayList<>();
		testList.add(30.0);
		testList.add(20.0);
		testList.add(40.0);
		StdDiv test = new StdDiv(testList);
		
		System.out.println(testList);
		System.out.println(test.getMean());
		System.out.println(test.getDiv());
	}
}
