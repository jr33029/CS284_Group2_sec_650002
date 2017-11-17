package cs284;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class testwritefile {

	
	BufferedWriter bw = null ;
	FileWriter fw = null;
	Student st1 = new Student("001", "moss", "esper");
	//klpkp
public testwritefile() throws IOException {
	// TODO Auto-generated constructor stub
	
	
	//f = new File("test.txt");
	
	String x; 
	x =String.format("%d %s %s \n", st1.getCode() , st1.getName(),st1.getLastname());

	fw = new FileWriter("test.txt");
	bw = new BufferedWriter(fw);
	//bw.write(x);bw.newLine();
	
	bw.write(x);

	//bw.append(x);
	//bw.append(x);
	bw.close();
	fw.close();
	
}	

	public static void main(String[] args) {
		try {
			testwritefile tf = new testwritefile();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
			
	
}
