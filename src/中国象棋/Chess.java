package �й�����;

/*
 *�й�����Java��V3.0
 *����
 *Դ�ļ�:Chess.java
 *����޸�ʱ��:2005-8-20
 *��ӹ���:ʵ���˵�ǰ��ֵı���
 */

import java.awt.*;
import java.awt.event.*;

import javax.print.DocFlavor.URL;
import javax.swing.*;
import javax.swing.border.Border;

import com.sun.security.auth.NTDomainPrincipal;




import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.awt.*;
import javax.swing.*;
//����
public class Chess{
	public static void main(String args[]){
		new ChessMainFrame("�й����壺���岻������ӣ������޻ڴ��ɷ�(18�Ű�2�� �ż�ά 3118005433)");


		
	}
}

//�������
class ChessMainFrame extends JFrame implements ActionListener,MouseListener{
	//���
	JLabel play[] = new JLabel[32];
	//����
	JLabel image;	
	//����
	Container con;
	boolean issss = false;
	int alltime=300;
	int roundset=5;
	//������
	JToolBar jmain;	
	//���¿�ʼ
	JButton anew;

	//����
	JButton repent;
	//�˳�
	JButton exit;
	JButton configuration;
	//��ǰ��Ϣ
	JLabel text;
	JLabel text2;
	JLabel line1;
	JLabel line2;
	JLabel scoreboard;
	JLabel scoreboardb;
	JLabel scoreboardr;
	JLabel scoreboardbf;
	JLabel scoreboardrf;
	JLabel bout;
	JLabel et;
	JLabel etb;
	JLabel etr;
	JLabel winl;
	JLabel winlr;
	JLabel winlb;
	JLabel calculate;
	JLabel calculatejp;
	JTextArea areatext ;
	JScrollPane scrollPane;

    
    // һ���˵���ӵ��˵���


	//���浱ǰ����
	Vector Var;
	int time=alltime;

	int bf=0;
	int rf=0;
	int roundbr=1;
	//���������(ʹ�ڵ��÷���)
	ChessRule rule;
	
	/**
	** ��������
	** chessManClick = true ��˸���� �����߳���Ӧ
	** chessManClick = false ������ ֹͣ��˸  �����߳���Ӧ
	*/
	Thread tmain;
	Thread ttime;
	public boolean chessManClick;
	
	/**
	** �������ִ��
	** chessPlayClick=1 ����ִ��
	** chessPlayClick=2 ����ִ�� Ĭ�Ϻ���
	** chessPlayClick=3 ˫��������ִ��
	*/
	int chessPlayClick=2;
	
	//����������˸���߳�

	
	//�ѵ�һ�εĵ������Ӹ��߳���Ӧ
	static int Man,i;
	
	ChessMainFrame(){
		new ChessMainFrame("�й�����");
	}
	
	/**
	** ���캯��
	** ��ʼ��ͼ���û�����
	*/
	ChessMainFrame(String Title){
		//���п͸�����

		con = this.getContentPane();
		con.setLayout(null);
		//ʵ����������
		rule = new ChessRule();
		Var = new Vector();
		
		//����������
		jmain = new JToolBar();
		text = new JLabel("��ӭʹ���������ϵͳ",JLabel.CENTER);
		
		//����������ʾ��Ϣ
		text.setToolTipText("��Ϣ��ʾ");
		text2 = new JLabel("������̿�ʼ��Ϸ",JLabel.CENTER);
		text2.setFont(new java.awt.Font("����",1,50));
		line1 =new JLabel();
		line2 =new JLabel();
		scoreboard = new JLabel("�÷ְ�"+"����"+roundbr+"�غϣ�",JLabel.CENTER);
		et= new JLabel("<html>��<br>��<br>��",JLabel.CENTER);
		etb= new JLabel(" 0 ",JLabel.CENTER);
		etr= new JLabel(" 0 ",JLabel.CENTER);
		winlr= new JLabel("δ֪",JLabel.CENTER);
		winlb= new JLabel("δ֪",JLabel.CENTER);
		bout = new JLabel("���غ����",JLabel.CENTER);
		winl = new JLabel("<html>��<br>ʤ<br>��<br>��",JLabel.CENTER);
		calculate= new JLabel("<html>Ԥ<br>��<br>��<br>��",JLabel.CENTER);
		calculatejp=new JLabel(new ImageIcon("image\\pin.jpg"));
		scoreboardb = new JLabel("�ڷ��÷�",JLabel.CENTER);
		scoreboardr = new JLabel("�췽�÷�",JLabel.CENTER);
		scoreboardbf = new JLabel("-  "+bf+"  -",JLabel.CENTER);
		scoreboardrf = new JLabel("-  "+rf+"  -",JLabel.CENTER);


		anew = new JButton(" �� �� Ϸ ");
		anew.setToolTipText("���¿�ʼ�µ�һ��");
		configuration = new JButton(" �� ��  ");
		exit = new JButton(" ��  �� ");
		exit.setToolTipText("�˳�����������");
		repent = new JButton(" ��  �� ");
		repent.setToolTipText("���ص��ϴ�ִ�ӵ�λ��");
		areatext= new JTextArea("���岻������ӣ������޻ڴ��ɷ�"+"\n"+" �� Ϣ �� ¼ �壺 "+"\n"+"��Ϸ��ʼ :"+"\n"+"����ִ��->");
		areatext.setLineWrap(true);
		areatext.setEditable(false);
		areatext.setFont(new Font(null, Font.PLAIN, 12));
		scrollPane = new JScrollPane(areatext,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.doLayout();  
		//�������ӵ�������
		jmain.setLayout(new GridLayout(0,4));
		jmain.add(anew);
		jmain.add(repent);
		jmain.add(exit);
		
		jmain.add(configuration);
		jmain.setBounds(0,0,558,30);
		
		
		text.setBounds(558,0,242,30);
		text2.setBounds(0,620,558,145);
		text2.setForeground(Color.gray);
		line1.setBackground(Color.pink);
		line1.setOpaque(true); 
		line1.setBounds(558,325,230,5);
		line2.setBackground(Color.orange);
		line2.setOpaque(true); 
		line2.setBounds(558,400,230,5);
		etb.setFont(new java.awt.Font("����",1,50));
		etr.setFont(new java.awt.Font("����",1,50));
		winlr.setFont(new java.awt.Font("����",1,30));
		winlb.setFont(new java.awt.Font("����",1,30));
		etb.setForeground(Color.blue);
		etr.setForeground(Color.red);
		winlr.setForeground(Color.red);
		winlb.setForeground(Color.blue);
		scoreboardb.setForeground(Color.blue);
		scoreboardr.setForeground(Color.red);
		scoreboardbf.setForeground(Color.blue);
		scoreboardrf.setForeground(Color.red);
		scoreboard.setBounds(558,335,230,20);
		bout.setBounds(558,405,230,20);
		et.setBounds(558,425,25,50);
		etb.setBounds(583,430,108,50);
		etr.setBounds(666,430,108,50);
		winl.setBounds(558,475,25,100);
		winlb.setBounds(583,475,108,100);
		winlr.setBounds(666,475,108,100);
		calculate.setBounds(558,555,25,100);
		calculatejp.setBounds(570,550,215,100);
		scoreboardb.setBounds(558,355,120,20);
		scoreboardr.setBounds(678,355,120,20);
		scoreboardbf.setBounds(558,375,120,20);
		scoreboardrf.setBounds(678,375,120,20);

		
		
		
		scrollPane.setBounds(558,30,230,300);		  
		con.add(jmain);
		con.add(text);
		con.add(image = new JLabel(new ImageIcon("image\\main2.png")));
		image.setBounds(558,620,242,150);

		con.add(text2);
		con.add(line1);
		con.add(line2);
		con.add(scoreboard);
		con.add(bout);
		con.add(et);
		con.add(etb);
		con.add(etr);
		con.add(winl);
		con.add(winlr);
		con.add(winlb);
		con.add(calculate);
		con.add(calculatejp);
		con.add(scoreboardb);
		con.add(scoreboardr);
		con.add(scoreboardbf);
		con.add(scoreboardrf);
		
		con.add(scrollPane);

		//������ӱ�ǩ



		drawChessMan();

		//ע�ᰴŤ����
		anew.addActionListener(this);
		repent.addActionListener(this);
		exit.addActionListener(this);		
		configuration.addActionListener(this);		
		
		//ע�������ƶ�����
		for (int i=0;i<32;i++){
			con.add(play[i]);
			play[i].addMouseListener(this);
		}
		
		//������̱�ǩ
		con.add(image = new JLabel(new ImageIcon("image\\Main.GIF")));
		image.setBounds(0,30,558,620);
		image.addMouseListener(this);
		
		
		//ע�ᴰ��رռ���
		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent we){
					System.exit(0);
				}
			}
		);
		
		//�������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = this.getSize();
		
		if (frameSize.height > screenSize.height){
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width){
			frameSize.width = screenSize.width;
		}
		
		this.setLocation((screenSize.width - frameSize.width) / 2 - 280 ,(screenSize.height - frameSize.height ) / 2 - 350);
	
		//����
		this.setIconImage(new ImageIcon("image\\�콫.GIF").getImage());
		this.setResizable(false);
		this.setTitle(Title);
		this.setSize(800,785);
		this.show();
	}
	
	/**
	** ������ӷ���
	*/
	public class JTextFieldHintListener implements FocusListener {
		private String hintText;
		private JTextField textField;
		public JTextFieldHintListener(JTextField jTextField,String hintText) {
			this.textField = jTextField;
			this.hintText = hintText;
			jTextField.setText(hintText);  //Ĭ��ֱ����ʾ
			jTextField.setForeground(Color.GRAY);
			
		}
	 
		@Override
		public void focusGained(FocusEvent e) {
			//��ȡ����ʱ�������ʾ����
			String temp = textField.getText();
			if(temp.equals(hintText)) {
				textField.setText("");
				textField.setForeground(Color.BLACK);
				textField.setBorder(BorderFactory.createLineBorder(Color.green));
			}
			
		}
	 
		@Override
		public void focusLost(FocusEvent e) {	
			//ʧȥ����ʱ��û���������ݣ���ʾ��ʾ����
			String temp = textField.getText();
			if(temp.equals("")) {
				textField.setForeground(Color.GRAY);
				textField.setText(hintText);
				textField.setBorder(BorderFactory.createLineBorder(Color.yellow));
			}
			
		}
	 
	}

	class HelloDialog implements ActionListener{
		JDialog jDialog1=null;
		HelloDialog(JFrame jFrame){

		jDialog1=new JDialog(jFrame,"����",true);
		JLabel ts1=new JLabel("*ʱ��(s)",JLabel.CENTER);
		JLabel ts2=new JLabel("*����",JLabel.CENTER);
		ts1.setFont(new java.awt.Font("����",1,10));
		ts1.setForeground(Color.red);
		ts2.setFont(new java.awt.Font("����",1,10));
		ts2.setForeground(Color.red);
		ts1.setBounds(220,20,50,30);
		ts2.setBounds(220,55,40,30);
		final JTextField textField1 = new JTextField(8);
		textField1.addFocusListener(new JTextFieldHintListener(textField1, "Ĭ��ʱ��Ϊ300s"));
        textField1.setFont(new Font(null, Font.PLAIN, 15));
        textField1.setBounds(20,20,200,30);
        final JTextField textField2 = new JTextField(8);
        textField2.addFocusListener(new JTextFieldHintListener(textField2,"Ĭ�Ͼ���Ϊ5"));
        textField2.setFont(new Font(null, Font.PLAIN, 15));
        textField2.setBounds(20,55,200,30);
		//����һ����ť����,�ö�����ӵ��Ի�����
		JButton jButton1=new JButton("�ύ");
		jButton1.setBounds(20,105,80,40);
		jButton1.addActionListener(this);
		jButton1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {

	            	if(textField1.getText().trim().length()==9&&textField2.getText().trim().length()==6)
	            		jDialog1.dispose();
	            	else if(textField1.getText().trim().length()!=9&&textField2.getText().trim().length()!=6&&roundset>=5){
	            		
	            		alltime=Integer.parseInt(textField1.getText());
	            		roundset=Integer.parseInt(textField2.getText());
	            		areatext.append("\n"+"\n"+"ʱ���޸�Ϊ��"+alltime+"s"+"\n"+"�����޸�Ϊ��"+roundset+"��"+"\n"+"��Ϸ��Ϊ��"+roundset+"��"+(roundset-2)+"ʤ"+"\n"+"\n"+"����ִ��->");
	            	}
	            	else if(textField1.getText().trim().length()!=9&&textField2.getText().trim().length()!=6&&roundset<=4){
	            		
	            		alltime=Integer.parseInt(textField1.getText());
	            		roundset=Integer.parseInt(textField2.getText());
	            		areatext.append("\n"+"\n"+"ʱ���޸�Ϊ��"+alltime+"s"+"\n"+"�����޸�Ϊ��"+roundset+"��"+"\n"+"��Ϸ��Ϊ��"+roundset+"��"+(roundset-1)+"ʤ"+"\n"+"\n"+"����ִ��->");
	            	}
	            	else if(textField1.getText().trim().length()==9&&textField2.getText().trim().length()!=6&&roundset<=4){
	            		roundset=Integer.parseInt(textField2.getText());
	            		areatext.append("\n"+"\n"+"�����޸�Ϊ��"+roundset+"��"+"\n"+"��Ϸ��Ϊ��"+roundset+"��"+(roundset-1)+"ʤ"+"\n"+"ʱ��δ�޸�"+"\n"+"\n"+"����ִ��->");
	            	}
	            	else if(textField1.getText().trim().length()==9&&textField2.getText().trim().length()!=6&&roundset>=5){
	            		roundset=Integer.parseInt(textField2.getText());
	            		areatext.append("\n"+"\n"+"�����޸�Ϊ��"+roundset+"��"+"\n"+"��Ϸ��Ϊ��"+roundset+"��"+(roundset-2)+"ʤ"+"\n"+"ʱ��δ�޸�"+"\n"+"\n"+"����ִ��->");
	            	}
	            	else if(textField1.getText().trim().length()!=9&&textField2.getText().trim().length()==6){
	            		alltime=Integer.parseInt(textField1.getText());
	            		areatext.append("\n"+"\n"+"ʱ���޸�Ϊ"+alltime+"s"+"\n"+"����δ�޸�"+"\n"+"\n"+"����ִ��->");
	            	}


					
	            		
	            
	            	jDialog1.dispose();
	            }
	        });

		JButton jButton2=new JButton("ȡ��");
		jButton2.setBounds(140,105,80,40);
		jButton2.addActionListener(this);
		jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	jDialog1.dispose();
            }
        });
		//��"�ر�"��ť����������Ի���������

		/* ���öԻ���ĳ�ʼ��С */
		jDialog1.setSize(300,200);
		/* ���öԻ����ʼ��ʾ����Ļ���е�λ�� */
		jDialog1.setLocation(650,350);
		JPanel panel = new JPanel();
		panel.setLayout(null);
        // �����������
		panel.add(textField1);
		panel.add(textField2);
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(ts1);
        panel.add(ts2);
        // ���öԻ�����������
        jDialog1.setContentPane(panel);

		jDialog1.setVisible(true);
		}
		//��Ӧ�Ի����еİ�ť�¼�
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
	public void drawChessMan(){
		//���̿���
		int i,k;
		//ͼ��
		Icon in;
				
		//��ɫ����
		
		//��
		in = new ImageIcon("image\\�ڳ�.GIF");
		for (i=0,k=24;i<2;i++,k+=456){		
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);	
			play[i].setName("��1");			
		}	
		
		//��
		in = new ImageIcon("image\\����.GIF");
		for (i=4,k=81;i<6;i++,k+=342){	
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("��1");
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");
		for (i=8,k=138;i<10;i++,k+=228){	
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("��1");
		}
		
		//ʿ
		in = new ImageIcon("image\\��ʿ.GIF");
		for (i=12,k=195;i<14;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,56,55,55);
			play[i].setName("ʿ1");
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");
		for (i=16,k=24;i<21;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,227,55,55);
			play[i].setName("��1" + i);
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");			
		for (i=26,k=81;i<28;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,170,55,55);
			play[i].setName("��1" + i);
		}
		
		//��
		in = new ImageIcon("image\\�ڽ�.GIF");
		play[30] = new JLabel(in);
		play[30].setBounds(252,56,55,55);
		play[30].setName("��1");

		//��ɫ����
		//��
		in = new ImageIcon("image\\�쳵.GIF");
		for (i=2,k=24;i<4;i++,k+=456){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("��2");
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");
		for (i=6,k=81;i<8;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("��2");
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");			
		for (i=10,k=138;i<12;i++,k+=228){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("��2");
		}
		
		//ʿ
		in = new ImageIcon("image\\��ʿ.GIF");
		for (i=14,k=195;i<16;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,569,55,55);
			play[i].setName("ʿ2");
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");
		for (i=21,k=24;i<26;i++,k+=114){
			play[i] = new JLabel(in);
			play[i].setBounds(k,398,55,55);
			play[i].setName("��2" + i);
		}
		
		//��
		in = new ImageIcon("image\\����.GIF");
		for (i=28,k=81;i<30;i++,k+=342){
			play[i] = new JLabel(in);
			play[i].setBounds(k,455,55,55);
			play[i].setName("��2" + i);
		}
		
		//˧
		in = new ImageIcon("image\\�콫.GIF");			
		play[31] = new JLabel(in);
		play[31].setBounds(252,569,55,55);		
		play[31].setName("˧2");
	}
	
	/**
	** �̷߳�������������˸
	*/
	/*public static String getType(Object o) {
		return o.getClass().toString();	}*/
	
	/**
	** �������ӷ���
	*/
	
	class tstttt implements Runnable{
		public double bgg;
		public double rgg;
		@Override
		public void run() {

			if(Thread.currentThread().getName().equals("sbs")) {
				
				while(true) {
				int a=0,b=0,rg=0,bg=0,ai=0,bi=0;


				if(chessPlayClick==2) {
					for (int i = 0; i < 32; i++) {
						if((i==0||i==1||i==4||i==5||i==8||i==9||i==12||i==13||i==16||i==17||i==18||i==19||i==20||i==26||i==27||i==30)) {
							if(play[i].isVisible()) {
								a++;
								
								if(i==0||i==1)
									bg+=5;
								if(i==4||i==5)
									bg+=3;
								if(i==8||i==9)
									bg+=2;
								if(i==12||i==13)
									bg+=1;
								if(i==16||i==17||i==18||i==19||i==20)
									bg+=1;
								if(i==26||i==27)
									bg+=4;}
							if((play[i].getY()-57) >= 455 && (play[i].getX()-57)  >= 195 && (play[i].getX()-57) <= 309)
								bg+=5;
							if(play[i].getY() > 284)
								bg+=3;
							 	bgg=bg;

							}}
					ai=16-a;
					etr.setText(" "+ai+" ");

					double slb=((bgg/(rgg+bgg))*100);
				 	
					DecimalFormat dfb = new DecimalFormat("######0.00");
					String stb = dfb.format(slb);
					if(stb=="0.00"||slb==100.00) {
						winlb.setText("δ֪");}
					else{winlb.setText(stb);}					
					

				}
				if(chessPlayClick==1) {
					
					for (int i = 0; i < 32; i++) {
						 if((i==2||i==3||i==6||i==7||i==10||i==11||i==14||i==15||i==21||i==22||i==23||i==24||i==25||i==28||i==29||i==31)){
							if(play[i].isVisible()) {
								b++;
								if(i==2||i==3)
									rg+=5;
								if(i==6||i==7)
									rg+=3;
								if(i==10||i==11)
									rg+=2;
								if(i==14||i==15)
									rg+=1;
								if(i==21||i==22||i==23||i==24||i==25)
									rg+=1;
								if(i==28||i==29)
									rg+=4;}
							if(play[i].getY() <341)
								rg+=3;
							if((play[i].getX()+57) >= 195 && (play[i].getX()+57) <= 309 && (play[i].getY()-57) <= 170)
								rg+=5;
							rgg=rg;

							
					}}
					bi=16-b;
					etb.setText(" "+bi+" ");

				 	
					double slr=((rgg/(rgg+bgg))*100);
				 	
					DecimalFormat dfr = new DecimalFormat("######0.00"); 
					String str = dfr.format(slr);
					if(str=="0.00"||str=="100.00") {
						winlr.setText("δ֪");}
					else{winlr.setText(str);}
					}
					if(rgg==bgg) {
						calculatejp.setIcon(new ImageIcon("image\\pin.jpg"));
					}
					else if(rgg>bgg) {
						calculatejp.setIcon(new ImageIcon("image\\�콫.gif"));
					}
					else if(rgg<bgg) {
						calculatejp.setIcon(new ImageIcon("image\\�ڽ�.gif"));
					}
					
					}
					
					

			 }
			
			if(Thread.currentThread().getName().equals("sb")) {

					
					int  b=50;
					while (time > 0&&chessPlayClick!=3) {
						int a=alltime;
						if(time==alltime)
							text2.setForeground(Color.gray);
			        		text2.setFont(new java.awt.Font("����",1,b));
				        time--;
				        try {
				          Thread.sleep(1000);			          
				          String stirng = "��ʣ" + time + "��";
				          
				          text2.setText(stirng);
	
				        } catch (InterruptedException e) {
				          e.printStackTrace();
				        }
				        if(time<=a*0.3) {
				        	text2.setForeground(Color.red);
				        	text2.setFont(new java.awt.Font("����",1,b));
				        	b+=2;}
			      }
				
			}
			if(Thread.currentThread().getName().equals("bs")) {
			while (true){
				
				//�������ӵ�һ�¿�ʼ��˸
				/*System.out.println(getType(play[Man].getName().charAt(1)));
				System.out.println(getType(chessPlayClick));
				System.out.println(chessPlayClick==((int)play[Man].getName().charAt(1)-(int)('0')));*/
				
				if (chessManClick&&chessPlayClick==((int)play[Man].getName().charAt(1)-(int)('0'))){
					
					play[Man].setVisible(false);

					//ʱ�����
					try{
						Thread.sleep(200);
					}
					catch(Exception e){
					}
					
					play[Man].setVisible(true);
				}
				
				//��˸��ǰ��ʾ��Ϣ �����û�������bs
				else {
					
					text.setVisible(false);
					
					//ʱ�����
					try{
						Thread.sleep(500);
					}
					catch(Exception e){
					}
					
					text.setVisible(true);
				}
				
				try{
					Thread.sleep(350);
				}
				catch (Exception e){
				}
			
			}
			
		}
			
		}
		
	}
	
	public void mouseClicked(MouseEvent me){
		System.out.println("Mouse");
		
		//��ǰ����
		int Ex=0,Ey=0;
		
		//�����߳�
		
		if(!issss) {
			new Thread(new tstttt(),"sb").start();
			new Thread(new tstttt(),"bs").start();
			new Thread(new tstttt(),"sbs").start();
			issss = true;
			
		}
		//��������(�ƶ�����)
		if (me.getSource().equals(image)){
			//�ú���ִ�ӵ�ʱ��
			if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){	
				Ex = play[Man].getX();
				Ey = play[Man].getY();
				//�ƶ��䡢��
				if (Man > 15 && Man < 26){
					rule.armsRule(Man,play[Man],me);
				}			
				
				//�ƶ���
				else if (Man > 25 && Man < 30){			
					rule.cannonRule(play[Man],play,me);
				}
				
				//�ƶ���
				else if (Man >=0 && Man < 4){
					rule.cannonRule(play[Man],play,me);
				}
				
				//�ƶ���
				else if (Man > 3 && Man < 8){
					rule.horseRule(play[Man],play,me);
				}
				
				//�ƶ��ࡢ��
				else if (Man > 7 && Man < 12){
					rule.elephantRule(Man,play[Man],play,me);
				}
				
				//�ƶ��ˡ�ʿ
				else if (Man > 11 && Man < 16){
					rule.chapRule(Man,play[Man],play,me);
				}
				
				//�ƶ�����˧
				else if (Man == 30 || Man == 31){				
					rule.willRule(Man,play[Man],play,me);
				}
				
				//�Ƿ�ִ�Ӵ���(�Ƿ���ԭ��û�ж�)
				if (Ex == play[Man].getX() && Ey == play[Man].getY()){
					text.setText("               ����ִ��");
					chessPlayClick=2;
					
				}
				
				else {
					text.setText("               ����ִ��");
					chessPlayClick=1;
					time=alltime;
					areatext.append("\n"+"\n"+"����ִ��->");
				}
				
			}//if
			
			//�ú���ִ�ӵ�ʱ��
			else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
				Ex = play[Man].getX();
				Ey = play[Man].getY();

				//�ƶ��䡢��
				if (Man > 15 && Man < 26){
					rule.armsRule(Man,play[Man],me);
				}
				
				//�ƶ���
				else if (Man > 25 && Man < 30){
					rule.cannonRule(play[Man],play,me);
				}
				
				//�ƶ���
				else if (Man >=0 && Man < 4){
					rule.cannonRule(play[Man],play,me);
				}
				
				//�ƶ���
				else if (Man > 3 && Man < 8){
					rule.horseRule(play[Man],play,me);
				}
				
				//�ƶ��ࡢ��
				else if (Man > 7 && Man < 12){
					rule.elephantRule(Man,play[Man],play,me);
				}
				
				//�ƶ��ˡ�ʿ
				else if (Man > 11 && Man < 16){
					rule.chapRule(Man,play[Man],play,me);
				}
				
				//�ƶ�����˧
				else if (Man == 30 || Man == 31){
					rule.willRule(Man,play[Man],play,me);
				}
				
				//�Ƿ�ִ�Ӵ���(�Ƿ���ԭ��û�ж�)
				if (Ex == play[Man].getX() && Ey == play[Man].getY()){
					text.setText("               ����ִ��");
					chessPlayClick=1;
					
				}
				
				else {
					text.setText("               ����ִ��");
					chessPlayClick=2;
					time=alltime;
					areatext.append("\n"+"\n"+"����ִ��->");
				}

							
			}//else if		
			
			//��ǰû�в���(ֹͣ��˸)
			chessManClick=false;
			
		}//if
		
		//��������
		else{
			//��һ�ε�������(��˸����)
			if (!chessManClick){
				for (int i=0;i<32;i++){
					//������������
					if (me.getSource().equals(play[i])){
						//�����߳��ø�������˸
						Man=i;
						//��ʼ��˸
						chessManClick=true;
						break;
					}
				}//for
			}//if
			
			//�ڶ��ε�������(������)
			else if (chessManClick){
				//��ǰû�в���(ֹͣ��˸)
				chessManClick=false;
				
				for (i=0;i<32;i++){
					//�ҵ����Ե�����
					if (me.getSource().equals(play[i])){
						//�ú�������ʱ��
						if (chessPlayClick == 2 && play[Man].getName().charAt(1) == '2'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
							
							//�䡢���Թ���
							if (Man > 15 && Man < 26){
								rule.armsRule(play[Man],play[i]);
							}
							
							//�ڳԹ���
							else if (Man > 25 && Man < 30){
								rule.cannonRule(0,play[Man],play[i],play,me);
							}
							
							//���Թ���
							else if (Man >=0 && Man < 4){
								rule.cannonRule(1,play[Man],play[i],play,me);
							}
							
							//��Թ���
							else if (Man > 3 && Man < 8){
								rule.horseRule(play[Man],play[i],play,me);	
							}
							
							//�ࡢ��Թ���
							else if (Man > 7 && Man < 12){
								rule.elephantRule(play[Man],play[i],play);
							}
							
							//ʿ���˳������
							else if (Man > 11 && Man < 16){
								rule.chapRule(Man,play[Man],play[i],play);
							}
							
							//����˧�������
							else if (Man == 30 || Man == 31){
								rule.willRule(Man,play[Man],play[i],play);
								play[Man].setVisible(true);	
							}
							
							//�Ƿ�ִ�Ӵ���(�Ƿ���ԭ��û�ж�)
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								text.setText("               ����ִ��");
								chessPlayClick=2;
								
								break;
							}
														
							else{
								text.setText("               ����ִ��");
								chessPlayClick=1;
								time=alltime;
								areatext.append("\n"+"\n"+"����ִ��->");
								break;
							}	
							
						}//if
						
						//�ú�������ʱ��
						else if (chessPlayClick == 1 && play[Man].getName().charAt(1) == '1'){
							Ex = play[Man].getX();
							Ey = play[Man].getY();
													
							//��Թ���
							if (Man > 15 && Man < 26){
								rule.armsRule(play[Man],play[i]);
							}
							
							//�ڳԹ���
							else if (Man > 25 && Man < 30){
								rule.cannonRule(0,play[Man],play[i],play,me);
							}
							
							//���Թ���
							else if (Man >=0 && Man < 4){
								rule.cannonRule(1,play[Man],play[i],play,me);	
							}
							
							//��Թ���
							else if (Man > 3 && Man < 8){
								rule.horseRule(play[Man],play[i],play,me);
							}
							
							//�ࡢ��Թ���
							else if (Man > 7 && Man < 12){
								rule.elephantRule(play[Man],play[i],play);
							}
							
							//ʿ���˳������
							else if (Man > 11 && Man < 16){
								rule.chapRule(Man,play[Man],play[i],play);
							}
							
							//����˧�������
							else if (Man == 30 || Man == 31){
								rule.willRule(Man,play[Man],play[i],play);
								play[Man].setVisible(true);			
							}
							
							//�Ƿ�ִ�Ӵ���(�Ƿ���ԭ��û�ж�)
							if (Ex == play[Man].getX() && Ey == play[Man].getY()){
								text.setText("               ����ִ��");
								chessPlayClick=1;
								
								break;
							}
				
							else {
								text.setText("               ����ִ��");
								chessPlayClick=2;
								time=alltime;
								areatext.append("\n"+"\n"+"����ִ��->");
								break;
								
							}
														
						}//else if 
						
					}//if
					
				}//for
				
				
				final JButton jbutton = new JButton( "��һ��");
			    JButton jbuttons = new JButton( "�鿴���");
			    jbuttons.addActionListener(new ActionListener() {

		            public void actionPerformed(ActionEvent e) {
		            	Window win = SwingUtilities.getWindowAncestor(jbutton);
						win.dispose();
		            }
		        });
			    JButton[] buttons = { jbutton,jbuttons};
				jbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent paramActionEvent) {
						Window win = SwingUtilities.getWindowAncestor(jbutton);
						win.dispose();
						
						areatext.append("\n"+"----------------------------------------------------"+"\n"
								+"                     ��Ϸ���¿�ʼ                                   "+"\n"
								+"----------------------------------------------------"
								+"\n"+"����ִ��->");
						int i,k;
						//��������ÿ�����ӵ�λ��
						//��ɫ����
					
						//��
						time=alltime;
						for (i=0,k=24;i<2;i++,k+=456){		
							play[i].setBounds(k,56,55,55);	
						}	
						
						//��
						for (i=4,k=81;i<6;i++,k+=342){	
							play[i].setBounds(k,56,55,55);
						}
						
						//��
						for (i=8,k=138;i<10;i++,k+=228){	
							play[i].setBounds(k,56,55,55);
						}
						
						//ʿ
						for (i=12,k=195;i<14;i++,k+=114){
							play[i].setBounds(k,56,55,55);
						}
						
						//��
						for (i=16,k=24;i<21;i++,k+=114){
							play[i].setBounds(k,227,55,55);
						}
						
						//��
						for (i=26,k=81;i<28;i++,k+=342){
							play[i].setBounds(k,170,55,55);
						}
						
						//��
						play[30].setBounds(252,56,55,55);

						//��ɫ����
						//��
						for (i=2,k=24;i<4;i++,k+=456){
							play[i].setBounds(k,569,55,55);
						}
						
						//��
						for (i=6,k=81;i<8;i++,k+=342){
							play[i].setBounds(k,569,55,55);
						}
						
						//��
						for (i=10,k=138;i<12;i++,k+=228){
							play[i].setBounds(k,569,55,55);
						}
						
						//ʿ
						for (i=14,k=195;i<16;i++,k+=114){
							play[i].setBounds(k,569,55,55);
						}
						
						//��
						for (i=21,k=24;i<26;i++,k+=114){
							play[i].setBounds(k,398,55,55);
						}
						
						//��
						for (i=28,k=81;i<30;i++,k+=342){
							play[i].setBounds(k,455,55,55);
						}
						
						//˧
						play[31].setBounds(252,569,55,55);		
				
						
						text.setText("               ����ִ��");
						
						for (i=0;i<32;i++){
							play[i].setVisible(true);
						}
						//���Vector�е�����
						Var.clear();
						
						chessPlayClick = 2;
						issss=false;
						if(!issss) {
							new Thread(new tstttt(),"sb").start();
							new Thread(new tstttt(),"bs").start();
							new Thread(new tstttt(),"sbs").start();
							issss = true;
							
						}
						
					}
				});

				if(time<=0&&chessPlayClick==1)
				{   chessPlayClick=3;
					
					Icon img = new ImageIcon("image\\�콫.GIF");
					int buttonselected = JOptionPane.showOptionDialog(
							this,"���峬ʱ������ʤ��","�췽ʤ��",
							JOptionPane.YES_NO_CANCEL_OPTION,
	                        JOptionPane.ERROR_MESSAGE,
	                        img,
	                        buttons,
	                        buttons[0]);


						
						text.setText("���峬ʱ������ʤ��");
						areatext.append("���峬ʱ������ʤ��"+"\n");
						rf+=1;
						roundbr+=1;
						scoreboardrf.setText("-  "+rf+"  -");
						scoreboard.setText("�÷ְ�"+"����"+roundbr+"�֣�");
						
								
						
				}//if 
				else if(time<=0&&chessPlayClick==2)
				{	chessPlayClick=3;
				Icon img = new ImageIcon("image\\�ڽ�.GIF");
				int buttonselected =JOptionPane.showOptionDialog(
							this,"���峬ʱ������ʤ��","�ڷ�ʤ��",
							JOptionPane.YES_NO_CANCEL_OPTION,
	                        JOptionPane.ERROR_MESSAGE,
	                        img,
	                        buttons,
	                        buttons[0]);

						//˫������������ִ����
						
						text.setText("���峬ʱ������ʤ��");
						areatext.append("���峬ʱ������ʤ��"+"\n");
						bf+=1;
						roundbr+=1;
						scoreboardrf.setText("-  "+bf+"  -");
						scoreboard.setText("�÷ְ�"+"����"+roundbr+"�غϣ�");
					}//else if	
					
					

				//�Ƿ�ʤ��
				else if (!play[31].isVisible()){
					chessPlayClick=3;
					Icon img = new ImageIcon("image\\�ڽ�.GIF");
					int buttonselected =JOptionPane.showOptionDialog(
						this,"����ʤ��","�ڷ�ʤ��",
						JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        img,
                        buttons,
                        buttons[0]);

					//˫������������ִ����
					
					text.setText("  ����ʤ��");
					areatext.append("����ʤ��"+"\n");
					areatext.setForeground(Color.BLUE);
					bf+=1;
					roundbr+=1;
					scoreboardrf.setText("-  "+bf+"  -");
					scoreboard.setText("�÷ְ�"+"����"+roundbr+"�غϣ�");
					
				}//if 

				else if (!play[30].isVisible()){
					chessPlayClick=3;
					Icon img = new ImageIcon("image\\�콫.GIF");
					int buttonselected =JOptionPane.showOptionDialog(
						this,"����ʤ��","�췽ʤ��",
						JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        img,
                        buttons,
                        buttons[0]);

					
					text.setText("  ����ʤ��");
					rf+=1;
					roundbr+=1;
					scoreboardrf.setText("-  "+rf+"  -");
					scoreboard.setText("�÷ְ�"+"����"+roundbr+"�غϣ�");
					
				}//else if	
				
			}//else
			
		}//else
		
	}
	
	public void mousePressed(MouseEvent me){
	}
	public void mouseReleased(MouseEvent me){
	}
	public void mouseEntered(MouseEvent me){
	}
	public void mouseExited(MouseEvent me){
	}
	
	/**
	** ���尴ť���¼���Ӧ
	*/
	public void actionPerformed(ActionEvent ae) {
		//���¿�ʼ��ť
		if(ae.getSource().equals(configuration)){
			HelloDialog hw=new HelloDialog(this);}
		if (ae.getSource().equals(anew)){
			areatext.append("\n"+"----------------------------------------------------"+"\n"
					+"                     ��Ϸ���¿�ʼ                                   "+"\n"
					+"----------------------------------------------------"
					+"\n"+"����ִ��->");
			int i,k;
			//��������ÿ�����ӵ�λ��
			//��ɫ����
		
			//��
			time=alltime;
			for (i=0,k=24;i<2;i++,k+=456){		
				play[i].setBounds(k,56,55,55);	
			}	
			
			//��
			for (i=4,k=81;i<6;i++,k+=342){	
				play[i].setBounds(k,56,55,55);
			}
			
			//��
			for (i=8,k=138;i<10;i++,k+=228){	
				play[i].setBounds(k,56,55,55);
			}
			
			//ʿ
			for (i=12,k=195;i<14;i++,k+=114){
				play[i].setBounds(k,56,55,55);
			}
			
			//��
			for (i=16,k=24;i<21;i++,k+=114){
				play[i].setBounds(k,227,55,55);
			}
			
			//��
			for (i=26,k=81;i<28;i++,k+=342){
				play[i].setBounds(k,170,55,55);
			}
			
			//��
			play[30].setBounds(252,56,55,55);

			//��ɫ����
			//��
			for (i=2,k=24;i<4;i++,k+=456){
				play[i].setBounds(k,569,55,55);
			}
			
			//��
			for (i=6,k=81;i<8;i++,k+=342){
				play[i].setBounds(k,569,55,55);
			}
			
			//��
			for (i=10,k=138;i<12;i++,k+=228){
				play[i].setBounds(k,569,55,55);
			}
			
			//ʿ
			for (i=14,k=195;i<16;i++,k+=114){
				play[i].setBounds(k,569,55,55);
			}
			
			//��
			for (i=21,k=24;i<26;i++,k+=114){
				play[i].setBounds(k,398,55,55);
			}
			
			//��
			for (i=28,k=81;i<30;i++,k+=342){
				play[i].setBounds(k,455,55,55);
			}
			
			//˧
			play[31].setBounds(252,569,55,55);		
	
			chessPlayClick = 2;
			text.setText("               ����ִ��");
			
			for (i=0;i<32;i++){
				play[i].setVisible(true);
			}
			//���Vector�е�����
			Var.clear();

		}	
		
		//���尴ť
		else if (ae.getSource().equals(repent)){
			try{
				//���setVisible����ֵ
				String S = (String)Var.get(Var.size()-4);
				//���X����
				int x = Integer.parseInt((String)Var.get(Var.size()-3));
				//���Y����
				int y = Integer.parseInt((String)Var.get(Var.size()-2));
				//�������
				int M = Integer.parseInt((String)Var.get(Var.size()-1));
				if(chessPlayClick==2)
				{areatext.append("\n"+"----------------------------------------------------"
						+"             ����ڲ����ػ���һ��               "
						+"----------------------------------------------------"
						+"����ִ��->");}
				if(chessPlayClick==1)
				{areatext.append("\n"+"----------------------------------------------------"
						+"             ����ڲ����ػ���һ��               "
						+"----------------------------------------------------"
						+"����ִ��->");}
				//��������
				play[M].setVisible(true);			
				play[M].setBounds(x,y,55,55);
				
				if (play[M].getName().charAt(1) == '1'){
					text.setText("               ����ִ��");
					chessPlayClick = 1;
					time=alltime;
				} 
				else{
					text.setText("               ����ִ��");
					chessPlayClick = 2;
					time=alltime;
				}
				
				//ɾ���ù�������
				Var.remove(Var.size()-4);
				Var.remove(Var.size()-3);
				Var.remove(Var.size()-2);
				Var.remove(Var.size()-1);
				
				//ֹͣ������˸
				chessManClick=false;
			}
			
			catch(Exception e){
			}
		}
	
		//�˳�
		else if (ae.getSource().equals(exit)){
			int j=JOptionPane.showConfirmDialog(
				this,"���Ҫ�˳���?","�˳�",
				JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if (j == JOptionPane.YES_OPTION){
				System.exit(0);
			}
		}
	}

	/*�����й�����������*/
	class ChessRule {
		/**���ӵ��ƶ�����*/
		public void armsRule(int Man,JLabel play,MouseEvent me){
			//��������
			if (Man < 21){
				//�����ƶ����õ��յ������ģ���ɺϷ�������
				if ((me.getY()-play.getY()) > 27 && (me.getY()-play.getY()) < 86 && (me.getX()-play.getX()) < 55 && (me.getX()-play.getX()) > 0){
					
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX(),play.getY()+57,55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
				
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������				
				else if (play.getY() > 284 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
					play.setBounds(play.getX()+57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
				
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
				else if (play.getY() > 284 && (play.getX() - me.getX()) >= 2 && (play.getX() - me.getX()) <=58){
					//ģ������
					play.setBounds(play.getX()-57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
			}
			
			//��������
			else{
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//�����ƶ����õ��յ������ģ���ɺϷ�������
				if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >27 && play.getY()-me.getY() < 86){
					play.setBounds(play.getX(),play.getY()-57,55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
				
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
				else if (play.getY() < 341 && (me.getX() - play.getX()) >= 57 && (me.getX() - play.getX()) <= 112){
					play.setBounds(play.getX()+57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}				
				
				//�����ƶ����õ��յ������ģ���ɺϷ������ꡢ�������
				else if (play.getY() < 341 && (play.getX() - me.getX()) >= 3 && (play.getX() - me.getX()) <=58){
					play.setBounds(play.getX()-57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
			}
		}//���ƶ�����

		/**��������*/
		public void armsRule(JLabel play1,JLabel play2){
			//������
			if ((play2.getX() - play1.getX()) <= 112 && (play2.getX() - play1.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
				//����Ҫ���Ӳ����ҳ���
				if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){

					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
					areatext.append(play1.getName()+"    ��    "+play2.getName());
					
				}
				
				//����Ҫ���Ӳ����ܳ���
				else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
					areatext.append(play1.getName()+"    ��    "+play2.getName());
				}
			}
			
			//������
			else if ((play1.getX() - play2.getX()) <= 112 && (play1.getX() - play2.getX()) >= 57 && (play1.getY() - play2.getY()) < 22 && (play1.getY() - play2.getY()) > -22 && play2.isVisible() && play1.getName().charAt(1)!=play2.getName().charAt(1)){
				//����Ҫ���Ӳ��������
				if (play1.getName().charAt(1) == '1' && play1.getY() > 284 && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
					areatext.append(play1.getName()+"    ��    "+play2.getName());
				}
				
				//����Ҫ���Ӳ����ҳ���
				else if (play1.getName().charAt(1) == '2' && play1.getY() < 341 && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
					areatext.append(play1.getName()+"    ��    "+play2.getName());
				}
			}
			
			//������
			else if (play1.getX() - play2.getX() >= -22 && play1.getX() - play2.getX() <= 22 && play1.getY() - play2.getY() >= -112 && play1.getY() - play2.getY() <= 112){
				//���岻�����ϳ���
				if (play1.getName().charAt(1) == '1' && play1.getY() < play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
					areatext.append(play1.getName()+"    ��    "+play2.getName());
				}
				
				//���岻�����³���
				else if (play1.getName().charAt(1) == '2' && play1.getY() > play2.getY() && play1.getName().charAt(1) != play2.getName().charAt(1)){
					play2.setVisible(false);
					//�ѶԷ���λ�ø��Լ�
					play1.setBounds(play2.getX(),play2.getY(),55,55);
					areatext.append(play1.getName()+"    ��    "+play2.getName());
				}			
			}
			
			//��ǰ��¼��ӵ�����(���ڻ���)
			Var.add(String.valueOf(play1.isVisible()));
			Var.add(String.valueOf(play1.getX()));
			Var.add(String.valueOf(play1.getY()));
			Var.add(String.valueOf(Man));
			
			//��ǰ��¼��ӵ�����(���ڻ���)
			Var.add(String.valueOf(play2.isVisible()));
			Var.add(String.valueOf(play2.getX()));
			Var.add(String.valueOf(play2.getY()));
			Var.add(String.valueOf(i));

		}//��Խ���
		
		/**�ڡ����ƶ�����*/
		public void cannonRule(JLabel play,JLabel playQ[],MouseEvent me){
			//�����յ�֮���Ƿ�������
			int Count = 0;
			
			//�ϡ����ƶ�
			if (play.getX() - me.getX() <= 0 && play.getX() - me.getX() >= -55){
				//ָ������ģ��Y����
				for (int i=56;i<=571;i+=57){
					//�ƶ���Y�����Ƿ���ָ�����������
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						//���е�����
						for (int j=0;j<32;j++){
							//�ҳ���ͬһ�����ߵ��������ӡ����������Լ�
							if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
								//����㵽�յ�(������)
								for (int k=play.getY()+57;k<i;k+=57){
									//������㡢С���յ������Ϳ���֪���м��Ƿ�������
									if (playQ[j].getY() < i && playQ[j].getY() > play.getY()){
										//�м���һ�����ӾͲ����Դ��������߹�ȥ
										Count++;
										break;
									}
								}//for
								
								//����㵽�յ�(���ҵ���)
								for (int k=i+57;k<play.getY();k+=57){
									//�������յ������
									if (playQ[j].getY() < play.getY() && playQ[j].getY() > i){
										Count++;
										break;
									}
								}//for
							}//if
						}//for
						
						//�����յ�û�����ӾͿ����ƶ���
						if (Count == 0){
							//��ǰ��¼��ӵ�����(���ڻ���)
							Var.add(String.valueOf(play.isVisible()));
							Var.add(String.valueOf(play.getX()));
							Var.add(String.valueOf(play.getY()));
							Var.add(String.valueOf(Man));
							play.setBounds(play.getX(),i,55,55);
							
							
							if(play.getY() - me.getY()< 0)
								areatext.append(play.getName()+"�����ƶ�");
								
							if(play.getY() - me.getY() > 0)
								
								areatext.append(play.getName()+"�����ƶ�");
							break;
						}
					}//if
				}//for
			}//if
			//�����ƶ�
			else if (play.getY() - me.getY() >=-27 && play.getY() - me.getY() <= 27){
				//ָ������ģ��X����
				for (int i=24;i<=480;i+=57){
					//�ƶ���X�����Ƿ���ָ�����������
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						//���е�����
						for (int j=0;j<32;j++){
							//�ҳ���ͬһ�����ߵ��������ӡ����������Լ�
							if (playQ[j].getY() - play.getY() >= -27 && playQ[j].getY() - play.getY() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
								//����㵽�յ�(���ϵ���)				
								for (int k=play.getX()+57;k<i;k+=57){
									//������㡢С���յ������Ϳ���֪���м��Ƿ�������
									if (playQ[j].getX() < i && playQ[j].getX() > play.getX()){
										//�м���һ�����ӾͲ����Դ��������߹�ȥ
										Count++;
										break;
									}
								}//for
								
								//����㵽�յ�(���µ���)
								for (int k=i+57;k<play.getX();k+=57){
									//�������յ������
									if (playQ[j].getX() < play.getX() && playQ[j].getX() > i){
										Count++;
										break;
									}
								}//for
							}//if
						}//for
						
						//�����յ�û������
						if (Count == 0){
							//��ǰ��¼��ӵ�����(���ڻ���)
							Var.add(String.valueOf(play.isVisible()));
							Var.add(String.valueOf(play.getX()));
							Var.add(String.valueOf(play.getY()));
							Var.add(String.valueOf(Man));
							
							play.setBounds(i,play.getY(),55,55);
							
							
							areatext.append(play.getName()+"�ƶ�");
								

							break;
						}
					}//if
				}//for
			}//else
			
		}//�ڡ����ƶ���������


		/**�ڡ����������*/
		public void cannonRule(int Chess,JLabel play,JLabel playTake,JLabel playQ[],MouseEvent me){
			//�����յ�֮���Ƿ�������
			int Count = 0;

			//���е�����
			for (int j=0;j<32;j++){
				
				//�ҳ���ͬһ�����ߵ��������ӡ����������Լ�
				if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
					//�Լ�����㱻�Ե����յ�(���ϵ���)
					for (int k=play.getY()+57;k<playTake.getY();k+=57){
						//������㡢С���յ������Ϳ���֪���м��Ƿ�������
						if (playQ[j].getY() < playTake.getY() && playQ[j].getY() > play.getY()){
								//���������յ�����Ӹ���
								Count++;								
								break;							
						}
					}//for
								
					//�Լ�����㱻�Ե����յ�(���µ���)
					for (int k=playTake.getY();k<play.getY();k+=57){
						//�������յ������
						if (playQ[j].getY() < play.getY() && playQ[j].getY() > playTake.getY()){
								Count++;	
								break;
						}
					}//for
				}//if
							
				//�ҳ���ͬһ�����ߵ��������ӡ����������Լ�
				 if (playQ[j].getY() - play.getY() >= -10 && playQ[j].getY() - play.getY() <= 10 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
					//�Լ�����㱻�Ե����յ�(������)
					for (int k=play.getX()+50;k<playTake.getX();k+=57){
						//������㡢С���յ������Ϳ���֪���м��Ƿ�������						
						if (playQ[j].getX() < playTake.getX() && playQ[j].getX() > play.getX()){
							Count++;			
							break;	
						}
					}//for
								
					//�Լ�����㱻�Ե����յ�(���ҵ���)
					for (int k=playTake.getX();k<play.getX();k+=57){
						//�������յ������
						if (playQ[j].getX() < play.getX() && playQ[j].getX() > playTake.getX()){
								Count++;
								break;
						}
					}//for
				}//if
			}//for
						
			//�����յ�֮��Ҫһ���������ڵĹ��򡢲����ܳ��Լ�������
			
			if (Count == 1 && Chess == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)
					&&((playTake.getX()==play.getX())||(playTake.getY()==play.getY()))){
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(playTake.isVisible()));
				Var.add(String.valueOf(playTake.getX()));									
				Var.add(String.valueOf(playTake.getY()));
				Var.add(String.valueOf(i));
				
				playTake.setVisible(false);
				play.setBounds(playTake.getX(),playTake.getY(),55,55);
				areatext.append(play.getName()+"    ��    "+playTake.getName());
			}
			
			//�����յ�֮��û�������ǳ��Ĺ��򡢲����ܳ��Լ�������			
			else if (Count ==0  && Chess == 1 && playTake.getName().charAt(1) != play.getName().charAt(1)){
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));									
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(playTake.isVisible()));
				Var.add(String.valueOf(playTake.getX()));									
				Var.add(String.valueOf(playTake.getY()));
				Var.add(String.valueOf(i));
				
				playTake.setVisible(false);
				play.setBounds(playTake.getX(),playTake.getY(),55,55);
				areatext.append(play.getName()+"    ��    "+playTake.getName());
			}
			
		}//�ڡ������巽������
		
		/**���ƶ�����*/
		public void horseRule(JLabel play,JLabel playQ[],MouseEvent me){
			//����������ϰ�
			int Ex=0,Ey=0,Move=0;			
			
			//���ơ����
			if (play.getX() - me.getX() >= 2 && play.getX() - me.getX() <= 57 && play.getY() - me.getY() >= 87 && play.getY() - me.getY() <= 141){
				//�Ϸ���Y����
				for (int i=56;i<=571;i+=57){
					//�ƶ���Y�����Ƿ���ָ�����������
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//�Ϸ���X����
				for (int i=24;i<=480;i+=57){
					//�ƶ���X�����Ƿ���ָ�����������
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
						break;
					}
				}
				
				//��ǰ���Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0  && play.getY() - playQ[i].getY() == 57 ){
						Move = 1;
						break;
					}	
				}
				
				//�����ƶ�������
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
									
					play.setBounds(Ex,Ey,55,55);
				}
				
			}//if
			
			//���ơ��ϱ�
			else if (play.getY() - me.getY() >= 27 && play.getY() - me.getY() <= 86 && play.getX() - me.getX() >= 70 && play.getX() - me.getX() <= 130){
				//Y
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
					}
				}
				
				//X
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
					}
				}
				
				//�����Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57 ){
						Move = 1;
						break;
					}
				}
				
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"���������");
				}
			}//else
			
			//���ơ��ұ�
			else if (me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141 && me.getX() - play.getX() <= 87 && me.getX() - play.getX() >= 2 ){	
				//Y		
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//X
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
						break;
					}
				}
				
				//���·��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0  && playQ[i].getY() - play.getY() == 57 ){
						Move = 1;
						break;
					}
				}
				
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);			
					areatext.append(play.getName()+"���ұ�����");
				}
			}//else
			
			//���ơ��ұ�
			else if (play.getY() - me.getY() >= 87 && play.getY() - me.getY() <= 141 && me.getX() - play.getX() <= 87 && me.getX() - play.getX() >= 30 ){
				//�Ϸ���Y����
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//�Ϸ���X����
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
						break;
					}
				}
				
				//��ǰ���Ƿ��б������
				for (int i=0;i<32;i++){
					
					//System.out.println("play.getX()="+play.getX());
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57 ){
						Move = 1;
						//System.out.println("play.getY()="+play.getY());
						//System.out.println("playQ[i].getY()="+playQ[i].getY());
						break;
					}
				}
				
				//�����ƶ�������
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));	
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"���ұ�����");
				}
			}//else 
			
			//���ơ����
			else if (me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141 && play.getX() - me.getX() <= 87 && play.getX() - me.getX() >= 10 ){
				//�Ϸ���Y����
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//�Ϸ���X����
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
						break;
					}
				}
				
				//���·��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 ){
						Move = 1;
						break;
					}
				}
				
				//�����ƶ�������
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"���������");
				}
			}//else
			
			//���ơ��ϱ�
			else if (play.getY() - me.getY() >= 30 && play.getY() - me.getY() <= 87 && me.getX() - play.getX() <= 141 && me.getX() - play.getX() >= 87 ){
				//Y		
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
					}
				}
				
				//X
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
					}
				}
				
				//���ҷ��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57 ){
						Move = 1;
						break;
					}
				}
				
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"���ϱ�����");
				}
			}//else
			
			//���ơ��±�
			else if (me.getY() - play.getY() >= 30 && me.getY() - play.getY() <= 87 && me.getX() - play.getX() <= 141 && me.getX() - play.getX() >= 87 ){
				//Y		
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
					}
				}
				
				//X
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
					}
				}
				
				//���ҷ��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57 ){
						Move = 1;
						break;
					}
				}
				
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"���±�����");
				}
			}//else
			
			//���ơ��±�
			else if (me.getY() - play.getY() >= 30 && me.getY() - play.getY() <= 87 && play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 ){
				//Y		
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
					}
				}
				
				//X
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -55 && i-me.getX() <= 0){
						Ex = i;
					}
				}
				
				//�����Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57 ){
						Move = 1;
						break;
					}
				}
				
				if (Move == 0){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
				
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"���±�����");
				}
				
			}//else
			
		}//���ƶ�����

		/**��������*/
		public void horseRule(JLabel play,JLabel playTake ,JLabel playQ[],MouseEvent me){
			//�ϰ�
			int Move=0;
			boolean Chess=false;
			
			//���ơ����
			if (play.getName().charAt(1)!=playTake.getName().charAt(1) && play.getX() - playTake.getX() == 57 && play.getY() - playTake.getY() == 114 ){
				//��ǰ���Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57){
						Move = 1;
						break;
					}
				}//for
				
				Chess = true;
				
			}//if
			
			//���ơ��ҳ�
			else if (play.getY() - playTake.getY() == 114 && playTake.getX() - play.getX() == 57 ){
				//��ǰ���Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == 57){
						Move = 1;
						break;
					}
				}//for		
				
				Chess = true;
				
			}//else
			
			//���ơ��ϳ�
			else if (play.getY() - playTake.getY() == 57 && play.getX() - playTake.getX() == 114 ){
				//�����Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57){
						Move = 1;
						break;
					}
				}//for
				
				Chess = true;
				
			}//else
			
			//���ơ��³�
			else if (playTake.getY() - play.getY() == 57 && play.getX() - playTake.getX() == 114 ){
				//�����Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && play.getX() - playQ[i].getX() == 57){
						Move = 1;
						break;
					}
				}//for
				
				Chess = true;
				
			}//else
			
			//���ơ��ϳ�
			else if (play.getY() - playTake.getY() == 57 && playTake.getX() - play.getX() == 114 ){
				//���ҷ��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57){
						Move = 1;
						break;
					}
				}//for
				
				Chess = true;
				
			}//else
			
			//���ơ��³�
			else if (playTake.getY() - play.getY() == 57  && playTake.getX() - play.getX() == 114 ){
				//���ҷ��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getY() - playQ[i].getY() == 0 && playQ[i].getX() - play.getX() == 57){
						Move = 1;
						break;
					}
				}//for
				
				Chess = true;
				
			}//else
			
			//���ơ����
			else if (playTake.getY() - play.getY() == 114 && play.getX() - playTake.getX() == 57 ){
				//���·��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 ){
						Move = 1;
						break;
						
					}
				}//for
				
				Chess = true;
				
			}//else 
			
			//���ơ��ҳ�
			else if (playTake.getY() - play.getY() == 114 && playTake.getX() - play.getX() == 57){
				//���·��Ƿ��б������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 0 && play.getY() - playQ[i].getY() == -57 ){
						Move = 1;
						break;
					}
				}//for
				
				Chess = true;
				
			}//else  
			
			//û���ϰ��������Գ��塢���ܳ��Լ���ɫ
			if (Chess && Move == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)){
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(playTake.isVisible()));
				Var.add(String.valueOf(playTake.getX()));
				Var.add(String.valueOf(playTake.getY()));
				Var.add(String.valueOf(i));			
				
				playTake.setVisible(false);
				play.setBounds(playTake.getX(),playTake.getY(),55,55);
				areatext.append(play.getName()+"    ��    "+playTake.getName());
			}
		}
		
		/**���ƶ�����*/
		public void elephantRule(int Man,JLabel play,JLabel playQ[],MouseEvent me){
			//������ϰ�
			int Ex=0,Ey=0,Move=0;
			
			//����
			if (play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 && play.getY() - me.getY() <= 141 && play.getY() - me.getY() >= 87){
				//�Ϸ���Y����
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//�Ϸ���X����
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -27 && i-me.getX() <= 27){
						Ex = i;
						break;
					}
				}
				
				//���Ϸ��Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == 57){
						Move++;
						break;
					}
				}
				
				//���첻�ܹ�����
				if (Move == 0 && Ey >= 341 && Man > 9){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ� ");
					
				}
				
				//���첻�ܹ�����
				else if (Move == 0 && Ey <= 284 && Man < 10){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ� ");
				}
			}//if
			
			//����
			else if (play.getY() - me.getY() <= 141 && play.getY() - me.getY() >= 87 &&  me.getX() - play.getX() >= 87 && me.getX() - play.getX() <= 141){
				//�Ϸ���Y����
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//�Ϸ���X����
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -27 && i-me.getX() <= 27){
						Ex = i;
						break;
					}
				}
				
				//���Ϸ��Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() &&  playQ[i].getX() - play.getX() == 57 && play.getY() - playQ[i].getY() == 57){
						Move++;
						break;
					}
				}
				
				//�ࡢ�����
				if (Move == 0 && Ey >= 341 && Man > 9){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ� ");
				}
				
				else if (Move == 0 && Ey <= 284 && Man < 10){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ� ");
				}
				
			}// else if 
			
			//����
			else if (play.getX() - me.getX() <= 141 && play.getX() - me.getX() >= 87 && me.getY() - play.getY() <= 141 && me.getY() - play.getY() >= 87){
				//�Ϸ���Y����
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
						break;
					}
				}
				
				//�Ϸ���X����
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -27 && i-me.getX() <= 27){
						Ex = i;
						break;
					}
				}
				
				//�����Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == -57){
						Move++;
						break;
					}
				}			
				
				//�ࡢ�����
				
				if (Move == 0 && Ey >= 341 && Man > 9){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
									
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����·��ƶ� ");
				}
				
				else if (Move == 0 && Ey <= 284 && Man < 10)
				{
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����·��ƶ� ");
				}
			}//else if 
			
			//����
			else if (me.getX() - play.getX() >= 87 &&  me.getX() - play.getX() <= 141 && me.getY() - play.getY() >= 87 && me.getY() - play.getY() <= 141){
				//Y		
				for (int i=56;i<=571;i+=57){
					if (i - me.getY() >= -27 && i - me.getY() <= 27){
						Ey = i;
					}
				}
				
				//X
				for (int i=24;i<=480;i+=57){
					if (i - me.getX() >= -27 && i-me.getX() <= 27){
						Ex = i;
					}
				}
				
				//���ҷ��Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() - play.getY() == 57){
						Move = 1;
						break;
					}
				}
				
				//�ࡢ�����
				if (Move == 0 && Ey >= 341 && Man > 9){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����·��ƶ� ");
				}
				
				else if (Move == 0 && Ey <= 284 && Man < 10){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));									
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(Ex,Ey,55,55);
					areatext.append(play.getName()+"�����·��ƶ� ");
				}
				
			}//else
			
		}//���ƶ�������

		/**�ࡢ��������*/
		public void elephantRule(JLabel play,JLabel playTake,JLabel playQ[]){
			//�ϰ�
			int Move=0;int Ey=0;
			boolean Chess=false;
			
			//�����Ϸ�������
			if (play.getX() - playTake.getX() >= 87 && play.getX() - playTake.getX() <= 141 && play.getY() - playTake.getY() >= 87 && play.getY() - playTake.getY() <= 141){
				//���Ϸ��Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == 57){
						Move++;
						break;
					}
				}//for

				Chess=true;
				
			}//if
			
			//�����Ϸ�������
			else if (playTake.getX() - play.getX() >= 87 && playTake.getX() - play.getX() <= 141 && play.getY() - playTake.getY() >= 87 && play.getY() - playTake.getY() <= 141 ){
				//���Ϸ��Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() &&  playQ[i].getX() - play.getX() == 57 && play.getY() - playQ[i].getY() == 57 ){
						Move++;
						break;
					}
				}//for	
				
				Chess=true;
			}//else
			
			//�����󷽵�����
			else if (play.getX() - playTake.getX() >= 87 && play.getX() - playTake.getX() <= 141 && playTake.getY() - play.getY() >= 87 && playTake.getY() - play.getY() <= 141){
				//�����Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && play.getX() - playQ[i].getX() == 57 && play.getY() - playQ[i].getY() == -57 ){
						Move++;
						break;
					}
				}//for
				
				Chess=true;
			}//else
			
			//�����ҷŵ�����
			else if (playTake.getX() - play.getX() >= 87 && playTake.getX() - play.getX() <= 141 && playTake.getY() - play.getY() >= 87 && playTake.getY() - play.getY() <= 141){
				//���ҷ��Ƿ�������
				for (int i=0;i<32;i++){
					if (playQ[i].isVisible() && playQ[i].getX() - play.getX() == 57 && playQ[i].getY() - play.getY() == 57 ){
						Move = 1;
						break;
					}
				}//for		

				Chess=true;
				
			}//else
			
			//û���ϰ��������ܳ��Լ�������
			
			for (int i=56;i<=571;i+=57){
				if (i - playTake.getY() >= -27 && i - playTake.getY() <= 27)
					Ey = i;
			}
			if (Chess && Move == 0 && playTake.getName().charAt(1) != play.getName().charAt(1)&&((Ey >=341&&chessPlayClick==2)||(Ey <=284&&chessPlayClick==1))){
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(playTake.isVisible()));
				Var.add(String.valueOf(playTake.getX()));
				Var.add(String.valueOf(playTake.getY()));
				Var.add(String.valueOf(i));
				
				playTake.setVisible(false);
				play.setBounds(playTake.getX(),playTake.getY(),55,55);
				areatext.append(play.getName()+"    ��    "+playTake.getName());
			}
			
		}//�ࡢ�����������
		
		/**ʿ�����ƶ�����*/
		public void chapRule(int Man,JLabel play,JLabel playQ[],MouseEvent me){
			//�ϡ���
			if (me.getX() - play.getX() >= 29 && me.getX() - play.getX() <= 114 && play.getY() - me.getY() >= 25 && play.getY() - me.getY() <= 90){
				//ʿ���ܳ����Լ��Ľ���
				if (Man < 14 && (play.getX()+57) >= 195 && (play.getX()+57) <= 309 && (play.getY()-57) <= 170){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()+57,play.getY()-57,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ�");
				}	
				
				//�˲��ܳ����Լ��Ľ���
				else if (Man > 13 && (play.getY()-57) >= 455 && (play.getX()+57)  >= 195 && (play.getX()+57) <= 309){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()+57,play.getY()-57,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ�");
				}	
			}// else if 
			
			//�ϡ���
			else if (play.getX() - me.getX() <= 114 && play.getX() - me.getX() >= 25 && play.getY() - me.getY() >= 20 && play.getY() - me.getY() <= 95){
				//ʿ���ܳ����Լ��Ľ���
				if (Man < 14 &&  (play.getX()-57) >= 195 && (play.getX()-57) <= 309 && (play.getY()-57) <= 170  ){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()-57,play.getY()-57,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ�");
				}	
				
				//�˲��ܳ����Լ��Ľ���
				else if (Man > 13 &&(play.getY()-57) >= 455 && (play.getX()-57)  >= 195 && (play.getX()-57) <= 309){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()-57,play.getY()-57,55,55);
					areatext.append(play.getName()+"�����Ϸ��ƶ�");
				}	
			}// else if 
			
			//�¡���
			else if (play.getX() - me.getX() <= 114 && play.getX() - me.getX() >= 20 && me.getY() - play.getY() >= 2 && me.getY() - play.getY() <= 87){
				//ʿ���ܳ����Լ��Ľ���
				if (Man < 14 && (play.getX()-57) >= 195 && (play.getX()-57) <= 309 && (play.getY()+57) <= 170 ){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()-57,play.getY()+57,55,55);
					areatext.append(play.getName()+"�����·��ƶ�");
				}	
				
				//�˲��ܳ����Լ��Ľ���
				else if (Man > 13 && (play.getY()+57) >= 455 && (play.getX()-57)  >= 195 && (play.getX()-57) <= 309){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					
					play.setBounds(play.getX()-57,play.getY()+57,55,55);
					areatext.append(play.getName()+"�����·��ƶ�");
				}
				
			}// else if 
			
			
			//�¡���
			else if (me.getX() - play.getX() >= 27 && me.getX() - play.getX() <= 114 && me.getY() - play.getY() >= 2 && me.getY() - play.getY() <= 87){
				//ʿ���ܳ����Լ��Ľ���
				if (Man < 14 && (play.getX()+57) >= 195 && (play.getX()+57) <= 309 && (play.getY()+57) <= 170){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()+57,play.getY()+57,55,55);
					areatext.append(play.getName()+"�����·��ƶ�");
				}
				
				//�˲��ܳ����Լ��Ľ���
				else if (Man > 13 &&(play.getY()+57) >= 455 && (play.getX()+57)  >= 195 && (play.getX()+57) <= 309){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()+57,play.getY()+57,55,55);
					areatext.append(play.getName()+"�����·��ƶ�");
				}
			}//else if 
			
		}//ʿ�����ƶ��������


		/**ʿ���˳������*/
		public void chapRule(int Man ,JLabel play,JLabel playTake,JLabel playQ[]){
			//��ǰ״̬
			boolean Chap = false;	
			
			//�ϡ���
			if (playTake.getX() - play.getX() >= 20 && playTake.getX() - play.getX() <= 114 && play.getY() - playTake.getY() >= 2 && play.getY() - playTake.getY() <= 87){
				//���Ե������Ƿ�͵�ǰʿ���
				if (Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
					Chap = true;
				}
				
				//���Ե������Ƿ�͵�ǰ�����
				else if (Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
					Chap = true;
				}
			}//if
			
			//�ϡ���
			else if (play.getX() - playTake.getX() <= 114 && play.getX() - playTake.getX() >= 25 && play.getY() - playTake.getY() >= 2 && play.getY() - playTake.getY() <= 87){
				//���Ե������Ƿ�͵�ǰʿ���
				if (Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
					Chap = true;
				}
				
				//���Ե������Ƿ�͵�ǰ�����
				else if (Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
					Chap = true;
				}
			}// else if 
			
			//�¡���
			else if (play.getX() - playTake.getX() <= 114 && play.getX() - playTake.getX() >= 25 && playTake.getY() - play.getY() >= 2 && playTake.getY() - play.getY() <= 87){
				//���Ե������Ƿ�͵�ǰʿ���
				if (Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
					Chap = true;
				}
				
				//���Ե������Ƿ�͵�ǰ�����
				else if (Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
					Chap = true;
				}
			}// else if 
			
			//�¡���
			else if (playTake.getX() - play.getX() >= 25 && playTake.getX() - play.getX() <= 114 && playTake.getY() - play.getY() >= 2 && playTake.getY() - play.getY() <= 87){
				//���Ե������Ƿ�͵�ǰʿ���
				if (Man < 14 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170 && playTake.isVisible()){
					Chap = true;
				}
				
				//���Ե������Ƿ�͵�ǰ�����
				else if (Man > 13 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() >= 455 && playTake.isVisible()){
					Chap = true;
				}
			}//else if 
			
			//���ƶ��������ܳ��Լ�������
			if (Chap && playTake.getName().charAt(1) != play.getName().charAt(1)){
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(playTake.isVisible()));
				Var.add(String.valueOf(playTake.getX()));
				Var.add(String.valueOf(playTake.getY()));
				Var.add(String.valueOf(i));
				
				playTake.setVisible(false);
				play.setBounds(playTake.getX(),playTake.getY(),55,55);
				areatext.append(play.getName()+"    ��    "+playTake.getName());
			}
			
		}//ʿ���˳���������
		
		/**���ƶ�����*/
		public void willRule(int Man,JLabel play,JLabel playQ[],MouseEvent me){
			//����
			if ((me.getX()-play.getX()) >= 0 && (me.getX()-play.getX()) <= 55 && (play.getY()-me.getY()) >=2 && play.getY()-me.getY() <= 87){
				//���Ƿ񳬹��Լ��Ľ���
				if (Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX(),play.getY()-57,55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}	
				
				//˧�Ƿ񳬹��Լ��Ľ���
				else if (Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX(),play.getY()-57,55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
			}//if
			
			//����
			else if (play.getX() - me.getX() >= 2 && play.getX() - me.getX() <= 57 && me.getY() - play.getY() <= 27 && me.getY() - play.getY() >= -27){
				//���Ƿ񳬹��Լ��Ľ���
				if (Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()-57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
				
				//˧�Ƿ񳬹��Լ��Ľ���
				else if (Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()-57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
			}//else if 
			
			//����
			else if (me.getX() - play.getX() >= 57 && me.getX() - play.getX() <= 112 && me.getY() - play.getY() <= 27 && me.getY() - play.getY() >= -27){
				//����˧����
				if (Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()+57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}	
				
				else if (Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));	
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX()+57,play.getY(),55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
			}//else if 
			
			//����
			else if (me.getX() - play.getX() >= 0 && me.getX() - play.getX() <= 55 && me.getY() - play.getY() <= 87 && me.getY() - play.getY() >= 27){
				//����˧����
				if (Man == 30 && me.getX() >= 195 && me.getX() <= 359 && me.getY() <= 170){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
					
					play.setBounds(play.getX(),play.getY()+57,55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}
				
				else if (Man == 31 && me.getY() >= 455 && me.getX() >= 195 && me.getX() <= 359){
					//��ǰ��¼��ӵ�����(���ڻ���)
					Var.add(String.valueOf(play.isVisible()));
					Var.add(String.valueOf(play.getX()));
					Var.add(String.valueOf(play.getY()));
					Var.add(String.valueOf(Man));
				
					play.setBounds(play.getX(),play.getY()+57,55,55);
					areatext.append(play.getName()+"�����ƶ�");
				}

			}//else if
			
		}//����˧�ƶ��������

		public void willRule(int Man ,JLabel play,JLabel playTake ,JLabel playQ[]){
			//��ǰ״̬
			boolean will = false;
			int count1=0;
			String playname=playTake.getIcon().toString();
			for (int j=0;j<32;j++){
				
				//�ҳ���ͬһ�����ߵ��������ӡ����������Լ�
				if (playQ[j].getX() - play.getX() >= -27 && playQ[j].getX() - play.getX() <= 27 && playQ[j].getName()!=play.getName() && playQ[j].isVisible()){
					//�Լ�����㱻�Ե����յ�(���ϵ���)
					for (int k=play.getY()+57;k<playTake.getY();k+=57){
						//������㡢С���յ������Ϳ���֪���м��Ƿ�������
						if (playQ[j].getY() < playTake.getY() && playQ[j].getY() > play.getY()){
								//���������յ�����Ӹ���
								count1++;								
								break;							
						}
					}//for
								
					//�Լ�����㱻�Ե����յ�(���µ���)
					for (int k=playTake.getY();k<play.getY();k+=57){
						//�������յ������
						if (playQ[j].getY() < play.getY() && playQ[j].getY() > playTake.getY()){
								count1++;	
								break;
						}
					}//for
				}}
			if(count1==0&&(playname == "image\\�콫.GIF"||playname == "image\\�ڽ�.GIF"))
				will = true;
			//���ϳ�
			else if (play.getX() - playTake.getX() >= 0 && play.getX() - playTake.getX() <= 55 && play.getY() - playTake.getY() >= 27 && play.getY() - playTake.getY() <= 87 && playTake.isVisible()){
				//���Ե������Ƿ�͵�ǰ�����
				if (Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
					will = true;
				}
				
				//���Ե������Ƿ�͵�ǰ˧���
				else if (Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
					will = true; 
				}
			}
			
			//�����
			else if (play.getX() - playTake.getX() >= 2 && play.getX() - playTake.getX() <= 57 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= -27 && playTake.isVisible()){
				//���Ե������Ƿ�͵�ǰ�����
				if (Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
					will = true;
				}
				
				//���Ե������Ƿ�͵�ǰ˧���
				else if (Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
					will = true; 
				}
			}
			
			//���ҳ�
			else if (playTake.getX() - play.getX() >= 2 && playTake.getX() - play.getX() <= 57 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= -27 && playTake.isVisible()){
				//���Ե������Ƿ�͵�ǰ�����
				if (Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
					will = true;
				}
				
				//���Ե������Ƿ�͵�ǰ˧���
				else if (Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
					will = true; 
				}
			}
			
			//����
			else if (playTake.getX() - play.getX() >= 0 && playTake.getX() - play.getX() <= 87 && playTake.getY() - play.getY() <= 27 && playTake.getY() - play.getY() >= 40 && playTake.isVisible()){
				//���Ե������Ƿ�͵�ǰ�����
				if (Man == 30 && playTake.getX() >= 195 && playTake.getX() <= 309 && playTake.getY() <= 170){
					will = true;
				}
				
				//���Ե������Ƿ�͵�ǰ˧���
				else if (Man == 31 && playTake.getY() >= 455 && playTake.getX() >= 195 && playTake.getX() <= 309){
					will = true; 
				}
			}
				
			//���ܳ��Լ������ӡ����ϵ�ǰҪ��	
			if (playTake.getName().charAt(1) != play.getName().charAt(1) && will){
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(play.isVisible()));
				Var.add(String.valueOf(play.getX()));
				Var.add(String.valueOf(play.getY()));
				Var.add(String.valueOf(Man));
				
				//��ǰ��¼��ӵ�����(���ڻ���)
				Var.add(String.valueOf(playTake.isVisible()));
				Var.add(String.valueOf(playTake.getX()));
				Var.add(String.valueOf(playTake.getY()));
				Var.add(String.valueOf(i));

				playTake.setVisible(false);
				play.setBounds(playTake.getX(),playTake.getY(),55,55);
				areatext.append(play.getName()+"    ��    "+playTake.getName());
			}			
			
		}//����˧�Թ������
		
	}//������
	
}//�������