package Ex1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);
	}
}

class UI extends JFrame{
	Container ct = getContentPane();
	JPanel nPanel = new JPanel();
	JPanel cPanel = new JPanel();
	JPanel sPanel = new JPanel();
	JButton[] btnArr = new JButton[9];
	public UI() {
		setTitle("자바 실습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		ct.setLayout(new GridLayout(3,1));
		
		
		nPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,60));
		for (int i = 0; i < 3; i++) {
			btnArr[i] = new JButton(Integer.toString(i+1));
			nPanel.add(btnArr[i]);
		}
		cPanel.setLayout(new GridLayout(1, 3));
		for (int i = 3; i < 6; i++) {
			btnArr[i] = new JButton(Integer.toString(i+1));
			cPanel.add(btnArr[i]);
		}
		sPanel.setLayout(new BorderLayout());
		for (int i = 6; i < 9; i++) {
			btnArr[i] = new JButton(Integer.toString(i+1));
		}
		sPanel.add(btnArr[6], BorderLayout.WEST);
		sPanel.add(btnArr[7], BorderLayout.CENTER);
		sPanel.add(btnArr[8], BorderLayout.EAST);
		
		ct.add(nPanel);
		ct.add(cPanel);
		ct.add(sPanel);
		
		
	}
}