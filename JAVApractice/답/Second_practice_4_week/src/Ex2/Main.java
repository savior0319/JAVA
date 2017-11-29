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
	JTextArea jta = new JTextArea("�ݾ��� ���� ��, ������� ����");
	JTextField inputTF = new JTextField("���� �ݾ�");
	JTextField outputTF = new JTextField("��ȯ �ݾ�");
	JButton btn1 = new JButton("�ݶ�(1000)");
	JButton btn2 = new JButton("���̴�(800)");
	JButton btn3 = new JButton("ȯŸ(700)");
	JButton btn4 = new JButton("����");

	int Count_1 = 0; // �ݶ�
	int Count_2 = 0; // ���̴�
	int Count_3 = 0; // ȯŸ

	public UI() {
		setTitle("������ ���Ǳ�");
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
				jta.setText("�ݶ� :" + Count_1 + "�� / " + "���̴� :" + Count_2 + "�� / " + "ȯŸ :" + Count_3 + "�� / " + "�Ѿ� : "
						+ orderMoney + "��");
				outputTF.setText("�ܵ� : " + outputMoney + "��");
			} else {
				jta.setText("�ܾ��� �����մϴ�..");
			}
			Count_1 = 0;
			Count_2 = 0;
			Count_3 = 0;
		}
		
	}
}
