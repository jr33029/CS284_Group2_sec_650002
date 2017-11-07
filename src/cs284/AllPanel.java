package cs284;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.File;

public class AllPanel {
	FileWriter write = null;
	BufferedWriter print = null;
	
	
	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	//Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();

	public JPanel CoursePanel() {

		ArrayList<JTextField> text = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			text.add(new JTextField(2));
		}
		JPanel course = new JPanel();
		course.setLayout(new BorderLayout());
		JPanel grade = new JPanel();
		grade.setLayout(new GridLayout(4, 2));
		JPanel p1 = new JPanel();
		p1.add(new JLabel("A "));
		p1.add(text.get(0));
		JPanel p2 = new JPanel();
		p2.add(new JLabel("B+ "));
		p2.add(text.get(1));
		JPanel p3 = new JPanel();
		p3.add(new JLabel("B "));
		p3.add(text.get(2));
		JPanel p4 = new JPanel();
		p4.add(new JLabel("C+ "));
		p4.add(text.get(3));
		JPanel p5 = new JPanel();
		p5.add(new JLabel("C "));
		p5.add(text.get(4));
		JPanel p6 = new JPanel();
		p6.add(new JLabel("D+ "));
		p6.add(text.get(5));
		JPanel p7 = new JPanel();
		p7.add(new JLabel("D "));
		p7.add(text.get(6));
		JPanel p8 = new JPanel();
		p8.add(new JLabel("F   "));
		p8.add(text.get(7));
		grade.add(p1);
		grade.add(p2);
		grade.add(p3);
		grade.add(p4);
		grade.add(p5);
		grade.add(p6);
		grade.add(p7);
		grade.add(p8);
		course.add(grade);
		JPanel ok = new JPanel();
		JButton okbtn = new JButton("OK");
		ok.add(okbtn);
		course.add(ok, BorderLayout.SOUTH);
		okbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Integer.parseInt(text.get(0).getText()) > Integer.parseInt(text.get(1).getText())) {
					System.out.println("done");
					if (Integer.parseInt(text.get(1).getText()) > Integer.parseInt(text.get(2).getText())) {
						System.out.println("done");
						if (Integer.parseInt(text.get(2).getText()) > Integer.parseInt(text.get(3).getText())) {
							System.out.println("done");
							if (Integer.parseInt(text.get(3).getText()) > Integer.parseInt(text.get(4).getText())) {
								System.out.println("done");
								if (Integer.parseInt(text.get(4).getText()) > Integer.parseInt(text.get(5).getText())) {
									System.out.println("done");
									if (Integer.parseInt(text.get(5).getText()) > Integer
											.parseInt(text.get(6).getText())) {
										System.out.println("done");
										if (Integer.parseInt(text.get(6).getText()) > Integer
												.parseInt(text.get(7).getText())) {
											System.out.println("done");
											try {
												write = new FileWriter("Grader.txt");
												print = new BufferedWriter(write);
												print.write("A " + text.get(0).getText() + "\n");
												print.write("B+ " + text.get(1).getText() + "\n");
												print.write("B " + text.get(2).getText() + "\n");
												print.write("C+ " + text.get(3).getText() + "\n");
												print.write("C " + text.get(4).getText() + "\n");
												print.write("D+ " + text.get(5).getText() + "\n");
												print.write("D " + text.get(6).getText() + "\n");
												print.write("F " + text.get(7).getText());
												print.close(); 
												write.close();
											} catch (IOException e1) {
												// TODO Auto-generated catch
												// block
												e1.printStackTrace();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		return course;
	}

	public JPanel StudentPanel() {
		
		JPanel panel = new JPanel();
		
		
		
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
				for (int j = 0; j < numOfColumn; j++) {
					// getCell(column, row)
					System.out.print(ws1.getCell(j, i).getContents() + " ");
					StudentArray.add(new Student(ws1.getCell(j, i).getContents(), ws1.getCell(j, i).getContents(), ws1.getCell(j, i).getContents()));
				}
				System.out.println();
			}

			workbook.close();
			System.out.println("Read Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		String[][] data = new  String[4][StudentArray.size()];
		
		
		/* = { { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" } };*/
				
		
		
		String[] head = new String[4];
		
		head[0] = "Student ID";
		head[1] = "Name";
		head[2] = "LastName";
		head[3] = "Point";
			
		
		
		
		for (int i = 0; i < StudentArray.size(); i++) {
			data[0][i] = StudentArray.get(i).getCode();
			data[1][i]= StudentArray.get(i).getName();
			data[2][i]= StudentArray.get(i).getLastname();
			data[3][i]= "0";
			//data[2][10]="jjj";
		}
		
		
		JTable table = new JTable(data, head);
		
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
		System.out.println(table.getModel().getValueAt(0, 3));
		return panel;
	}

	public JPanel StudentPanelTotal() {
		JPanel panel = new JPanel();
		String[][] data = { { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650706", "Chuthamas", "Thawechrat", "0" }, { "5909650714", "Chalit", "Nattayawichit", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" }, { "5909650706", "Chuthamas", "Thawechrat", "0" },
				{ "5909650714", "Chalit", "Nattayawichit", "0" } };
		String[] head = { "Student ID", "Name", "LastName", "TotalPoint" };
		JTable table = new JTable(data, head);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
		table.setEnabled(false);
		return panel;
	}

	public static void main(String[] args) {
		AllPanel p = new AllPanel();
		JFrame f = new JFrame();
		f.add(p.StudentPanel());
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
