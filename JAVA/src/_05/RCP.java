package _05;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class RCP extends JFrame implements ActionListener{
	private Random rd = new Random();
	private JLabel jlcomLabel = new JLabel(); 
	private JLabel jluserLabel = new JLabel();
	private JLabel jlcomResult = new JLabel(); //com 결과
	private JLabel jluserReult = new JLabel(); // user 결과
	private JLabel jlPlay = new JLabel();
	private JComboBox<String> jbbrcp = new JComboBox<String>(); // 선택메뉴
	private JButton jbPlay = new JButton(); // 시작버튼
	private JLabel jlgr = new JLabel();
	private JTextArea jfa = new JTextArea(); // 결과 화면
	private JScrollPane scrollPane = new JScrollPane(jfa); // JTextArea 스크롤 추가
	private Border lineBorder = BorderFactory.createLineBorder(Color.black, 1); // JTextArea 테두리
	private Container ct = getContentPane();
	private String txt;

	public RCP() {
		setTitle("가위바위보 게임");
		setSize(350,450);
		setLayout(null); // 레이아웃
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		jlcomLabel.setText("Com");
		jluserLabel.setText("User");
		jlcomResult.setText(" ?");
		jlcomResult.setFont(new Font("궁서",Font.BOLD,30));
		jluserReult.setText(" ?");
		jluserReult.setFont(new Font("궁서",Font.BOLD,30));
		jlPlay.setText("Play Game");
		jbbrcp.addItem("가위");
		jbbrcp.addItem("바위");
		jbbrcp.addItem("보");
		jbPlay.setText("Play Game");
		jlgr.setText("※ Game Result");
		
		jlcomLabel.setBounds(80,20,30,10);
		jluserLabel.setBounds(210,20,30,10);
		jlcomResult.setBounds(70,30,90,50);
		jluserReult.setBounds(195,30,90,50);
		jlPlay.setBounds(20,90,60,30);
		jbbrcp.setBounds(95,90,60,30);
		jbPlay.setBounds(170,90,140,30);
		jlgr.setBounds(10,140,90,20);
		scrollPane.setBounds(5,160,326,250);
		
		jfa.setBorder(BorderFactory.createCompoundBorder(lineBorder,null)); // 테두리 설정
		
		ct.add(jlcomLabel);
		ct.add(jluserLabel);
		ct.add(jlcomResult);
		ct.add(jluserReult);
		ct.add(jlPlay);
		ct.add(jbbrcp);
		ct.add(jbPlay);
		ct.add(jlgr);
		ct.add(scrollPane);

		jbPlay.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RCP().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jbPlay) {
			String save = null; // 비교할 값 저장 
			int ran = rd.nextInt(3); // 0 가위 1 바위 2 보
			if(ran==0) {
				jlcomResult.setText("가위");
				save = "가위";
			} else if(ran==1) {
				jlcomResult.setText("바위");
				save = "바위";
			} else if(ran==2) {
				jlcomResult.setText("보");
				save = "보";
			}
		
			if((jbbrcp.getSelectedItem()=="가위") && (save.equals("가위"))) {
			jluserReult.setText("가위");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:가위, User:가위 -(비김)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="가위") && (save.equals("바위"))) {
				jluserReult.setText("가위");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:바위, User:가위 -(패배)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="가위") && (save.equals("보"))) {
				jluserReult.setText("가위");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:보, User:가위 -(승리)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="바위") && (save.equals("가위"))) {
				jluserReult.setText("바위");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:가위, User:바위 -(승리)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="바위") && (save.equals("바위"))) {
				jluserReult.setText("바위");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:바위, User:바위 -(비김)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="바위") && (save.equals("보"))) {
				jluserReult.setText("바위");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:보, User:바위 -(패배)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="보") && (save.equals("가위"))) {
				jluserReult.setText("보");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:가위, User:보 -(패배)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="보") && (save.equals("바위"))) {
				jluserReult.setText("보");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:바위, User:보 -(승리)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="보") && (save.equals("보"))) {
				jluserReult.setText("보");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:보, User:보 -(비김)"+System.lineSeparator());
				txt = jfa.getText();
			}
	
			try {
				FileWriter fw = new FileWriter(new File("가위바위보 게임.txt"));
				fw.write(txt);
				fw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	private String getCurrentTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(new Date());
	}
}