package _04;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time extends JFrame implements ActionListener{

	private JButton jb1 = new JButton("���� �ð� ���");
	private JTextField jf1 = new JTextField("���� �ð�");
	private JButton jb2 = new JButton("N �ð� �� ���");
	private JTextField jf2 = new JTextField();
	TextHint hint1 = new TextHint(jf2, "N �ð� �Է�");
	private JTextField jf3 = new JTextField("N �ð� ���� �ð�");
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private Calendar calendar = Calendar.getInstance(); // calendar �ν��Ͻ� ����
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� " + "MM�� " +"dd�� " + "HH�� " + "mm�� " +"ss�� ");
	// �ð� ��� ���� yyyyMMddhhmmss
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Time().setVisible(true);
	}
	
	public Time() {
		setTitle("�ð� ��� ���α׷�");
		setSize(800,130);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new GridLayout(2,1,0,0)); // ��ü ���̾ƿ� - Grid
		
		jp1.setLayout(new GridLayout(1,2,0,0));
		jp1.add(jb1);
		jp1.add(jf1);
		
		jp2.setLayout(new GridLayout(1,3,0,0));
		jp2.add(jb2);
		jp2.add(jf2);
		jp2.add(jf3);
		
		ct.add(jp1, new GridLayout(1,1));
		ct.add(jp2, new GridLayout(2,1));
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1) { // ���� �ð� ��ư
			String currentTime = sdf.format(calendar.getTime()); 
			jf1.setText("���� �ð� : " + currentTime);
		}
		else { // N �ð� ��  ��ư
			int N = Integer.parseInt(jf2.getText());
			calendar.add(Calendar.HOUR, N);
			String afterTime = sdf.format(calendar.getTime());
			jf3.setText(afterTime);
		}
	}

}
