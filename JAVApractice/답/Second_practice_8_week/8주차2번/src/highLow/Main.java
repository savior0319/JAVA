package highLow;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);;
	}

}


class UI extends JFrame implements ActionListener {
	Container ct = getContentPane();
	JPanel panel = new JPanel(new GridLayout(3, 1));
	JButton btn = new JButton("»Æ¿Œ");
	JTextField tf = new JTextField();
	JTextArea jta = new JTextArea();
	JLabel lb = new JLabel("count...");
	
	public UI() {
		setSize(300,400);
		ct.setLayout(new BorderLayout());
		lb.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lb);
		panel.add(tf);
		panel.add(btn);
		ct.add(jta,BorderLayout.CENTER);
		ct.add(panel, BorderLayout.SOUTH);
		
		btn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			int inputNum = Integer.parseInt(tf.getText());
			HighLow highLow = new HighLow(inputNum, jta, lb);
			highLow.start();
		}
		
	}
	
	
}
