package _08;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorChange extends Thread{
	
	private JTextField jt1;
	private JTextField jt2;
	private JTextField jt3;
	private JPanel jpcolor;
	
	public ColorChange(JTextField jt1, JTextField jt2, JTextField jt3, JPanel jpcolor) {
		// TODO Auto-generated constructor stub
		this.jt1 = jt1;
		this.jt2 = jt2;
		this.jt3 = jt3;
		this.jpcolor = jpcolor;
	}
	public void run() {

		try {
			while (true) {
				int R = Integer.parseInt(jt3.getText());
				int G = Integer.parseInt(jt2.getText());
				int B = Integer.parseInt(jt1.getText());
				jpcolor.setBackground(new Color(R,G,B));
				sleep(100);
	
				}
		
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}

