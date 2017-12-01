package _07;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Stack extends JFrame implements ActionListener {
	
	String[] data = {""}; // ������ �迭 ����
	
	private DefaultTableModel model = new DefaultTableModel(data,0); // ���� ����Ʈ���̺��
	private JTable jtb = new JTable(model);
	private JLabel jlb = new JLabel("���� �Է�");
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
			String[] data = {jtf.getText()}; // data �迭�� ����
			model.addRow(data); // ���̺� data �迭 �ҷ��ͼ� ���߰�
		} else if(arg0.getSource()==jb2) {
			model.removeRow(0); // 0����� ����
		} else {
			int count = model.getRowCount();
			String count1 = String.valueOf(count); // count �� ����
			jtfr.setText("���� ������ ũ��� " + count1 + "�Դϴ�.");
		}
	}

}
