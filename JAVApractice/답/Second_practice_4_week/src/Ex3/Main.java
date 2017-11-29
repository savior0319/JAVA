package Ex3;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);
	}
}

class UI extends JFrame implements ActionListener {
	Container ct = getContentPane();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� a hh�� mm�� ss��");
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JButton btn1 = new JButton("���� �ð� ���");
	JButton btn2 = new JButton("N�ð� �� ���");
	JTextField resultTF1= new JTextField("��ư Ŭ�� �� ����ð� ���");
	JTextField inputTF = new JTextField("�ð��� �Է��Ͻÿ�..");
	JTextField resultTF2 = new JTextField("��ư Ŭ�� �� N�ð� �� ���");
	
	public UI() {
		setTitle("�ð� ��� ���α׷�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 130);
		ct.setLayout(new GridLayout(2,1));
		ct.add(panel1);
		ct.add(panel2);
		
		inputTF.setHorizontalAlignment(JTextField.CENTER);
		resultTF1.setHorizontalAlignment(JTextField.CENTER);
		resultTF2.setHorizontalAlignment(JTextField.CENTER);
		
		panel1.setLayout(new GridLayout(1, 2));
		panel1.add(btn1);
		panel1.add(resultTF1);
		panel2.setLayout(new GridLayout(1, 3));
		panel2.add(btn2);
		panel2.add(inputTF);
		panel2.add(resultTF2);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			Calendar calendar = Calendar.getInstance();
			String currentTime = sdf.format(calendar.getTime());
			resultTF1.setText(currentTime);
		}else {
			int addTime = Integer.parseInt(inputTF.getText());
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, addTime);
			String afterTime = sdf.format(calendar.getTime());
			resultTF2.setText(afterTime);
		}
	}
}
