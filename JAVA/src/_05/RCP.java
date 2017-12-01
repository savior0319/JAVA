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
	private JLabel jlcomResult = new JLabel(); //com ���
	private JLabel jluserReult = new JLabel(); // user ���
	private JLabel jlPlay = new JLabel();
	private JComboBox<String> jbbrcp = new JComboBox<String>(); // ���ø޴�
	private JButton jbPlay = new JButton(); // ���۹�ư
	private JLabel jlgr = new JLabel();
	private JTextArea jfa = new JTextArea(); // ��� ȭ��
	private JScrollPane scrollPane = new JScrollPane(jfa); // JTextArea ��ũ�� �߰�
	private Border lineBorder = BorderFactory.createLineBorder(Color.black, 1); // JTextArea �׵θ�
	private Container ct = getContentPane();
	private String txt;

	public RCP() {
		setTitle("���������� ����");
		setSize(350,450);
		setLayout(null); // ���̾ƿ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		jlcomLabel.setText("Com");
		jluserLabel.setText("User");
		jlcomResult.setText(" ?");
		jlcomResult.setFont(new Font("�ü�",Font.BOLD,30));
		jluserReult.setText(" ?");
		jluserReult.setFont(new Font("�ü�",Font.BOLD,30));
		jlPlay.setText("Play Game");
		jbbrcp.addItem("����");
		jbbrcp.addItem("����");
		jbbrcp.addItem("��");
		jbPlay.setText("Play Game");
		jlgr.setText("�� Game Result");
		
		jlcomLabel.setBounds(80,20,30,10);
		jluserLabel.setBounds(210,20,30,10);
		jlcomResult.setBounds(70,30,90,50);
		jluserReult.setBounds(195,30,90,50);
		jlPlay.setBounds(20,90,60,30);
		jbbrcp.setBounds(95,90,60,30);
		jbPlay.setBounds(170,90,140,30);
		jlgr.setBounds(10,140,90,20);
		scrollPane.setBounds(5,160,326,250);
		
		jfa.setBorder(BorderFactory.createCompoundBorder(lineBorder,null)); // �׵θ� ����
		
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
			String save = null; // ���� �� ���� 
			int ran = rd.nextInt(3); // 0 ���� 1 ���� 2 ��
			if(ran==0) {
				jlcomResult.setText("����");
				save = "����";
			} else if(ran==1) {
				jlcomResult.setText("����");
				save = "����";
			} else if(ran==2) {
				jlcomResult.setText("��");
				save = "��";
			}
		
			if((jbbrcp.getSelectedItem()=="����") && (save.equals("����"))) {
			jluserReult.setText("����");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:����, User:���� -(���)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="����") && (save.equals("����"))) {
				jluserReult.setText("����");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:����, User:���� -(�й�)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="����") && (save.equals("��"))) {
				jluserReult.setText("����");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:��, User:���� -(�¸�)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="����") && (save.equals("����"))) {
				jluserReult.setText("����");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:����, User:���� -(�¸�)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="����") && (save.equals("����"))) {
				jluserReult.setText("����");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:����, User:���� -(���)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="����") && (save.equals("��"))) {
				jluserReult.setText("����");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:��, User:���� -(�й�)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="��") && (save.equals("����"))) {
				jluserReult.setText("��");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:����, User:�� -(�й�)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="��") && (save.equals("����"))) {
				jluserReult.setText("��");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:����, User:�� -(�¸�)"+System.lineSeparator());
				txt = jfa.getText();
			} else if ((jbbrcp.getSelectedItem()=="��") && (save.equals("��"))) {
				jluserReult.setText("��");
				jfa.append("   "+getCurrentTime()+"\t"+"Com:��, User:�� -(���)"+System.lineSeparator());
				txt = jfa.getText();
			}
	
			try {
				FileWriter fw = new FileWriter(new File("���������� ����.txt"));
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