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
	
	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	//Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();

	public CourseFrame() {
		// TODO Auto-generated constructor stub
		JFrame f1 = new JFrame();
		f1.setLayout(new GridLayout(1, 2));

		JPanel west = new JPanel();
		west.setLayout(new GridLayout(4, 1));
		west.add(course = new JButton("Course"));
		west.add(addraw = new JButton("Add Raw Score"));
		west.add(netscore = new JButton("Net Score"));
		west.add(grade = new JButton("Grade"));
		f1.add(west,BorderLayout.WEST);
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
				
				
				

				
				cen.add(panel.StudentPanel());
				f1.pack();
			}
		});
		netscore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel = new AllPanel();
				cen.removeAll();
				cen.add(panel.StudentPanelTotal());
				f1.pack();
			}
		});
	}

	public static void main(String[] args) {
		new CourseFrame();
	}
}
