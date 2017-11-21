package cs284;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentPanelTotal {
	private FileWriter write = null;
	private BufferedWriter print = null;
	private JPanel jpanel;
	// Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();

	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	public StudentPanelTotal(File selectedFile, ArrayList<Student> arrayList) {
		JPanel panel = new JPanel();
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
			data[i][4] = arrayList.get(i).getTotalPoint() + "";
		}
		JTable table = new JTable(data, head);
		JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll);
		jpanel =  panel;
	}
	
	public JPanel getPanel(){
		return jpanel;
	}
}
