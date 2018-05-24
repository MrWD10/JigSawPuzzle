import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class SlidePuzzleGUI extends JPanel  {
	/** *  */
	private static final long serialVersionUID = 1L;
	private GraphicsPanel _puzzleGraphics;
	public SlidePuzzleModel _puzzleModel;
	Game gaa;
	String image;
	JFrame f=new JFrame();
	static String time2;
	static int min2;
	static int sec2;
	static String Ftime;
	static String n;
	static int Min1;
	static int Sec1;
	static int res;

	public SlidePuzzleGUI(String str)  {
		JButton newGamebtn=new JButton("New Game");
		JButton viewPic=new JButton("view Picture");
		newGamebtn.setBackground(Color.cyan);
		viewPic.setBackground(Color.GREEN);
		newGamebtn.addActionListener(new NewGameAction());
		viewPic.addActionListener(new ViewPicture());
		_puzzleModel=new SlidePuzzleModel( str);
		gaa=new Game();
		_puzzleModel.reset();
		JPanel controlPanel=new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(newGamebtn);
		controlPanel.add(viewPic);
		_puzzleGraphics=new GraphicsPanel();
		this.setLayout(new BorderLayout());
		this.add(controlPanel,BorderLayout.NORTH);
		this.add(_puzzleGraphics, BorderLayout.CENTER);
		image=str;
		Min1=Game.min1;
		Sec1=Game.sec1;
		res=Game.response;
	}

	SlidePuzzleGUI(){}

	class GraphicsPanel extends JPanel implements MouseListener{
		private static final int ROW=4;
		private static final int COL=4;
		protected static final int CELL_SIZE=80;
		private Font _biggerfont;

		public GraphicsPanel() {
			_biggerfont=new Font("SansSerif",Font.BOLD,CELL_SIZE/2);
			this.setPreferredSize(new Dimension(CELL_SIZE*COL,CELL_SIZE*ROW));
			if(gaa.set==1)
				this.setBackground(Color.white);
			else
				this.setBackground(Color.black);
			this.addMouseListener(this);
			this.repaint();
		}
		@SuppressWarnings("static-access")
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(int r=0;r<ROW;r++) {
				for(int c=0;c<COL;c++){
					int x=CELL_SIZE*c;
					int y=CELL_SIZE*r;
					String text= _puzzleModel.getFace(r,c);
					if((text!=null) ) {
						g.setColor (Color.orange);
						g.fillRect(x+2,y+2,CELL_SIZE-4,CELL_SIZE-4);
						g.setColor(Color.red);
						g.setFont(_biggerfont);
						g.drawString(text, x+20, y+(3*CELL_SIZE)/4);
						if(gaa.set>0)
							g.drawImage(_puzzleModel.smallImages[r][c],x+2,y+2,CELL_SIZE-4,CELL_SIZE-4,this);
					}
				}
			}
		}

		public void mousePressed(MouseEvent e) {
			int col=e.getX()/CELL_SIZE;
			int row=e.getY()/CELL_SIZE;
			if(!_puzzleModel.moveTile(row,col)) {
				Toolkit.getDefaultToolkit().beep();	
			}
			this.repaint();
		}
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}

	public class NewGameAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			_puzzleModel.reset();
			_puzzleModel.state=false;
			_puzzleGraphics.repaint();
		}
	}

	public class ViewPicture implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			BorderLayout b=new BorderLayout();
			JLabel jLabelObject = new JLabel();
			JButton ok=new JButton("ok");
			if(image.equals(Game.s)) 
				jLabelObject.setIcon(new ImageIcon(new ImageIcon(SlidePuzzleModel.getf()).getImage().getScaledInstance(383,250,Image.SCALE_DEFAULT)));
			if(image.equals("2.jpg")) 
				jLabelObject.setIcon(new ImageIcon("21.jpg"));
			f.add(ok);
			ok.setBackground(Color.LIGHT_GRAY);
			if(image.equals("1.jpg"))
				jLabelObject.setIcon(new ImageIcon("11.png"));
			f.add(jLabelObject);
			f.add(ok,BorderLayout.PAGE_END);
			ok.addActionListener(new okListener());
			f.setVisible(true);
			f.setSize(400,320);
			f.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public class okListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			f.setVisible(false);
		}
	}
}