package cs284;

import java.util.ArrayList;

public class StdDiv {
	double max = 0;
	double std = 0;
	double size = 0;
	public StdDiv(ArrayList<Double> list) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < list.size(); i++) {
			max += list.get(i);
		}
		for (int i = 0; i < list.size(); i++) {
			std += list.get(i) - (max / list.size());
		}
		size = list.size();
		std = std * std;
		std = std / (list.size() - 1);
		std = Math.sqrt(std);
	}

	public double getDiv() {
		return std;
	}
	
	public double getMean(){
		return max/size;
	}
	
	public double getMax(ArrayList<Double> list){
		double most = 0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)>most){
				most = list.get(i);
			}
		}
		return most;
	}
	
	public double getMin(ArrayList<Double> list){
		double less = 0;
		less = getMax(list);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)<less){
				less = list.get(i);
			}
		}
		return less;
	}
	
	public double getRange(ArrayList<Double> list){
		double Range = 0;
		Range = getMax(list) - getMin(list);
		return Range;
	}
}
