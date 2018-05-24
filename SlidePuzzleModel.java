import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class SlidePuzzleModel extends SlidePuzzleGUI {
	/** *  */
	private static final long serialVersionUID = 1L;
	private static int ROW=4;
	private static  int COL=4;
	public Tile[][] _contents;
	public Tile _emptyTile;
	protected BufferedImage[][] smallImages;
	protected int smallWidth;
	protected int smallHeight;
	protected BufferedImage image;
	protected static  String f;
	static int t;
	int score1=0;
	int score2=0;
	int score3=0;
	int score4=0;
	int score5=0;
	int 	score6=0;
	String name[]=new String[6];
	static int mint;
	static  int sect;
	int topScore[]=new int[6];
	String input1 = "no record";
	String input2 = "no record";
	String input3 = "no record";
	String input4 = "no record";
	String input5 = "no record";
	String inputR = "no record";
	boolean now=true;
	boolean state=true;

	public SlidePuzzleModel(String n)  {
		_contents=new Tile[ROW][COL];
		smallImages = new BufferedImage[ROW][COL];
		reset();
		f=n;
	}

	public SlidePuzzleModel()  {}

	String getFace(int row,int col) {
		return _contents[row][col].getFace();
	}

	void setf(String s) {
		f=s;
	}

	static String getf() {
		return f;
	}

	public void reset() {
		int count =0;
		String a=getf();
		int x = 0; 
		try {
			image = ImageIO.read(new File(a));
		} catch (IOException e) {
			e.printStackTrace();
		}
		smallWidth = image.getWidth() / COL;
		smallHeight = image.getHeight() / ROW;
		while(x<ROW) {
			int y = 0;
			while(y<COL) {
				smallImages[x][y] = image.getSubimage(y * smallWidth, x
						* smallHeight, smallWidth, smallHeight);
				_contents[x][y]=new Tile(x, y, ""+(x*COL+y+1));
				y++;
			}
			x++;
		}
		_emptyTile=_contents[ROW-1][COL-1];
		_emptyTile.setFace(null);
		for(int r=0;r<ROW;r++) {
			for(int c=0;c<COL;c++)	{
				exchangeTiles(r,c,(int)(Math.random()*ROW),(int)(Math.random()*COL));
			}
		}
	}

	public boolean moveTile(int r,int c) {
		state=true;
		return checkEmpty(r,c,-1,0) || checkEmpty(r,c,1,0) || checkEmpty(r,c,0,-1) || checkEmpty(r,c,0,1);
	}

	private boolean checkEmpty(int r,int c,int rdelta,int cdelta) {
		int rNeighbor=r + rdelta;
		int cNeighbor=c + cdelta;
		if(isLegalRowCol(rNeighbor,cNeighbor)&& _contents[rNeighbor][cNeighbor]==_emptyTile){
			exchangeTiles(r,c,rNeighbor,cNeighbor);
			return true;
		}
		return false;
	}

	public static int time() {
		Calendar cal = Calendar.getInstance();
		min2 = cal.get(Calendar.MINUTE);
		sec2 = cal.get(Calendar.SECOND);
		time2=min2+"     "+sec2;
		mint=min2-Min1;
		sect=sec2-Sec1;
		if(sect>0)
			Ftime=mint+"     "+sect;
		else
		{
			mint=mint-1;
			sect=sect+60;
		}
		t=(mint*60)+sect;
		return t;
	}

	public   int score1(String txt,int a) {
		score1=t;
		Writer wr = null;
		try {
			wr = new FileWriter(txt);
			wr.write(String.valueOf(score1));
			if(a==1)
				Writetext1("1.txt");
			if(a==2)
				Writetext1("11.txt");
			if(a==3)
				Writetext1("111.txt");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return score1;
	}

	public void Writetext1(String txt) {
		FileOutputStream outStream1 = null;
		try{
			File test1=new File(txt);
			if(!test1.exists())
				test1.createNewFile();
			outStream1=new FileOutputStream(test1);
			DataOutputStream dataout1=new DataOutputStream(outStream1);
			dataout1.writeBytes("rect1");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				outStream1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public   int score2(String txt,int a) {
		score2=t;
		Writer wr = null;
		try {
			wr = new FileWriter(txt);
			wr.write(String.valueOf(score2));
			if(a==1)
				Writetext2("2.txt");
			if(a==2)
				Writetext2("22.txt");
			if(a==3)
				Writetext2("222.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return score2; 	 
	}

	public void Writetext2(String txt) {
		FileOutputStream outStream1 = null;
		try{
			File test1=new File(txt);
			if(!test1.exists())
				test1.createNewFile();
			outStream1=new FileOutputStream(test1);
			DataOutputStream dataout1=new DataOutputStream(outStream1);
			dataout1.writeBytes("rect2");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				outStream1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public   int score3(String txt,int a) {
		score3=t;
		Writer wr = null;
		try {
			wr = new FileWriter(txt);
			wr.write(String.valueOf(score3));
			if(a==1)
				Writetext3("3.txt");
			if(a==2)
				Writetext3("33.txt");
			if(a==3)
				Writetext3("333.txt");  
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return score3;
	}

	public void Writetext3(String txt) {
		FileOutputStream outStream1 = null;
		try{
			File test1=new File(txt);
			if(!test1.exists())
				test1.createNewFile();
			outStream1=new FileOutputStream(test1);
			DataOutputStream dataout1=new DataOutputStream(outStream1);
			dataout1.writeBytes("rect3");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				outStream1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public   int score4(String txt,int a) {
		score4=t;
		Writer wr = null;
		try {
			wr = new FileWriter(txt);
			wr.write(String.valueOf(score4));
			if(a==1)
				Writetext4("4.txt");
			if(a==2)
				Writetext4("44.txt");
			if(a==3)
				Writetext4("444.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return score4;
	}

	public void Writetext4(String txt) {
		FileOutputStream outStream1 = null;
		try{
			File test1=new File(txt);
			if(!test1.exists())
				test1.createNewFile();
			outStream1=new FileOutputStream(test1);
			DataOutputStream dataout1=new DataOutputStream(outStream1);
			dataout1.writeBytes("rect4");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				outStream1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public   int score5(String t2,String t1,int a) {
		if(inputR.equals("r")) {
			score5=t;
			Writer wr = null;
			try {
				wr = new FileWriter(t1);
				wr.write(String.valueOf(score5));
				if(a==1)
					Writetext5("5.txt",a);
				if(a==2)
					Writetext5("55.txt",a);
				if(a==3)
					Writetext5("555.txt",a);	
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			finally {
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return score5;
		}
		else {
			score6=t;
			Writer wr = null;
			try {
				wr = new FileWriter(t2);
				wr.write(String.valueOf(score6));
				if(a==1)
					Writetext5("5.txt",a);
				if(a==2)
					Writetext5("55.txt",a);
				if(a==3)
					Writetext5("555.txt",a);	
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			finally {
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return score6;
		}
	}

	public void Writetext5(String txt,int a) {
		FileOutputStream outStream1 = null;
		File test1 = null;
		try{

			test1=new File(txt);
			WriteReset(a);

			if(!test1.exists())
				test1.createNewFile();
			outStream1=new FileOutputStream(test1);
			DataOutputStream dataout1=new DataOutputStream(outStream1);
			dataout1.writeBytes("rect5");
			// WriteReset();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				outStream1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void WriteReset(int a) {
		FileOutputStream outStream1 = null;
		File test1 = null;
		try{
			if(a==1)
				test1=new File("reset.txt");
			if(a==2)
				test1=new File("reset2.txt");

			if(a==3)
				test1=new File("reset3.txt");

			if(!test1.exists())
				test1.createNewFile();
			outStream1=new FileOutputStream(test1);
			DataOutputStream dataout1=new DataOutputStream(outStream1);
			dataout1.writeBytes("rect0");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				outStream1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void top0(int a) {
		File file = null;
		if(a==1) {
			file = new File("top0.txt");
		}
		if(a==2)
			file = new File("top00.txt");
		if(a==3)
			file = new File("top000.txt");

		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLong())
		{
			topScore[0] = scanner.nextInt();
		}
	}

	public void top1(int a) {
		File file = null;
		if(a==1)
			file = new File("top1.txt");
		if(a==2)
			file = new File("top11.txt");
		if(a==3)
			file = new File("top111.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLong())
		{
			topScore[1] = scanner.nextInt();
		}
	}

	public void top2(int a) {
		File file = null;
		if(a==1)
			file = new File("top2.txt");
		if(a==2)
			file = new File("top22.txt");
		if(a==3)
			file = new File("top222.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLong())
		{
			topScore[2] = scanner.nextInt();
		}
	}

	public void top3(int a) {
		File file = null;
		if(a==1)
			file = new File("top3.txt");
		if(a==2)
			file = new File("top33.txt");
		if(a==3)
			file = new File("top333.txt");	
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLong())
		{
			topScore[3] = scanner.nextInt();
		}
	}

	public void top4(int a) {
		File file = null;
		if(a==1)
			file = new File("top4.txt");
		if(a==2)
			file = new File("top4.txt");
		if(a==3)
			file = new File("top444.txt");		
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLong())
		{
			topScore[4] = scanner.nextInt();
		}
	}

	public void top5(int a) {
		File file = null;
		if(a==1)
			file = new File("top5.txt");
		if(a==2)
			file = new File("top5.txt");
		if(a==3)
			file = new File("top555.txt");	
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNextLong())
		{
			topScore[5] = scanner.nextInt();
		}
	}

	public void  returnNumber1(int a) { 
		int number = 0;
		BufferedReader bufferedReader = null;
		try {
			if(a==1)
				bufferedReader = new BufferedReader(new FileReader("1.txt"));
			if(a==2)
				bufferedReader = new BufferedReader(new FileReader("11.txt"));
			if(a==3)
				bufferedReader = new BufferedReader(new FileReader("111.txt"));

			input1 = bufferedReader.readLine();
		} catch (NumberFormatException ex) {
			System.out.println("Not a number !"+input1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void  returnNumber2(int a) { 
		int number = 0;
		BufferedReader bufferedReader = null;
		try {
			if(a==1)
				bufferedReader = new BufferedReader(new FileReader("2.txt"));
			if(a==2)
				bufferedReader = new BufferedReader(new FileReader("22.txt"));
			if(a==3)
				bufferedReader = new BufferedReader(new FileReader("222.txt"));		      
			input2 = bufferedReader.readLine();
		} catch (NumberFormatException ex) {
			System.out.println("Not a number !");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void  returnNumber3(int a) { 
		int number = 0;
		BufferedReader bufferedReader = null;
		try {
			if(a==1)
				bufferedReader = new BufferedReader(new FileReader("3.txt"));
			if(a==2)
				bufferedReader = new BufferedReader(new FileReader("33.txt"));
			if(a==3)
				bufferedReader = new BufferedReader(new FileReader("333.txt"));	
			input3 = bufferedReader.readLine();		      
		} catch (NumberFormatException ex) {
			System.out.println("Not a number !"+input3);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void  returnNumber4(int a) { 
		int number = 0;
		BufferedReader bufferedReader = null;
		try {
			if(a==1)
				bufferedReader = new BufferedReader(new FileReader("4.txt"));
			if(a==2)
				bufferedReader = new BufferedReader(new FileReader("44.txt"));
			if(a==3)
				bufferedReader = new BufferedReader(new FileReader("444.txt"));		   
			input4 = bufferedReader.readLine();
		} catch (NumberFormatException ex) {
			System.out.println("Not a number !"+input4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void   ReturnReset(int a){
		int number = 0;
		BufferedReader bufferedReader = null;
		try {
			if(a==1)
				bufferedReader = new BufferedReader(new FileReader("reset.txt"));
			if(a==2)
				bufferedReader = new BufferedReader(new FileReader("reset2.txt"));
			if(a==3)
				bufferedReader = new BufferedReader(new FileReader("reset3.txt"));	
			inputR = bufferedReader.readLine();
		} catch (NumberFormatException ex) {
			System.out.println("Not a number !"+inputR);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void  returnNumber5(int a) { 
		int number = 0;
		BufferedReader bufferedReader = null;
		try {
			if(a==1)
				bufferedReader = new BufferedReader(new FileReader("5.txt"));
			if(a==2)
				bufferedReader = new BufferedReader(new FileReader("55.txt"));
			if(a==3)
				bufferedReader = new BufferedReader(new FileReader("555.txt"));		
			input5 = bufferedReader.readLine();
		} catch (NumberFormatException ex) {
			System.out.println("Not a number !"+input5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void ScoreCard(int topScore2,int b,int a) {
		FileOutputStream outStream = null;
		File test = null;
		try{
			if(a==1)
				test=new File("ScoreCard.txt"); 
			if(a==2)
				test=new File("ScoreCard2.txt"); 
			if(a==3)
				test=new File("ScoreCard3.txt"); 


			if(!test.exists())
				test.createNewFile();
			outStream=new FileOutputStream(test);
			DataOutputStream dataout=new DataOutputStream(outStream);
			dataout.writeBytes(b+"-  "+topScore2+"  seconds");
		}catch(Exception e1){
			e1.printStackTrace();
		}
		finally {
			try {
				outStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void append(int topScore2,int b,int a) {
		if(a==1) {
			try(FileWriter fw = new FileWriter("ScoreCard.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw))
			{
				String newLine = System.getProperty("line.separator");
				out.println(newLine);
				out.println( b+"-  "+topScore2+"  seconds");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}if(a==2) {
			try(FileWriter fw = new FileWriter("ScoreCard2.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw))
			{
				String newLine = System.getProperty("line.separator");
				out.println(newLine);
				out.println( b+"-  "+topScore2+"  seconds");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}if(a==3) {
			try(FileWriter fw = new FileWriter("ScoreCard3.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter out = new PrintWriter(bw))
			{
				String newLine = System.getProperty("line.separator");
				out.println(newLine);
				out.println( b+"-  "+topScore2+"  seconds");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void sort() {
		int temp=0;
		for(int i=0;i<6;i++) {
			for(int y=i+1;y<6;y++) {
				if(topScore[i]>topScore[y]) {
					temp=topScore[i];
					topScore[i]=topScore[y];
					topScore[y]=temp;
				}
			}
		}
	}

	public boolean isLegalRowCol(int r,int c) {
		return r>=0 && r<ROW && c>=0 && c<COL;
	}

	private void exchangeTiles(int r1,int c1,int r2,int c2) {
		Tile temp=_contents[r1][c1];
		BufferedImage img=smallImages[r1][c1];
		smallImages[r1][c1]=smallImages[r2][c2];
		smallImages[r2][c2]=img;
		_contents[r1][c1]=_contents[r2][c2];
		_contents[r2][c2]=temp;

		if(Game.response==0) {
			time();
			returnNumber1(1);
			returnNumber2(1);
			returnNumber3(1);
			returnNumber4(1);
			returnNumber5(1);
			ReturnReset(1);
			top0(1);
			top1(1);
			top2(1);
			top3(1);
			top4(1);
			top5(1);
if(state) {
			if(isGameOver(0,0)) {if(isGameOver(0,1)) {if(isGameOver(0,2)) {if(isGameOver(0,3)) {if(isGameOver(1,0)) {if(isGameOver(1,1)) {if(isGameOver(1,2)) {
				if(isGameOver(1,3)) {if(isGameOver(2,0)) {if(isGameOver(2,1)) {if(isGameOver(2,2)) {if(isGameOver(2,3)) {if(isGameOver(3,0)) {if(isGameOver(3,1)) {
					if(isGameOver(3,2)) {if(isGameOver(3,3)) {

						if(inputR.equals("r")) {

							if(input1.equals("rect1") && input2.equals("rect2") && input3.equals("rect3") && input4.equals("rect4") && input5.equals("rect5")) {
								topScore[4]=score5("top5.txt","top4.txt",1);
								now=false;
								sort();
							}  else  if(input4.equals("rect4")  && input1.equals("rect1") && input2.equals("rect2") && input3.equals("rect3")) {
								topScore[3]= score5("top5.txt","top4.txt",1);
								now =false;
								sort();
							} else   if(input3.equals("rect3") && input1.equals("rect1") && input2.equals("rect2")) {
								topScore[2]= score4("top3.txt",1);
								now =false;
								sort();				     
							}else if(input2.equals("rect2") && input1.equals("rect1") ){
								topScore[2]= score3("top2.txt",1);
								now =false;
								sort();
							}else if(input1.equals("rect1")) {
								topScore[1]= score2("top1.txt",1);
								now =false;
								sort();
							}  else if(now) {
								topScore[0]= score1("top0.txt",1);
								sort();
							}
						}  else if(inputR.equals("rect0")){
							if(topScore[5]<topScore[4]) {
								topScore[4]=score5("top5.txt","top4.txt",1);
								sort();
							} else {
								int s=score5("top5.txt","top4.txt",1);
								sort();
							}
						}
						top0(1);
						top1(1);
						top2(1);
						top3(1);
						top4(1);
						top5(1);
						sort();
						ScoreCard(topScore[0],1,1);
						append(topScore[1],2,1);
						append(topScore[2],3,1);
						append(topScore[3],4,1);
						append(topScore[4],5,1);
						JOptionPane.showMessageDialog(null, "Your Time is"+t);
						try        
						{
							Thread.sleep(1000);
						}catch(InterruptedException ex) 
						{
							Thread.currentThread().interrupt();
						}System.exit(1);
					}}}}}}}}}}}}}}}}}
		} else if(Game.response==1) {
			time();
			returnNumber1(2);
			returnNumber2(2);
			returnNumber3(2);
			returnNumber4(2);
			returnNumber5(2);
			ReturnReset(2);
			top0(2);
			top1(2);
			top2(2);
			top3(2);
			top4(2);
			top5(2);
			if(state) {
			if(isGameOver(0,0)) {if(isGameOver(0,1)) {if(isGameOver(0,2)) {if(isGameOver(0,3)) {if(isGameOver(1,0)) {if(isGameOver(1,1)) {if(isGameOver(1,2)) {
				if(isGameOver(1,3)) {if(isGameOver(2,0)) {if(isGameOver(2,1)) {if(isGameOver(2,2)) {if(isGameOver(2,3)) {if(isGameOver(3,0)) {if(isGameOver(3,1)) {
					if(isGameOver(3,2)) {if(isGameOver(3,3)) {

						if(inputR.equals("r")) {

							if(input1.equals("rect1") && input2.equals("rect2") && input3.equals("rect3") && input4.equals("rect4") && input5.equals("rect5")) {
								topScore[4]=score5("top55.txt","top44.txt",2);
								now=false;
								sort();
							}  else  if(input4.equals("rect4")  && input1.equals("rect1") && input2.equals("rect2") && input3.equals("rect3")) {
								topScore[3]= score5("top55.txt","top44.txt",2);
								now =false;
								sort();
							} else   if(input3.equals("rect3") && input1.equals("rect1") && input2.equals("rect2")) {
								topScore[2]= score4("top33.txt",2);
								now =false;
								sort();				     
							}else if(input2.equals("rect2") && input1.equals("rect1") ){
								topScore[2]= score3("top22.txt",2);
								now =false;
								sort();
							}else if(input1.equals("rect1")) {
								topScore[1]= score2("top11.txt",2);
								now =false;
								sort();
							}  else if(now) {
								topScore[0]= score1("top00.txt",2);
								sort();
							}
						}  else if(inputR.equals("rect0")){
							if(topScore[5]<topScore[4]) {
								topScore[4]=score5("top55.txt","top44.txt",2);
								sort();
							} else {
								int s=score5("top55.txt","top44.txt",2);
								sort();
							}
						}
						top0(2);
						top1(2);
						top2(2);
						top3(2);
						top4(2);
						top5(2);
						sort();
						ScoreCard(topScore[0],1,2);
						append(topScore[1],2,2);
						append(topScore[2],3,2);
						append(topScore[3],4,2);
						append(topScore[4],5,2);
						JOptionPane.showMessageDialog(null, "Your Time is"+t);
						try        
						{
							Thread.sleep(1000);
						}catch(InterruptedException ex) 
						{
							Thread.currentThread().interrupt();
						}System.exit(1);

					}}}}}}}}}}}}}}}}}
		}else if(Game.response==2) {
			time();
			returnNumber1(3);
			returnNumber2(3);
			returnNumber3(3);
			returnNumber4(3);
			returnNumber5(3);
			ReturnReset(3);
			top0(3);
			top1(3);
			top2(3);
			top3(3);
			top4(3);
			top5(3);
			if(state) {
			if(isGameOver(0,0)) {if(isGameOver(0,1)) {if(isGameOver(0,2)) {if(isGameOver(0,3)) {if(isGameOver(1,0)) {if(isGameOver(1,1)) {if(isGameOver(1,2)) {
				if(isGameOver(1,3)) {if(isGameOver(2,0)) {if(isGameOver(2,1)) {if(isGameOver(2,2)) {if(isGameOver(2,3)) {if(isGameOver(3,0)) {if(isGameOver(3,1)) {
					if(isGameOver(3,2)) {if(isGameOver(3,3)) {

						if(inputR.equals("r")) {

							if(input1.equals("rect1") && input2.equals("rect2") && input3.equals("rect3") && input4.equals("rect4") && input5.equals("rect5")) {
								topScore[4]=score5("top555.txt","top444.txt",3);
								now=false;
								sort();
							}  else  if(input4.equals("rect4")  && input1.equals("rect1") && input2.equals("rect2") && input3.equals("rect3")) {
								topScore[3]= score5("top555.txt","top444.txt",3);
								now =false;
								sort();
							} else   if(input3.equals("rect3") && input1.equals("rect1") && input2.equals("rect2")) {
								topScore[2]= score4("top333.txt",3);
								now =false;
								sort();				     
							}else if(input2.equals("rect2") && input1.equals("rect1") ){
								topScore[2]= score3("top222.txt",3);
								now =false;
								sort();
							}else if(input1.equals("rect1")) {
								topScore[1]= score2("top111.txt",3);
								now =false;
								sort();
							}  else if(now) {
								topScore[0]= score1("top000.txt",3);
								sort();
							}
						}  else if(inputR.equals("rect0")){
							if(topScore[5]<topScore[4]) {
								topScore[4]=score5("top555.txt","top444.txt",3);
								sort();
							} else {
								int s=score5("top555.txt","top444.txt",3);
								sort();
							}
						}
						top0(3);
						top1(3);
						top2(3);
						top3(3);
						top4(3);
						top5(3);
						sort();
						ScoreCard(topScore[0],1,3);
						append(topScore[1],2,3);
						append(topScore[2],3,3);
						append(topScore[3],4,3);
						append(topScore[4],5,3);
						JOptionPane.showMessageDialog(null, "Your Time is"+t);
						try        
						{
							Thread.sleep(1000);
						} catch(InterruptedException ex) 
						{
							Thread.currentThread().interrupt();
						}System.exit(1);
					}	}}}}}}}}}}}}}}}
		}}
	}

	public boolean isGameOver(int r,int c) {
		return _contents[r][c].isInFinalPosition(r,c);
	}
}

class Tile{
	protected int _row;
	protected int _col;
	protected String _face;
	protected Tile(int row,int col,String face) {
		_row=row;
		_col=col;
		_face=face;
	}

	public void setFace(String newFace) {
		_face=newFace;
	}

	public String getFace() {
		return _face;
	}

	public boolean isInFinalPosition(int r,int c) {
		return (r==_row && c==_col);
	}

}