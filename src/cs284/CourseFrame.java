package cs284;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.mail.SendFailedException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import org.apache.commons.io.FilenameUtils;

import jxl.Sheet;
import jxl.Workbook;

public class CourseFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Student> StudentArray ;
	private JButton addraw, netscore, grade;
	private JLabel head;
	private StudentPanel stpanel;
	private StudentPanelTotal stTpanel;
	private GradePanel gpanel;
	private Reader reader = new Reader();
	private JMenuBar mBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu  mailMenu= new JMenu("Email");
	
	
	private JMenuItem exportMenu = new JMenuItem("Export Excel(97-2003 *.xls) File");
	private JMenuItem importMenu = new JMenuItem("Import Excel(97-2003 *.xls) File");
	private JMenuItem openMenu = new JMenuItem("Open");
	private JMenuItem saveMenu = new JMenuItem("Save As...");
        private JMenuItem logutMenu = new JMenuItem("Logout");
        
        private JMenuItem sendEmailMenuItem = new JMenuItem("Send Email");
        private JMenuItem sendGradeMenuItem = new JMenuItem("Send Grade Email");
        private JMenuItem sendStatisticMenuItem = new JMenuItem("Send Grade Statistic Email");
        
        
	private BorderLayout bl = new BorderLayout();
	
	private File selectedFile;
	private JLabel selectFileLabel = new JLabel("No File");
	private BorderLayout bllayout;
	ExcelFileController controller = new ExcelFileController();
        private MyTabbedPane tab  = new MyTabbedPane();
        private GradeCriteriaManager grademng;
        
	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	// Array of Student
	

	public CourseFrame(String fName ,String lName ,String course ,String section, String user) {
        this.setPreferredSize(new Dimension(800, 700));        
		this.bllayout = new BorderLayout();
		// TODO Auto-generated constructor stub
		
		
		setLayout(bllayout);
		add(selectFileLabel, BorderLayout.SOUTH);
		importMenu.addActionListener(new ActionListener() {
			// test
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                             /* if(tab !=null && StudentArray !=null) {
                            	  tab.removeAll();  
                            	  StudentArray.clear();  
                            	  stpanel.removeAll();
                              }*/
                              
                                
                              if( controller.readExcelFile(selectFileLabel)){
                                  StudentArray = controller.getStudentArray();
                                  addraw.setEnabled(true);
                                  StudentArray = controller.getStudentArray();
                                 // System.out.println(StudentArray);
                              }else {
                            	  addraw.setEnabled(false);
                              }
				
			}
		});

	
		
		
		
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(3, 1));
		west.add(addraw = new JButton("Add Raw Score"));
		west.add(netscore = new JButton("Net Score"));
		west.add(grade = new JButton("Grade"));
		add(west, BorderLayout.WEST);
		JPanel cen = new JPanel(new BorderLayout());  //ขยายแล้วตารางมันจะได้เต็มจอ
                head = new JLabel("Hello "+ fName +" " + lName + "\n" + course+ " " + section ,SwingConstants.CENTER);
                head.setFont(new Font("Tahoma", Font.BOLD, 24));
		cen.add(head);
                
		// import Excel File
		exportMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					controller.writeExcelFile();
			}
		});

        logutMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginFrame loginFrame = new LoginFrame();
                        loginFrame.setVisible(true);
                        dispose();
                                
                       
                    }
                });

        
        openMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JFileChooser chooser = new JFileChooser();
				int opt = chooser.showOpenDialog(null);
				if (opt == JFileChooser.APPROVE_OPTION) {
					
					File file = chooser.getSelectedFile();
					try {
						FileInputStream fi = new FileInputStream(file);
						
						ObjectInputStream ois = new ObjectInputStream(fi);
						
						if(ois.readUTF().equals(user)) {
							try {
								StudentArray =(ArrayList<Student>) ois.readObject();
								tab =(MyTabbedPane) ois.readObject();
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else {
							
						}
						
					} catch (IOException e1) {
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
				JFileChooser chooser = new JFileChooser();
				int opt = chooser.showSaveDialog(null);
				if (opt == JFileChooser.APPROVE_OPTION) {
					
					File file = chooser.getSelectedFile();
					if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase(user)) {
						// filename is OK as-is
					} else {
						file = new File(file.toString() + "."+user);
						file = new File(file.getParentFile(), FilenameUtils.getBaseName(file.getName()) + "."+user);
					}
					
					try {
						FileOutputStream fo = new FileOutputStream(file);
						ObjectOutputStream oos = new ObjectOutputStream(fo);
						
						oos.writeUTF(user);
						oos.writeObject(StudentArray);
						oos.writeObject(tab);
						
						oos.close();
						fo.close();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
        
        
        sendEmailMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SendEmailFrame f = new SendEmailFrame();
				f.setVisible(true);
			}
		});
        
        sendStatisticMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ArrayList<Double> ttscorelist = new ArrayList<>();
				SendEmailManager mng = new SendEmailManager(course, section);
				for (Student list : StudentArray) {
					ttscorelist.add(list.getTotalPoint());
				}
				StdDiv cal = new StdDiv(ttscorelist);
				try {
					for (Student list : StudentArray) {
						if(mng.sendStatisticFromGMail(list.getEmail(), list.getName(), list.getCode(), list.getTotalPoint(), cal.getMin(), cal.getMax(), cal.getMean(), cal.getDiv())) {
							
						}else {
							
								throw new SendFailedException("send failed");
							
						}
					
					}
					JOptionPane.showMessageDialog(null, "Send Successed");
				} catch (SendFailedException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "send failed");
				}
			}
		});
        
        sendGradeMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SendEmailManager mng = new SendEmailManager(course, section);
				try {
				for (Student student : StudentArray) {
					if(mng.sendFromGMail(student.getEmail(),  student.getName(), student.getCode(), student.getGrade())) {
						
					}else {
						throw new SendFailedException("send failed");
						
						
					}
				}
				JOptionPane.showMessageDialog(null, "Send Successed");
				}catch(SendFailedException ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
        
    	//fileMenu.add(openMenu);
		//fileMenu.add(saveMenu);
		//fileMenu.addSeparator();
		fileMenu.add(importMenu);
		mailMenu.add(sendEmailMenuItem);   
		mailMenu.add(sendStatisticMenuItem);
		sendGradeMenuItem.setToolTipText("Send Grade that calculated to all student registered in this class");
        mailMenu.add(sendGradeMenuItem);        
		fileMenu.add(exportMenu);
                fileMenu.addSeparator();
                fileMenu.add(logutMenu);
		mBar.add(fileMenu);
		mBar.add(mailMenu);
		add(mBar, BorderLayout.NORTH);
		add(cen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);              
		setTitle("Hello CS284");
		setLocationRelativeTo(null);
		setVisible(true);
                
                addraw.setEnabled(false);
                addraw.setToolTipText("You must import or open file before add raw score");
               
		addraw.addActionListener(new ActionListener() {
                        int numOfScorePanel=0;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
                                cen.removeAll();
				stpanel = new StudentPanel(selectedFile, getStudentArray(),numOfScorePanel);
                                tab.add(stpanel);
                                tab.setTitleAt(numOfScorePanel, "คะแนนดิบ "+numOfScorePanel);
                                numOfScorePanel= numOfScorePanel+1;
				
				cen.add(tab);
				cen.repaint();
				
				pack();
			}
			
			
		});
		netscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				stTpanel = new StudentPanelTotal(selectedFile, getStudentArray());
				cen.removeAll();
				cen.add(stTpanel.getPanel());
				pack();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});

		grade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
				grademng = new GradeCriteriaManager(getStudentArray());
				grademng.gradeRealize();
				gpanel = new GradePanel(selectedFile, getStudentArray());
				cen.removeAll();
				cen.add(gpanel);
				pack();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});

	}

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
            CourseFrame courseFrame = new CourseFrame("test","test","test","test","user");
          
	}
}
