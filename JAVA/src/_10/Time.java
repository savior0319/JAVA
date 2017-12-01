package _10;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;

public class Time extends JFrame implements Runnable{

	private Container ct = getContentPane();
	private JLabel jl = new JLabel();
	
	public Time() {
		setTitle("시간출력");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		jl.setFont(new Font("굴림", Font.BOLD, 20));
		ct.add(jl, BorderLayout.CENTER);
		Thread t = new Thread(this);
		t.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Time().setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
		try {
				SimpleDateFormat sdf = new SimpleDateFormat(" YYYY-MM-dd HH:mm:ss:SSS ");
				jl.setText(" "+sdf.format(new Date()));
				Thread.sleep(10);
			}
		 catch (Exception e) {
			e.printStackTrace();
		 	}
		}
	}
}