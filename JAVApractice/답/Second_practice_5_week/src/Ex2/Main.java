package Ex2;

import java.io.FileWriter;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class UI extends JFrame implements ActionListener {
	 Container ct = getContentPane();
	 JPanel northPanel = new JPanel();
	 JPanel centerPanel = new JPanel();
	 JPanel southPanel = new JPanel();
	 JLabel label = new JLabel();
	 JTextField textField = new JTextField();
	 JComboBox combo = new JComboBox();
	JButton btn = new JButton("����");

	public UI() {
		label.setText("����� ���Ǳ�");
		combo.addItem("�ݶ�");
		combo.addItem("���̴�");
		combo.addItem("ȯŸ");
		combo.addItem("����");
		combo.setEditable(true);

		textField.setColumns(20);
		textField.setEditable(false);

		northPanel.add(label);
		centerPanel.add(combo);
		southPanel.add(textField);

		combo.addActionListener(this);
		btn.addActionListener(this);

		ct.add(northPanel);
		ct.add(centerPanel);
		ct.add(btn);
		ct.add(southPanel);
		
		setLayout(new GridLayout(4, 1));	
		setTitle("���Ǳ�");
		setLocation(120, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			// �׸��� ��ȯ���� ������Ʈ�� ���������� ��ȯ�Ǵ� String���� ����ȯ ����� �մϴ�
			String str = (String) combo.getSelectedItem();
			System.out.println(str);
			if (str.equals("�ݶ�")) {
				textField.setText("�ݶ�� 1000�� �Դϴ�");
			}else if (str.equals("���̴�")) {
				textField.setText("���̴ٴ� 1200�� �Դϴ�");
			}else if (str.equals("ȯŸ")) {
				textField.setText("ȯŸ�� 800�� �Դϴ�");
			}else {
				textField.setText("������ 500�� �Դϴ�");
			}
		}
	}

}

public class Main {
	public static void main(String[] args) {
		new UI();
	}
}