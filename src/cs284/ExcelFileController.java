/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs284;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author pongz
 */
public class ExcelFileController {
    
    ExcelFileManager manager;
    JFileChooser chooser = new JFileChooser();
    
    File selectedFile;
    
    ArrayList<Student> StudentArray = new ArrayList<>();
    
    
    //If this method return true that means the file is read successfully.
    public boolean readExcelFile(JLabel selectFileLabel){
        
        
				try {
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setFileFilter(new FileNameExtensionFilter("Excel File (*.xls)", "xls"));
					int opt = chooser.showOpenDialog(null);
					/*
					 * while (opt == JFileChooser.CANCEL_OPTION || opt ==
					 * JFileChooser.ERROR_OPTION) {
					 * JOptionPane.showMessageDialog(null,
					 * "Please Select file"); opt =
					 * chooser.showOpenDialog(null); }
					 */
					String fName = chooser.getSelectedFile().getPath();
					selectedFile = new File(fName);
					selectFileLabel.setText("File Name: " + selectedFile.getName());
					System.out.println("j");
					Workbook workbook = Workbook.getWorkbook(new java.io.File(fName));
					Sheet ws1 = workbook.getSheet(0);
					int numOfColumn = ws1.getColumns();
					int numOfRow = ws1.getRows();
                                        String pattern = "[0-9]{10}";
					for (int i = 7; i < numOfRow-1; i++) {
                                         if( !ws1.getCell(1, i).getContents().matches(pattern)){
                                             throw new NumberFormatException();
                                         }
                                            
						StudentArray.add(new Student(ws1.getCell(1, i).getContents(), ws1.getCell(2, i).getContents(),
								ws1.getCell(3, i).getContents()));
						System.out.println();
					}
					workbook.close();
					System.out.println("Read Sucess");
                                        JOptionPane.showMessageDialog(null, "Read Sucess");
                                        return true;
                                    
				} catch (HeadlessException | IOException | IndexOutOfBoundsException | BiffException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}catch(NumberFormatException ex){
                                    selectFileLabel.setText("No File");
                                    JOptionPane.showMessageDialog(null, "Wrong format File");
                                    
                                    
                                }
                                
                                
                                
                  return false;
    }
    
    public void setFileLabel(){
        
    }

    public ArrayList<Student> getStudentArray() {
        return StudentArray;
    }
    
    
}