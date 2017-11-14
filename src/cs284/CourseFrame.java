package cs284;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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

	private JMenuBar bar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");

	private JMenuItem openMenu = new JMenuItem("Open");
	private JMenuItem saveMenu = new JMenuItem("Save");
	private JMenuItem importMenu = new JMenuItem("import xls File");

	private File selectedFile;
	private JLabel selectFileLabel = new JLabel("No File");

	private BorderLayout bl = new BorderLayout();

	public ArrayList<Student> getStudentArray() {
		return studentArray;
	}

	// Array of Student
	private ArrayList<Student> studentArray = new ArrayList<>();

	public CourseFrame() {
		// TODO Auto-generated constructor stub
		JFrame f1 = new JFrame();
		f1.setLayout(bl);
		f1.add(selectFileLabel, BorderLayout.SOUTH);

		importMenu.addActionListener(new ActionListener() {
			// test
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
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

					if (opt == JFileChooser.APPROVE_OPTION) {
						String fName = chooser.getSelectedFile().getPath();
						selectedFile = new File(fName);
						selectFileLabel.setText("File Name: " + selectedFile.getName());
						System.out.println("j");
						Workbook workbook = Workbook.getWorkbook(new java.io.File(fName));
						Sheet ws1 = workbook.getSheet(0);
						System.out.println("Read Sucess");
						int numOfColumn = ws1.getColumns();
						int numOfRow = ws1.getRows();
						for (int i = 7; i < numOfRow; i++) {
							studentArray.add(new Student(ws1.getCell(1, i).getContents(),
									ws1.getCell(2, i).getContents(), ws1.getCell(3, i).getContents()));
							System.out.println();
						}
						workbook.close();
					}
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});

		openMenu.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser openChooser = new JFileChooser();
				int opt = openChooser.showOpenDialog(null);
				if (opt == JFileChooser.APPROVE_OPTION) {
					try {
						ObjectInputStream os = new ObjectInputStream(
								new FileInputStream(openChooser.getSelectedFile()));
						studentArray = (ArrayList<Student>) os.readObject();
						System.out.println(studentArray);
					} catch (IOException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		saveMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser saveChooser = new JFileChooser();

				int opt = saveChooser.showSaveDialog(null);
				if (opt == JFileChooser.APPROVE_OPTION) {
					try {

						FileOutputStream fos = new FileOutputStream(saveChooser.getSelectedFile());
						ObjectOutputStream os = new ObjectOutputStream(fos);
						os.writeObject(studentArray);
						os.close();
						fos.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});

		fileMenu.add(importMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		bar.add(fileMenu);
		f1.add(bar, BorderLayout.NORTH);

		JPanel west = new JPanel();
		west.setLayout(new GridLayout(4, 1));
		west.add(course = new JButton("เกณฑ์การตัดเกรด"));
		west.add(addraw = new JButton("คะแนนดิบ"));
		west.add(netscore = new JButton("คะแนนสุทธิ"));
		west.add(grade = new JButton("เกรด"));
		f1.add(west, BorderLayout.WEST);
		JPanel cen = new JPanel();
		cen.add(head = new JLabel("Hello EveryOne"));
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
				cen.add(panel.StudentPanel(selectedFile, getStudentArray()));
				f1.pack();
			}
		});
		netscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.StudentPanelTotal(selectedFile, getStudentArray()));
				f1.pack();
			}
		});

		grade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.GraderPanel(selectedFile, getStudentArray()));
				f1.pack();
			}
		});

	}

	public static void main(String[] args) {
		new CourseFrame();
	}
}
