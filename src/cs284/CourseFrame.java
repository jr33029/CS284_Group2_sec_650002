package cs284;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import jxl.Sheet;
import jxl.Workbook;

public class CourseFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton addraw, netscore, grade;
	private JLabel head;
	private StudentPanel stpanel;
	private StudentPanelTotal stTpanel;
	private GradePanel gpanel;
	private Reader reader = new Reader();
	private JMenuBar mBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenuItem exportMenu = new JMenuItem("Export Excel(97-2003 *.xls) File");
	private JMenuItem importMenu = new JMenuItem("Import Excel(97-2003 *.xls) File");
	private JMenuItem openMenu = new JMenuItem("Open");
	private JMenuItem saveMenu = new JMenuItem("Save As...");
        private JMenuItem logutMenu = new JMenuItem("Logout");
	private BorderLayout bl = new BorderLayout();
	private JMenuBar bar = new JMenuBar();
	private File selectedFile;
	private JLabel selectFileLabel = new JLabel("No File");
	private BorderLayout bllayout;

	public ArrayList<Student> getStudentArray() {
		return StudentArray;
	}

	// Array of Student
	private ArrayList<Student> StudentArray = new ArrayList<>();

	public CourseFrame() {
                
		this.bllayout = new BorderLayout();
		// TODO Auto-generated constructor stub
		JFrame f1 = new JFrame();
		f1.setLayout(bllayout);
		f1.add(selectFileLabel, BorderLayout.SOUTH);
		importMenu.addActionListener(new ActionListener() {
			// test
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                                
                                ExcelFileController controller = new ExcelFileController();
                                
                               controller.readExcelFile(selectFileLabel);
				StudentArray = controller.getStudentArray();
                                
			}
		});

		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.addSeparator();
		fileMenu.add(importMenu);
		bar.add(fileMenu);
		f1.add(bar, BorderLayout.NORTH);
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(3, 1));
		west.add(addraw = new JButton("Add Raw Score"));
		west.add(netscore = new JButton("Net Score"));
		west.add(grade = new JButton("Grade"));
		f1.add(west, BorderLayout.WEST);
		JPanel cen = new JPanel(new BorderLayout());  //ขยายแล้วตารางมันจะได้เต็มจอ
                head = new JLabel("Hello EveryOne",SwingConstants.CENTER);
                head.setFont(new Font("Tahoma", Font.BOLD, 24));
		cen.add(head);
                
		// import Excel File
		exportMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

               logutMenu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LoginFrame loginFrame = new LoginFrame();
                        loginFrame.setVisible(true);
                        f1.dispose();
                                
                       
                    }
                });
                
                
		fileMenu.add(exportMenu);
                fileMenu.addSeparator();
                fileMenu.add(logutMenu);
		mBar.add(fileMenu);
		f1.add(mBar, BorderLayout.NORTH);
		f1.add(cen);
		f1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f1.setSize(600, 600);              
		f1.setTitle("Hello CS284");
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
		addraw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stpanel = new StudentPanel(selectedFile, getStudentArray());
				cen.removeAll();
				cen.add(stpanel.getPanel());
				f1.pack();
			}
		});
		netscore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stTpanel = new StudentPanelTotal(selectedFile, getStudentArray());
				cen.removeAll();
				cen.add(stTpanel.getPanel());
				f1.pack();
			}
		});

		grade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gpanel = new GradePanel(selectedFile, getStudentArray());
				cen.removeAll();
				cen.add(gpanel.getPanel());
				f1.pack();
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
            CourseFrame courseFrame = new CourseFrame();
          
	}
}
