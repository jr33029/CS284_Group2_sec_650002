package cs284;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Sheet;
import jxl.Workbook;

public class StudentPanel implements TableModelListener{
	// Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();
	private FileWriter write = null;
	private BufferedWriter print = null;
	private JPanel jpanel;
        private JTable table ;
                
	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	public StudentPanel(File selectedFile, ArrayList<Student> arrayList) {
		JButton ok = new JButton("Confirm");
		JPanel panel = new JPanel(new BorderLayout());
		panel.setLayout(new BorderLayout());
		// test
		String[][] data = new String[arrayList.size()][100];
		String[] head = new String[5];
		head[0] = "รหัสนักศึกษา";
		head[1] = "ชื่อ-นามสกุล";
		head[2] = "ภาควิชา";
		head[3] = "สถานะการเรียน";
		head[4] = "คะแนน";
		for (int i = 0; i < arrayList.size(); i++) {
			data[i][0] = arrayList.get(i).getCode();
			data[i][1] = arrayList.get(i).getName();
			data[i][2] = arrayList.get(i).getType();
			data[i][3] = "ศึกษาอยู่";
			data[i][4] = arrayList.get(i).getTotalPoint() + "";
		}
		table = new JTable(data, head);
                table.getModel().addTableModelListener(this);
		JScrollPane scroll = new JScrollPane(table);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
                JPanel tablePanel = new JPanel(new BorderLayout());
                tablePanel.add(scroll);
		panel.add(tablePanel);
		JPanel menubot = new JPanel();
		JPanel bot = new JPanel();
		bot.setLayout(new GridLayout(2, 1));
		menubot.setLayout(new GridLayout(2, 2));
		JLabel sayV = new JLabel("Score Value");
		JLabel sayM = new JLabel("Max Score");
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

				try {
					JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setFileFilter(new FileNameExtensionFilter("Excel 97-2003 Workbook (*.xls)", "xls"));
					int opt = chooser.showOpenDialog(null);
					while (opt == JFileChooser.CANCEL_OPTION || opt == JFileChooser.ERROR_OPTION) {
						JOptionPane.showMessageDialog(null, "Please Select file");
						opt = chooser.showOpenDialog(null);
					}
					String fName = chooser.getSelectedFile().getPath();
					System.out.println(fName);
					Workbook workbook = Workbook.getWorkbook(new java.io.File(fName));
					Sheet ws1 = workbook.getSheet(0);
					int numOfColumn = ws1.getColumns();
					int numOfRow = ws1.getRows();

					for (int i = 0; i < numOfRow; i++) {
						StudentArray.add(new Student(ws1.getCell(0, i).getContents(), ws1.getCell(1, i).getContents(),
								ws1.getCell(2, i).getContents()));
						System.out.println();
					}
					workbook.close();
					System.out.println("Read Sucess");
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				String[][] data = new String[StudentArray.size()][4];
				String head[] = new String[4];
				head[0] = "Student ID";
				head[1] = "Name";
				head[2] = "LastName";
				head[3] = "Point";
				for (int i = 0; i < StudentArray.size(); i++) {
					data[i][0] = StudentArray.get(i).getCode();
					data[i][1] = StudentArray.get(i).getName();
					data[i][2] = StudentArray.get(i).getTotalPoint() + "";
					data[i][3] = "0";
				}
				JTable table = new JTable(data, head);
				JScrollPane scroll = new JScrollPane(table);
				Component add = panel.add(scroll);
			}
		});
		jpanel =  panel;
                
	}
        
        
        
        
        
	
	public JPanel getPanel(){
		return jpanel;
	}

    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println(e.getColumn() );
        System.out.println(e.getFirstRow() );
                
        
       
                
       
    }
}
