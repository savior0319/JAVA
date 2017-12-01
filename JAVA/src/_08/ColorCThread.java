package _08;

import javax.swing.JTextField;

public class ColorCThread extends Thread {
	
	private JTextField jtf;

	public ColorCThread(JTextField jtf) {
		// TODO Auto-generated constructor stub
		this.jtf = jtf;
	}
	public void run() {
		
		try {
			while (true) {
				int ijtf = Integer.parseInt(jtf.getText());
				while(ijtf>=1) {
				ijtf--;
				String A = String.valueOf(ijtf);
				jtf.setText(A);
				sleep(100);
				}
			}
		
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
