package cs284;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExampleReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("hjk");
		try {
			String fName = "C:\\java\\myExcel.xls";
			WritableWorkbook workbook = Workbook.createWorkbook(new File(fName));
			
			WritableSheet ws1 = workbook.createSheet("mySheet1", 0);
			ws1.addCell(new Label(0,0,"หัวหมอย"));
			ws1.addCell(new Label(0,1,"หยอย"));
			
			
			workbook.write();
			workbook.close();
			
			System.out.println("Write Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
