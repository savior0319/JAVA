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
	JButton btn = new JButton("선택");

	public UI() {
		label.setText("음료수 자판기");
		combo.addItem("콜라");
		combo.addItem("사이다");
		combo.addItem("환타");
		combo.addItem("생수");
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
		setTitle("자판기");
		setLocation(120, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			// 항목의 반환형이 오브젝트의 참조값으로 반환되니 String으로 형변환 해줘야 합니다
			String str = (String) combo.getSelectedItem();
			System.out.println(str);
			if (str.equals("콜라")) {
				textField.setText("콜라는 1000원 입니다");
			}else if (str.equals("사이다")) {
				textField.setText("사이다는 1200원 입니다");
			}else if (str.equals("환타")) {
				textField.setText("환타는 800원 입니다");
			}else {
				textField.setText("생수는 500원 입니다");
			}
		}
	}

}

public class Main {
	public static void main(String[] args) {
		new UI();
	}
}