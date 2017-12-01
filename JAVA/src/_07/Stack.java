package _07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Stack extends JFrame implements ActionListener {
	
	String[] data = {""}; // 저장할 배열 생성
	
	private DefaultTableModel model = new DefaultTableModel(data,0); // 저장 디폴트테이블모델
	private JTable jtb = new JTable(model);
	private JLabel jlb = new JLabel("숫자 입력");
	private JTextField jtf = new JTextField();
	private JTextField jtfr = new JTextField();
	private JScrollPane jsp = new JScrollPane(jtb);
	private JButton jb1 = new JButton("PUSH");
	private JButton jb2 = new JButton("POP");
	private JButton jb3 = new JButton("CurrentStack");
	private Container ct = getContentPane();
	private JPanel jp = new JPanel();
	
	public Stack() {
		setTitle("PUSH & POP");
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());
		ct.add(jsp, BorderLayout.CENTER);
		jp.setLayout(new GridLayout(5,1));
		jp.add(jlb);
		jp.add(jtf);
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		ct.add(jp, BorderLayout.EAST);
		ct.add(jtfr, BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stack().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1) {
			String[] data = {jtf.getText()}; // data 배열에 저장
			model.addRow(data); // 테이블에 data 배열 불러와서 행추가
		} else if(arg0.getSource()==jb2) {
			model.removeRow(0); // 0행까지 삭제
		} else {
			int count = model.getRowCount();
			String count1 = String.valueOf(count); // count 값 저장
			jtfr.setText("현재 스택의 크기는 " + count1 + "입니다.");
		}
	}

}
