package Ex2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);
	}
}

class UI extends JFrame implements ActionListener {
	Container ct = getContentPane();
	JPanel centerPanel = new JPanel();
	JPanel southPanel = new JPanel();
	JTextArea jta = new JTextArea("금액을 투입 후, 음료수를 구매");
	JTextField inputTF = new JTextField("투입 금액");
	JTextField outputTF = new JTextField("반환 금액");
	JButton btn1 = new JButton("콜라(1000)");
	JButton btn2 = new JButton("사이다(800)");
	JButton btn3 = new JButton("환타(700)");
	JButton btn4 = new JButton("구매");

	int Count_1 = 0; // 콜라
	int Count_2 = 0; // 사이다
	int Count_3 = 0; // 환타

	public UI() {
		setTitle("간단한 자판기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);

		ct.setLayout(new BorderLayout());
		ct.add(jta, BorderLayout.NORTH);
		ct.add(centerPanel, BorderLayout.CENTER);
		ct.add(southPanel, BorderLayout.SOUTH);

		centerPanel.setLayout(new GridLayout(2, 2));
		centerPanel.add(btn1);
		centerPanel.add(btn2);
		centerPanel.add(btn3);
		centerPanel.add(btn4);

		southPanel.setLayout(new GridLayout(2, 1));
		southPanel.add(inputTF);
		southPanel.add(outputTF);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			Count_1++;
		} else if (e.getSource() == btn2) {
			Count_2++;
		} else if (e.getSource() == btn3) {
			Count_3++;
		} else {
			int inputMoney = Integer.parseInt(inputTF.getText());
			System.out.println(inputMoney);
			int orderMoney = (Count_1*1000)+(Count_2*800)+(Count_3*700);
			System.out.println(orderMoney);
			int outputMoney = inputMoney - orderMoney;
			System.out.println(outputMoney);
			if (outputMoney >= 0) {
				jta.setText("콜라 :" + Count_1 + "개 / " + "사이다 :" + Count_2 + "개 / " + "환타 :" + Count_3 + "개 / " + "총액 : "
						+ orderMoney + "원");
				outputTF.setText("잔돈 : " + outputMoney + "원");
			} else {
				jta.setText("잔액이 부족합니다..");
			}
			Count_1 = 0;
			Count_2 = 0;
			Count_3 = 0;
		}
		
	}
}
