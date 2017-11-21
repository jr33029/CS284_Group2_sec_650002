package cs284;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GradePanel {
	private JPanel jpanel;
	public GradePanel(File selectedFile, ArrayList<Student> arrayList) {
		JPanel panel = new JPanel();
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
		jpanel = panel;
	}
	public JPanel getPanel(){
		return jpanel;
	}
}

