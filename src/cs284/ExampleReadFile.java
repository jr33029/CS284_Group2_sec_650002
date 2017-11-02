package cs284;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.tools.JavaFileManager;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExampleReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFileChooser chooser = new JFileChooser();
		
		System.out.println("hjk");
		try {
			
			
			chooser.getSelectedFile();
			chooser.showOpenDialog(null);
			
			//chooser.showSaveDialog(null);
			
			String fName = "C:\\java\\myExcel.xls";
			WritableWorkbook workbook = Workbook.createWorkbook(chooser.getSelectedFile());
		
			WritableSheet ws1 = workbook.createSheet("mySheet1", 0);
			
			ws1.addCell(new Label(0,0,"kuy"));
			ws1.addCell(new Label(0,1,"หยอย"));
			
			
			workbook.write();
			System.out.println(ws1.getCell(0, 0).getContents());
			workbook.close();
			
			System.out.println("Write Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
