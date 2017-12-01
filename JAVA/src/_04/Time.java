package _04;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time extends JFrame implements ActionListener{

	private JButton jb1 = new JButton("현재 시간 출력");
	private JTextField jf1 = new JTextField("현재 시간");
	private JButton jb2 = new JButton("N 시간 후 출력");
	private JTextField jf2 = new JTextField();
	TextHint hint1 = new TextHint(jf2, "N 시간 입력");
	private JTextField jf3 = new JTextField("N 시간 후의 시간");
	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private Calendar calendar = Calendar.getInstance(); // calendar 인스턴스 생성
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 " + "MM월 " +"dd일 " + "HH시 " + "mm분 " +"ss초 ");
	// 시간 출력 포맷 yyyyMMddhhmmss
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Time().setVisible(true);
	}
	
	public Time() {
		setTitle("시간 출력 프로그램");
		setSize(800,130);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ct.setLayout(new GridLayout(2,1,0,0)); // 전체 레이아웃 - Grid
		
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
		if(arg0.getSource()==jb1) { // 현재 시간 버튼
			String currentTime = sdf.format(calendar.getTime()); 
			jf1.setText("현재 시간 : " + currentTime);
		}
		else { // N 시간 후  버튼
			int N = Integer.parseInt(jf2.getText());
			calendar.add(Calendar.HOUR, N);
			String afterTime = sdf.format(calendar.getTime());
			jf3.setText(afterTime);
		}
	}

}
