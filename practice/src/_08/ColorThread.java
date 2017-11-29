package _08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorThread extends JFrame implements ActionListener{

	private Container ct = getContentPane();
	private JPanel jpcolor = new JPanel();
	private JPanel jp = new JPanel();
	private JPanel jp1 = new JPanel();
	private JButton jb = new JButton("확인");
	private JTextField[] jt = new JTextField[3];
	
	public ColorThread() {
		setTitle("색상 쓰레드");
		setSize(250,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		ct.add(jpcolor, BorderLayout.CENTER);
		jp1.setLayout(new BorderLayout());
		jp.setLayout(new GridLayout(1,3));
		jp.add(jt[0] = new JTextField(), JTextField.CENTER);
		jp.add(jt[1] = new JTextField(), JTextField.CENTER);
		jp.add(jt[2] = new JTextField(), JTextField.CENTER);
		jp1.add(jp, BorderLayout.CENTER);
		jp1.add(jb, BorderLayout.SOUTH);
		ct.add(jp1, BorderLayout.SOUTH);
		
		jb.addActionListener(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ColorThread().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
		ColorChange cc = new ColorChange(jt[0],jt[1],jt[2], jpcolor);
		ColorCThread red = new ColorCThread(jt[2]); 
		ColorCThread green = new ColorCThread(jt[1]); 
		ColorCThread blue = new ColorCThread(jt[0]); 
		cc.start();
		red.start();
		green.start();
		blue.start();
	

		}
	}

}
