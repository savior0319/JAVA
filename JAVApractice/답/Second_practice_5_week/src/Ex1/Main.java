package Ex1;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class UI extends JFrame implements ItemListener {
	Container ct = getContentPane();
	 JPanel northPanel = new JPanel();
	 JPanel centerPanel = new JPanel();
	 JPanel southPanel = new JPanel();
	 JLabel label = new JLabel();
	 JTextField textField = new JTextField();
	 JRadioButton radioBtn1 = new JRadioButton("콜라");
	 JRadioButton radioBtn2 = new JRadioButton("사이다");
	 JRadioButton radioBtn3 = new JRadioButton("환타");
	 JRadioButton radioBtn4 = new JRadioButton("생수");
	 ButtonGroup group = new ButtonGroup();

	public UI() {
		label.setText("음료수를 선택해 주세요.");
		group.add(radioBtn1);
		group.add(radioBtn2);
		group.add(radioBtn3);
		textField.setColumns(20);
		textField.setEditable(false);
		northPanel.add(label);
		centerPanel.add(radioBtn1);
		centerPanel.add(radioBtn2);
		centerPanel.add(radioBtn3);
		centerPanel.add(radioBtn4);
		southPanel.add(textField);

		radioBtn1.addItemListener(this);
		radioBtn2.addItemListener(this);
		radioBtn3.addItemListener(this);
		radioBtn4.addItemListener(this);

		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setTitle("자판기");
		setLocation(120, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		String str = "";
		if ((e.getSource() == radioBtn1) || (e.getSource() == radioBtn2) || (e.getSource() == radioBtn3)
				|| (e.getSource() == radioBtn4)) {
			if (radioBtn1.isSelected()) {
				str = "콜라는 1200원 입니다";
			}

			if (radioBtn2.isSelected()) {
				str = "사이다는 1000원 입니다";
			}

			if (radioBtn3.isSelected()) {
				str = "환타는 800원 입니다";
			}

			if (radioBtn4.isSelected()) {
				str = "생수는 500원 입니다";
			}

			textField.setText(str);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		new UI();
	}
}