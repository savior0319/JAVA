package Ex1;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);
	}
}

class UI extends JFrame implements ActionListener{
	Container ct = getContentPane();
	JPanel northPanel = new JPanel();
	JTextField tf = new JTextField();
	JButton btn = new JButton("ÆÇº°");
	JLabel lb = new JLabel();
	
	public UI() {
		setTitle("È¦Â¦ ÆÇº°±â");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250,100);
		ct.setLayout(new GridLayout(2,1));
		ct.add(northPanel);
		ct.add(lb);
		
		northPanel.setLayout(new GridLayout(1, 2));
		northPanel.add(tf);
		northPanel.add(btn);
		
		btn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int inputNum = Integer.parseInt(tf.getText());
		if (inputNum%2 ==1) { // È¦¼ö
			lb.setText("È¦¼ö ÀÔ´Ï´Ù");
		}else {
			lb.setText("Â¦¼ö ÀÔ´Ï´Ù");
		}
	}
}
