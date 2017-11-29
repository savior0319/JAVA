package Ex3;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main {
	public static void main(String[] args) {
		new UI().setVisible(true);
	}
}

class UI extends JFrame implements ActionListener{
	Container ct = getContentPane();
	String index[] = {"Stack"};
	DefaultTableModel dtm = new DefaultTableModel(index, 0);
	JTable table = new JTable(dtm);
	JScrollPane jsp = new JScrollPane(table);
	JPanel panel1 = new JPanel();
	JButton pushButton = new JButton("PUSH");
	JButton popButton = new JButton("POP");
	JButton printButton = new JButton("CurrentStack");
	JTextField tf = new JTextField();
	JTextField tf2 = new JTextField("현재 스택 크기는 2입니다...");
	JLabel lb = new JLabel("숫자 입력");
	public UI() {
		setTitle("자바 실습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		panel1.setLayout(new GridLayout(10, 1));
		lb.setHorizontalAlignment(JLabel.CENTER);
		panel1.add(lb);
		panel1.add(tf);
		panel1.add(pushButton);
		panel1.add(pushButton);
		panel1.add(popButton);
		panel1.add(printButton);
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		panel1.add(new JLabel());
		
		ct.setLayout(new BorderLayout());
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(panel1, BorderLayout.EAST);
		ct.add(tf2, BorderLayout.SOUTH);
		
		pushButton.addActionListener(this);
		popButton.addActionListener(this);
		printButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pushButton) {
			String[] strArr = {tf.getText()};
			dtm.addRow(strArr);
		}else if (e.getSource() == popButton) {
			dtm.removeRow(dtm.getRowCount()-1);
		}else {
			String result = "현재 스택크기는 "+String.valueOf(dtm.getRowCount())+"입니다";
			tf2.setText(result);
		}
		
	}
}
