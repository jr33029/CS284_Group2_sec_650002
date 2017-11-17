package cs284;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;

public class Reader {
	
	

	public void ReadFile() {
		JFileChooser chooser = new JFileChooser();

		try {
			System.out.println("kliii");
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setFileFilter(new FileNameExtensionFilter("Excel 97-2003 Workbook (*.xls)", "xls"));

			int opt = chooser.showOpenDialog(null);

			if (opt == JFileChooser.CANCEL_OPTION) {

			}

			// chooser.showSaveDialog(null);

			String fName = chooser.getSelectedFile().getPath();
			System.out.println(fName);
			Workbook workbook = Workbook.getWorkbook(new File(fName));

			Sheet ws1 = workbook.getSheet(0);

			int numOfColumn = ws1.getColumns();
			int numOfRow = ws1.getRows();

			for (int i = 0; i < numOfRow; i++) {
				for (int j = 0; j < numOfColumn; j++) {
					// getCell(column, row)
					System.out.print(ws1.getCell(j, i).getContents() + " ");
				}
				System.out.println();
			}

			workbook.close();
			System.out.println("Read Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
