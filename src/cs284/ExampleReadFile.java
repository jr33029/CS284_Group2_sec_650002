package cs284;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.tools.JavaFileManager;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExampleReadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFileChooser chooser = new JFileChooser();
		
	
		try {
			
			
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			
			
			
			int opt = chooser.showOpenDialog(null);
			
			if(opt ==JFileChooser.CANCEL_OPTION){
				
			}
			
			//chooser.showSaveDialog(null);
			
			
			
			String fName = chooser.getSelectedFile().getPath();
			System.out.println(fName);
			Workbook workbook = Workbook.getWorkbook(new File(fName));
			
			
			Sheet ws1 = workbook.getSheet(0);
			
			int numOfColumn = ws1.getColumns();
			int numOfRow = ws1.getRows();
			
			for (int i = 0; i < numOfRow; i++) {
				for (int j = 0; j < numOfColumn; j++) {
					System.out.print(ws1.getCell(j, i).getContents()+" ");
				}
				System.out.println();
			}
			
			workbook.close();
			System.out.println("Read Sucess");
			//ws1.addCell(new Label(0,0,"kuy"));
			//ws1.addCell(new Label(0,1,"pong"));
			
			
			//workbook.write();
			//System.out.println(ws1.getCell(0, 0).getContents());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
