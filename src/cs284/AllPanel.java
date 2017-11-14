package cs284;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
import jxl.Sheet;
import jxl.Workbook;

public class AllPanel {
	FileWriter write = null;
	BufferedWriter print = null;
	

	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	// Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();

	public JPanel CoursePanel() {

		ArrayList<JTextField> text = new ArrayList<>();
		JLabel gradeLabel = new JLabel();
		String criteriaText ="";
		
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
				
				 
				FileReader fr;
				String criteriaText ="";
				try {
					fr = new FileReader("Grader.txt");
					BufferedReader br = new BufferedReader(fr);
					
					String tmp;
					while(( tmp =br.readLine()) != null){
						criteriaText += tmp+"   ";
						
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				gradeLabel.setText(criteriaText);
			}
		});
		
		FileReader fr;
		 criteriaText ="";
		 
		try {
			fr = new FileReader("Grader.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String tmp;
			
			while(( tmp =br.readLine()) != null){
				//gradeString = tmp.split(" ");
				
				criteriaText += tmp+"   ";
				
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		gradeLabel.setText(criteriaText);
		
		for (int i = 0; i < text.size(); i++) {
			
			text.get(i).setText(null);;
		}
		
		
		JPanel subPanel = new JPanel();
		subPanel.add(gradeLabel);
		course.add(subPanel,BorderLayout.BEFORE_FIRST_LINE);
		return course;
	}

	public JPanel StudentPanel(File selectedFile, ArrayList<Student> arrayList) {
		JButton ok = new JButton("Confirm");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//test
		String[][] data = new String[arrayList.size()][100];
		String[] head = new String[5];
		head[0] = "���ʹѡ�֡��";
		head[1] = "����-���ʡ��";
		head[2] = "������";
		head[3] = "ʶҹС�����¹";
		head[4] = "��ṹ";
		for (int i = 0; i < arrayList.size(); i++) {
			data[i][0] = arrayList.get(i).getCode();
			data[i][1] = arrayList.get(i).getName();
			data[i][2] = arrayList.get(i).getType();
			data[i][3] = "�ѧ���¹����";
			data[i][4] = arrayList.get(i).getTotalPoint()+"";
		}
		JTable table = new JTable(data, head);
		JScrollPane scroll = new JScrollPane(table);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		panel.add(scroll);
		JPanel menubot = new JPanel();
		JPanel bot = new JPanel();
		bot.setLayout(new GridLayout(2, 1));
		menubot.setLayout(new GridLayout(2, 2));
		JLabel sayV = new JLabel("�Ѵ��ǹ�ͧ��ṹ");
		JLabel sayM = new JLabel("��ṹ���");
		JTextField getV = new JTextField(10);
		JTextField getM = new JTextField(10);
		menubot.add(sayV);
		menubot.add(sayM);
		menubot.add(getV);
		menubot.add(getM);
		bot.add(menubot);
		bot.add(ok);
		panel.add(bot, BorderLayout.SOUTH);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame textf = new JFrame();
				JTextField textn = new JTextField(10);
				textf.add(textf);
				try {
					write = new FileWriter(textn.getText() + ".txt");
					print = new BufferedWriter(write);
					print.write("");
					print.close();
					write.close();
					textf.pack();
					textf.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch
					e1.printStackTrace();
				}
			}
		});
		// System.out.println(table.getModel().getValueAt(0, 3));
		return panel;
	}

	public JPanel StudentPanelTotal(File selectedFile, ArrayList<Student> arrayList) {
		JPanel panel = new JPanel();

		//String[] head = { "Student ID", "Name", "LastName", "TotalPoint" };
		// JTable table = new JTable(data, head);
		// JScrollPane scroll = new JScrollPane(table);
		// panel.add(scroll);
		// table.setEnabled(false);
		
		
		
		String[][] data = new String[arrayList.size()][100];
		String[] head = new String[5];
		head[0] = "���ʹѡ�֡��";
		head[1] = "����-���ʡ��";
		head[2] = "������";
		head[3] = "ʶҹС�����¹";
		head[4] = "��ṹ";
		for (int i = 0; i < arrayList.size(); i++) {
			data[i][0] = arrayList.get(i).getCode();
			data[i][1] = arrayList.get(i).getName();
			data[i][2] = arrayList.get(i).getType();
			data[i][3] = "�ѧ���¹����";
			data[i][4] = arrayList.get(i).getTotalPoint()+"";
		}
		JTable table = new JTable(data, head);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
		return panel;
	}
	
	public JPanel GraderPanel(File selectedFile, ArrayList<Student> arrayList){
		JPanel panel = new JPanel();
		//String[] head = { "Student ID", "Name", "LastName", "TotalPoint" };
		//JTable table = new JTable(data, head);
		//JScrollPane scroll = new JScrollPane(table);
		//panel.add(scroll);
		//table.setEnabled(false);
		
		
		
		
		
		String[][] data = new String[arrayList.size()][100];
		String[] head = new String[4];
		head[0] = "���ʹѡ�֡��";
		head[1] = "����-���ʡ��";
		head[2] = "������";
		head[3] = "�ô";
		
		for (int i = 0; i < arrayList.size(); i++) {
			data[i][0] = arrayList.get(i).getCode();
			data[i][1] = arrayList.get(i).getName();
			data[i][2] = arrayList.get(i).getType();
			data[i][3] = "";
			
		}
		JTable table = new JTable(data, head);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
		return panel;
	}
	public static void main(String[] args) {
		AllPanel p = new AllPanel();
		JFrame f = new JFrame();
		//f.add(p.StudentPanel());
		f.pack();
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
