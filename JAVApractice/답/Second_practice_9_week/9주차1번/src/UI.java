import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI extends JFrame {

	public UI() {
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel centor = new JPanel();
		JPanel bottom = new JPanel();
		
		centor.setLayout(new GridLayout(5, 1));
		bottom.setLayout(new GridLayout(1, 4));
		
		JLabel label1 = new JLabel("Korea money : 0");
		JLabel label2 = new JLabel("Japan money : 0");
		JLabel label3 = new JLabel("China money : 0");
		JLabel label4 = new JLabel("Total money : 0");
		JLabel total = new JLabel("총 금액 : ");
		JTextField jt = new JTextField("");
		JButton button = new JButton("시작");
		JButton reset = new JButton("리셋");
		
		button.addActionListener((ActionEvent e) -> {
			Money m = new Money(label4, jt.getText());
			new MyThread(label1, "korea", m).start();
			new MyThread(label2, "japan", m).start();
			new MyThread(label3, "china", m).start();
			button.setEnabled(false);
		});
		
		reset.addActionListener((ActionEvent e) -> {
			button.setEnabled(true);
			jt.setText("");
			label1.setText("Korea money : 0");
			label2.setText("Japan money : 0");
			label3.setText("China money : 0");
			label4.setText("Total money : 0");
			
		});
		
		centor.add(label1);
		centor.add(label2);
		centor.add(label3);
		centor.add(label4);
		
		bottom.add(total);
		bottom.add(jt);
		bottom.add(button);
		bottom.add(reset);
		
		c.add(centor, BorderLayout.CENTER);
		c.add(bottom,BorderLayout.SOUTH);
		
		setTitle("멀티 스레딩");
		setSize(300, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

class Money {
	long koreaMoney = 0;
	long chinaMoney = 0;
	long japanMoney = 0;
	long totalMoney = 0;
	long temp = 0;
	JLabel label;
	public Money(JLabel label, String totalMoney) {
		this.label = label;
		this.temp = Long.parseLong(totalMoney);
	}
	public long plusKoreaMoney() {
		koreaMoney++;
		plusTotalMoney();
		return koreaMoney;
	}
	public long plusChinaMoney() {
		chinaMoney++;
		plusTotalMoney();
		return chinaMoney;
	}
	public long plusJapanMoney() {
		japanMoney++;
		plusTotalMoney();
		return japanMoney;
	}
	private synchronized void plusTotalMoney() {
		if(totalMoney >= temp) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		totalMoney++;
		label.setText("Total money : "+totalMoney);
	}
}

class MyThread extends Thread {
	Money m;
	JLabel label;
	String s;
	
	public MyThread(JLabel label, String s, Money m) {
		this.label = label;
		this.s = s;
		this.m = m;
	}
	
	@Override
	public void run() {
		while(true) {
			if(s.equals("korea")) {
				label.setText("Korea money : "+m.plusKoreaMoney());
			} else if(s.equals("japan")) {
				label.setText("Japan money : "+m.plusJapanMoney());
			} else if(s.equals("china")) {
				label.setText("China money : "+m.plusChinaMoney());
			}
		}
	}
}