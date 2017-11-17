package cs284;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Sheet;
import jxl.Workbook;

public class CourseFrame extends JFrame {
	private JButton course, addraw, netscore, grade;
	private JLabel head;
	private AllPanel panel;

	private Reader reader = new Reader();
	private JMenuBar mBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem item = new JMenuItem("Import Excel File");
	private BorderLayout bl = new BorderLayout();
	private JMenu fileMenu2;
	private JMenuBar bar= new JMenuBar();
	
        
	private JMenuItem importMenu = new JMenuItem("import xls File");
	
	private File selectedFile;
	private JLabel selectFileLabel = new JLabel("No File");
	
	private BorderLayout bllayout;
        
        

	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	// Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();

	public CourseFrame() {
        this.bllayout = new BorderLayout();
        this.fileMenu2 = new JMenu("File");
        
		// TODO Auto-generated constructor stub
		JFrame f1 = new JFrame();
		f1.setLayout(bllayout);
		f1.add(selectFileLabel ,BorderLayout.SOUTH);
		
		importMenu.addActionListener(new ActionListener() {
			//test
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				try {
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setFileFilter(new FileNameExtensionFilter("Excel File (*.xls)", "xls"));
					int opt = chooser.showOpenDialog(null);
					/*while (opt == JFileChooser.CANCEL_OPTION || opt == JFileChooser.ERROR_OPTION) {
						JOptionPane.showMessageDialog(null, "Please Select file");
						opt = chooser.showOpenDialog(null);
					}*/
					String fName = chooser.getSelectedFile().getPath();
					
					selectedFile = new File(fName);
					selectFileLabel.setText("File Name: "+selectedFile.getName());
					System.out.println("j");
					Workbook workbook = Workbook.getWorkbook(new java.io.File(fName));
					Sheet ws1 = workbook.getSheet(0);
					
					
					int numOfColumn = ws1.getColumns();
					int numOfRow = ws1.getRows();                
					for (int i = 7; i < numOfRow; i++) {
						StudentArray.add(new Student(ws1.getCell(1, i).getContents(), ws1.getCell(2, i).getContents() , ws1.getCell(3, i).getContents()));
						System.out.println();
					}
					workbook.close();
					System.out.println("Read Sucess");
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
		});
		
		
		
		fileMenu.add(importMenu);
		bar.add(fileMenu2);
		f1.add(bar, BorderLayout.NORTH);
		


		JPanel west = new JPanel();
		west.setLayout(new GridLayout(4, 1));
		west.add(course = new JButton("Course"));
		west.add(addraw = new JButton("Add Raw Score"));
		west.add(netscore = new JButton("Net Score"));
		west.add(grade = new JButton("Grade"));
		f1.add(west, BorderLayout.WEST);
		JPanel cen = new JPanel();
		cen.add(head = new JLabel("Hello EveryOne"));
		
		//import Excel File
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();

				try {

					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setFileFilter(new FileNameExtensionFilter("Excel 97-2003 Workbook (*.xls)", "xls"));

					int opt = chooser.showOpenDialog(null);

					while (opt == JFileChooser.CANCEL_OPTION || opt == JFileChooser.ERROR_OPTION) {
						JOptionPane.showMessageDialog(null, "Please Select file");
						opt = chooser.showOpenDialog(null);
					}

					// chooser.showSaveDialog(null);

					String fName = chooser.getSelectedFile().getPath();
					System.out.println(fName);
					Workbook workbook = Workbook.getWorkbook(new java.io.File(fName));

					Sheet ws1 = workbook.getSheet(0);

					int numOfColumn = ws1.getColumns();
					int numOfRow = ws1.getRows();

					for (int i = 0; i < numOfRow; i++) {
						
							// getCell(column, row)
							//System.out.print(ws1.getCell(j, i).getContents() + " ");
							StudentArray.add(new Student(ws1.getCell(0, i).getContents(), ws1.getCell(1, i).getContents(), ws1.getCell(2, i).getContents()));
						
						System.out.println();
					}

					workbook.close();
					System.out.println("Read Sucess");
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		
		
		fileMenu.add(item);
		mBar.add(fileMenu);
		f1.add(mBar,BorderLayout.NORTH);
		
		
		
		f1.add(cen);
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f1.setSize(600, 600);
		f1.setTitle("Hello CS284");
		f1.setVisible(true);
		course.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.CoursePanel());
				f1.pack();
				f1.setSize(600, 600);

			}
		});
		addraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.StudentPanel(selectedFile ,getStudentArray()));
				f1.pack();
			}
		});
		netscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.StudentPanelTotal(selectedFile ,getStudentArray()));
				f1.pack();
			}
		});
		
		grade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.GraderPanel(selectedFile ,getStudentArray()));
				f1.pack();
			}
		});
		
		
	}

	public static void main(String[] args) {
		new CourseFrame();
	}
}
