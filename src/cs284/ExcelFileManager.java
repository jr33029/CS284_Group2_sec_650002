/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs284;

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author pongz
 */
public class ExcelFileManager {
   private File file;
   private Workbook workbook;
   private Sheet sheet;
    
    public ExcelFileManager(File file) throws IOException, BiffException{
        
        this.file = file;
        workbook = Workbook.getWorkbook(file);
        sheet = workbook.getSheet(0);
    }
    
    public ExcelFileManager(String filePath) throws IOException, BiffException{
        
        file = new File(filePath);
        workbook = Workbook.getWorkbook(file);
        sheet = workbook.getSheet(0);
    }
    
    
    public int getColumn(){
        
        return sheet.getColumns();
    }
    
    
    
    public int getRows(){
        
        return sheet.getRows();
    }
    
    
    public void readCellToText(){
        
    }
    
}
