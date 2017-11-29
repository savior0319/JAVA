package Ex1;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);
	}
}

class UI extends JFrame implements ActionListener, KeyListener{
	Container ct = getContentPane();
	String[] strArr = {"2진수","8진수","10진수","16진수"};
	JLabel lb1 = new JLabel("지수 선택");
	JLabel lb2 = new JLabel("입력 숫자");
	JLabel lb3 = new JLabel("출력 결과");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JComboBox cb = new JComboBox(strArr);
	public UI() {
		setTitle("자바 실습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,200);
		lb1.setHorizontalAlignment(JLabel.CENTER);
		lb2.setHorizontalAlignment(JLabel.CENTER);
		lb3.setHorizontalAlignment(JLabel.CENTER);
		tf1.addKeyListener(this);
		
		ct.setLayout(new GridLayout(3,2));
		ct.add(lb1);
		ct.add(cb);
		ct.add(lb2);
		ct.add(tf1);
		ct.add(lb3);
		ct.add(tf2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			int inputNum = Integer.parseInt(tf1.getText());
			
			if (cb.getSelectedIndex() == 0) {
				tf2.setText(Integer.toBinaryString(inputNum));
			}else if (cb.getSelectedIndex() == 1) {
				tf2.setText(Integer.toOctalString(inputNum));
			}else if (cb.getSelectedIndex() == 2) {
				tf2.setText(String.valueOf(inputNum));
			}else{
				tf2.setText(Integer.toHexString(inputNum));
			}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
