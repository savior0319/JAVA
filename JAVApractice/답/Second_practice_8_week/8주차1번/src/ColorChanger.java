import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorChanger extends Thread{
	JPanel panel;
	JTextField tf1;
	JTextField tf2;
	JTextField tf3;
	
	public ColorChanger(JPanel panel,JTextField tf1,JTextField tf2,JTextField tf3) {
		this.panel = panel;
		this.tf1 = tf1;
		this.tf3 = tf2;
		this.tf2 = tf3;
	}
	@Override
	public void run() {
		try {
			while (true) {
				int r = Integer.parseInt(tf1.getText());
				int g = Integer.parseInt(tf2.getText());
				int b = Integer.parseInt(tf3.getText());
				panel.setBackground(new Color(r, g, b));
				sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
