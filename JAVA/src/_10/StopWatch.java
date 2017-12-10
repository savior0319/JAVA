package _10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatch extends JFrame implements ActionListener, Runnable{

	int start = 60;
	
	private Container ct = getContentPane();
	private JLabel jl = new JLabel(start + " 초", JLabel.CENTER);     
	private JButton jb1 = new JButton("시작");
	private JButton jb2 = new JButton("정지");
	private JButton jb3 = new JButton("리셋");
	private JPanel jp = new JPanel();
	private Thread t;

	public StopWatch() {
		setTitle("60초 스톱워치");
		setSize(250,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		jl.setFont(new Font("굴림", Font.BOLD,20));
		ct.add(jl, BorderLayout.CENTER);
		jp.setLayout(new GridLayout(1,3)); 
		jp.add(jb1); jp.add(jb2); jp.add(jb3);
		ct.add(jp, BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StopWatch().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		if(arg0.getSource()==jb1) {
			t= new Thread(this);
			t.start();
			jb1.setEnabled(false);
			jb3.setEnabled(false);
		} 	else if(arg0.getSource()==jb2) {
			pause();
			jb1.setEnabled(true);
			jb3.setEnabled(true);
		} else {
			start = 60;
			jl.setText(start+" 초");
		}
	} 

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000);
				start--;
				jl.setText(start + " 초");
			}	
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void pause() {
		t.interrupt();
	}
}
