package cs284;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GradePanel {
	private JPanel jpanel;
	public GradePanel(File selectedFile, ArrayList<Student> arrayList) {
		JPanel panel = new JPanel(new BorderLayout());
		String[][] data = new String[arrayList.size()][100];
		String[] head = new String[4];
		head[0] = "รหัสนักศึกษา";
		head[1] = "ชื่อ-นามสกุล";
		head[2] = "ภาควิชา";
		head[3] = "เกรด";
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

