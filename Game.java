import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Game extends SlidePuzzleModel  implements ActionListener{
	/** *  */
	private static final long serialVersionUID = 1L;
	static int response;
	static int set;
	JPanel p=new JPanel();
	String Name;
	static String s;
	String time1;
	static int  min1;
	static int sec1;
	int aprove=0;
	int response1;
	int reset=0;
	BorderLayout borderlayout=new BorderLayout();
	JFrame win=new JFrame();
	JFrame fa1=new JFrame();
	JFrame fa2=new JFrame();
	JFrame fa3=new JFrame();
	Icon icon=new ImageIcon("cover (2).png");
	JLabel jp=new JLabel(icon);
	Icon icon1=new ImageIcon("start.jpg");
	JButton score=new JButton("Records");
	JButton start=new JButton("",icon1);
	JButton L1=new JButton("Level 1");
	JButton L2=new JButton("Level 2");
	JButton L3=new JButton("Level 3");

	public void setout() {
		reset=1;
	}
	
	public void init() {
		win.add(p);
		p.add(jp,BorderLayout.CENTER);
		p.add(start);
		p.add(score);
		start.addActionListener( this);
		score.addActionListener(this);
		L1.addActionListener( this);
		L2.addActionListener( this);
		L3.addActionListener( this);
		win.add(start,BorderLayout.PAGE_END);
		win.add(score,BorderLayout.PAGE_START);
		win.setVisible(true);
		win.setSize(340,400);
		win.setResizable(false);
		win.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==start) {
			String[] options = new String[] {"Basic Level", "Startup level", "Final level", "Exit"};
			response = JOptionPane.showOptionDialog(null, "Level Chooser", "Choose Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);	
			Object value = options.length;
			if(response==0) {
				Calendar cal = Calendar.getInstance();
				min1 = cal.get(Calendar.MINUTE);
				sec1 = cal.get(Calendar.SECOND);
				time1=min1+"     "+sec1;
				this. setf("1.jpg");
				System.out.println("start"+time1);  
				set=0;
				reset=0;
				value=0;
			}  if(response==1) {
				Calendar cal = Calendar.getInstance();
				min1 = cal.get(Calendar.MINUTE);
				sec1 = cal.get(Calendar.SECOND);
				time1=min1+"     "+sec1;
				this. setf("2.jpg");
				System.out.println("start"+time1);  
				set=1;	
				reset=0;
				value=0;
			}if(response==2) {
				JFileChooser f=new JFileChooser();
				f.setDialogTitle("Picture");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "png");
				f.setFileFilter(filter);
				int abc= f.showOpenDialog(null);
				if(abc==JFileChooser.APPROVE_OPTION) {
					s= f.getSelectedFile().getAbsolutePath();
					Calendar cal = Calendar.getInstance();
					min1 = cal.get(Calendar.MINUTE);
					sec1 = cal.get(Calendar.SECOND);
					time1=min1+"     "+sec1;
					System.out.println("start"+time1);  
					this.setf(s);
					set=2;
					reset=0;
					value=0;
				}
			}if(response==3) {
				System.exit(1);
			} if(value.equals(4)) {
				this. setf("3.jpg");
				this.setout();
			}
			Name=getf();
			if(reset!=1) {
				win.setContentPane(new SlidePuzzleGUI(Name));
				win.setVisible(false);
				win.setVisible(true);
				win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}			if(source==score && aprove!=1) {
			String[] options1 = new String[] {"Basic Level", "Startup level", "Final level", "Exit"};
			response1 = JOptionPane.showOptionDialog(null, "hall of frame", "high score",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options1, options1[0]);	
			JFileChooser jFileChooser1 = new JFileChooser();
			JFileChooser jFileChooser2 = new JFileChooser();
			JFileChooser jFileChooser3 = new JFileChooser();
			JTextArea tarea1 = new JTextArea(10, 10);
			JTextArea tarea2 = new JTextArea(10, 10);
			JTextArea tarea3 = new JTextArea(10, 10);
			if(response1==0) {
				fa1.setResizable(false);
				fa1.setSize(400, 400);
				fa1.setTitle("Score Board");
				jFileChooser1.setDialogTitle("Record");
				fa1.add(tarea1);
				jFileChooser1.setSelectedFile(new File("ScoreCard.txt"));
				tarea1.setBackground(Color.orange);
				tarea1.setEditable(false);
				Font font=new Font("Times New Roman",Font.BOLD,25);
				tarea1.setFont(font);
				int result = jFileChooser1.showOpenDialog(this);
				if (result == JFileChooser.APPROVE_OPTION) {
					aprove=1;
					File selectedFile = jFileChooser1.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					try {
						BufferedReader input = null;
						input = new BufferedReader(new InputStreamReader(
								new FileInputStream("ScoreCard.txt")));
						tarea1.read(input, "READING FILE :-)");
						fa1.setVisible(true);
						aprove=0;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("Operation is CANCELLED :(");
				}
			}if(response1==1) {
				fa2.setResizable(false);
				fa2.setSize(400, 400);
				fa2.setTitle("Score Board");
				jFileChooser2.setDialogTitle("Record");
				fa2.add(tarea2);
				jFileChooser2.setSelectedFile(new File("ScoreCard2.txt"));
				tarea2.setBackground(Color.pink);
				tarea2.setEditable(false);
				Font font=new Font("Times New Roman",Font.BOLD,25);
				tarea2.setFont(font);
				int result = jFileChooser2.showOpenDialog(this);
				if (result == JFileChooser.APPROVE_OPTION) {
					aprove=1;
					File selectedFile = jFileChooser2.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					try {
						BufferedReader input = null;
						input = new BufferedReader(new InputStreamReader(
								new FileInputStream("ScoreCard2.txt")));
						tarea2.read(input, "READING FILE :-)");
						fa2.setVisible(true);
						aprove=0;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("Operation is CANCELLED :(");
				}
			}if(response1==2) {
				fa3.setResizable(false);
				fa3.setSize(400, 400);
				fa3.setTitle("Score Board");
				jFileChooser3.setDialogTitle("Record");
				fa3.add(tarea3);
				jFileChooser3.setSelectedFile(new File("ScoreCard3.txt"));
				tarea3.setBackground(Color.red);
				tarea3.setEditable(false);
				Font font=new Font("Times New Roman",Font.BOLD,25);
				tarea3.setFont(font);
				int result = jFileChooser3.showOpenDialog(this);
				if (result == JFileChooser.APPROVE_OPTION) {
					aprove=1;
					File selectedFile = jFileChooser3.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					try {
						BufferedReader input = null;
						input = new BufferedReader(new InputStreamReader(
								new FileInputStream("ScoreCard3.txt")));
						tarea3.read(input, "READING FILE :-)");
						fa3.setVisible(true);
						aprove=0;
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					System.out.println("Operation is CANCELLED :(");
				}
			}if(response1==3) {
				System.exit(1);
			}
		}
	}
}