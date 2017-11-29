
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);

	}
}

class UI extends JFrame implements ActionListener{
	Container ct = getContentPane();
	JLabel lb = new JLabel();
	JButton btn = new JButton("변경");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel(new GridLayout(3, 1));
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	public UI() {
		setTitle("패널 색상 변경");
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lb.setHorizontalAlignment(JLabel.CENTER);
		ct.setLayout(new GridLayout(1, 3));
		panel2.add(tf1);
		panel2.add(tf2);
		panel2.add(tf3);
		ct.add(panel1);
		ct.add(panel2);
		ct.add(btn);
		btn.addActionListener(this);
		
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btn) {
			ColorThread red = new ColorThread(tf1); //red
			ColorThread green = new ColorThread(tf2); //green
			ColorThread blue = new ColorThread(tf3); //blue
			red.start();
			green.start();
			blue.start();
			ColorChanger cc = new ColorChanger(panel1, tf1, tf2, tf3);
			cc.start();
			
		}
	}
}
