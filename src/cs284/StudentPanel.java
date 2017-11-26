package cs284;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class StudentPanel extends JPanel implements TableModelListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Array of Student
	//private ArrayList<Student> StudentArray = new ArrayList<>();
	private FileWriter write = null;
	private BufferedWriter print = null;
	private JPanel jpanel;
    private JTable table ;
    private double weight , maxScore;            
	

	public StudentPanel(File selectedFile, ArrayList<Student> arrayList, int numOfScorePanel) {
		JButton confirmBtn = new JButton("Confirm");
		JButton editBtn = new JButton("Edit");
		
		// test
		String[][] data = new String[arrayList.size()][100];
		String[] head = new String[6];
		head[0] = "รหัสนักศึกษา";
		head[1] = "ชื่อ-นามสกุล";
		head[2] = "ภาควิชา";
		head[3] = "สถานะการเรียน";
		head[4] = "คะแนน";
		head[5]	= "email Address";
		
		for (int i = 0; i < arrayList.size(); i++) {
			data[i][0] = arrayList.get(i).getCode();
			data[i][1] = arrayList.get(i).getName();
			data[i][2] = arrayList.get(i).getType();
			data[i][3] = "ศึกษาอยู่";
			data[i][4] = "";
			data[i][5]	= "";
		}
		this.setLayout(new BorderLayout());
		table = new JTable(data, head);
                table.getModel().addTableModelListener(this);
		JScrollPane scroll = new JScrollPane(table);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		
                JPanel tablePanel = new JPanel(new BorderLayout());
                tablePanel.add(scroll);
		add(tablePanel);
		JPanel menubot = new JPanel();
		JPanel bot = new JPanel();
		bot.setLayout(new GridLayout(2, 1));
		menubot.setLayout(new GridLayout(2, 2));
		JLabel weightLa = new JLabel("Weight (%)");
		JLabel maxScoreLa = new JLabel("Max Score");
		JTextField weightTf = new JTextField(10);
		JTextField maxScoreTf = new JTextField(10);
		menubot.add(weightLa);
		menubot.add(maxScoreLa);
		menubot.add(weightTf);
		menubot.add(maxScoreTf);
		bot.add(menubot);
		
		bot.add(confirmBtn);
		bot.add(editBtn);
		JPanel north = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		north.add(editBtn);
		add(north, BorderLayout.NORTH);
		add(bot, BorderLayout.SOUTH);
		
		editBtn.setEnabled(false);
		
		
		weightTf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try{
						
						weight = Double.parseDouble(weightTf.getText());
						if(weight <0 ||weight > 100) {
							throw new NumberFormatException("Weight must in 0 - 100 range");
						}
						
						JOptionPane.showMessageDialog(null, "Weight : "+ weight +"(%)");
					}catch(NumberFormatException ex){
						JOptionPane.showMessageDialog(null, "Weight must in 0 - 100 range");
					}
				}
			}
		});
		
		
		maxScoreTf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try{
						maxScore= Double.parseDouble(maxScoreTf.getText());
						
						if(maxScore <0)throw new NumberFormatException("Wrong format Number");
						
						JOptionPane.showMessageDialog(null, "คะแนนเต็มของการสอบครั้งนี้ : " +maxScore);
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Wrong format Number");
					}
				}
			}
		});
		
		confirmBtn.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
                            
                            
                            
                            //JOptionPane.showConfirmDialog(null, "Are you sure you want to continue?");
                            
				// TODO Auto-generated method stub
			
				try{
					
					weight = Double.parseDouble(weightTf.getText());
					if(weight <0 ||weight > 100) {
						throw new NumberFormatException("Weight must in 0 - 100 range");
					}
					
					JOptionPane.showMessageDialog(null, "Weight : "+ weight +"(%)");
				}catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(null, "Weight must in 0 - 100 range");
				}
				
				try{
					maxScore= Double.parseDouble(maxScoreTf.getText());
					
					if(maxScore <0)throw new NumberFormatException("Wrong format Number");
					
					JOptionPane.showMessageDialog(null, "คะแนนเต็มของการสอบครั้งนี้ : " +maxScore);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Wrong format Number");
				}
				
				
				
				
				System.out.println(table.getModel().getValueAt(0, 4));
				System.out.println(table.getModel().getRowCount());
				for (int i = 0; i < table.getModel().getRowCount(); i++) {
					try {
							arrayList.get(i).setEmail((String) table.getModel().getValueAt(i, 5));
							arrayList.get(i).set(numOfScorePanel,Double.parseDouble((String) table.getModel().getValueAt(i, 4)));
						
					}catch(IndexOutOfBoundsException ex) {
						
							arrayList.get(i).add(numOfScorePanel,Double.parseDouble((String) table.getModel().getValueAt(i, 4)));
							
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Wrong format score.");
						return;
					}
								
									
					System.out.println(arrayList.get(i).getListOfScore());
				}
				
				System.out.println(arrayList);
				
				for (int i = 0; i < arrayList.size(); i++) {
					double ttScore= arrayList.get(i).getTotalPoint();
					ttScore+= arrayList.get(i).getListOfScore().get(numOfScorePanel)*(weight/100.0);
					arrayList.get(i).setTotalPoint(ttScore);
				}
				
				
				confirmBtn.setEnabled(false);
				table.setEnabled(false);
				
				
				editBtn.setEnabled(true);
			}
		});
		
		
		editBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				table.setEnabled(true);
				confirmBtn.setEnabled(true);
				editBtn.setEnabled(false);
			}
		});
		
		
		
		
                
	}
        
        
        
        
        
	
	

    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println(e.getColumn() );
        System.out.println(e.getFirstRow() );
                
        System.out.println("");
                
                table.getModel().getValueAt(0, 0);
                
       
                
       
    }
}
