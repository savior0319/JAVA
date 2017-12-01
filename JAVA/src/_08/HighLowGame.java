package _08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HighLowGame extends JFrame implements ActionListener{
	
	private Container ct = getContentPane();
	private JLabel jl1 = new JLabel("1~100 사이 숫자를 입력.");
	private JLabel jl2 = new JLabel("입력 내용");
	private JLabel jl3 = new JLabel("시도 횟수 : 총 0 회");
	private JTextField jt = new JTextField();
	private JTextArea jta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(jta);
	private JButton jb1 = new JButton("새 게임");
	private JButton jb2 = new JButton("확 인");
	
	public HighLowGame() {
		setLayout(null);
		setTitle("하이로우게임");
		setSize(500,300);
		setResizable(false);
		
		jl1.setBounds(20,80,150,20);
		jt.setBounds(50,110,70,30);
		jb1.setBounds(170,75,80,30);
		jb2.setBounds(170,115,80,30);
		jl2.setBounds(350,10,80,20);
		jsp.setBounds(290,40,170,180);
		jta.setEditable(false);
		jl3.setBounds(320,230,120,20);
		
		ct.add(jl1);
		ct.add(jt);
		ct.add(jb1);
		ct.add(jb2);
		ct.add(jl2);
		ct.add(jsp);
		ct.add(jl3);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HighLowGame().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int get = Integer.parseInt(jt.getText());
		Highlow hl = new Highlow(get, jta, jl3);
		if(arg0.getSource()==jb2) {
			hl.start();
			}
		if(arg0.getSource()==jb1) {
			jta.setText(null);
		}
	}
}




