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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main {
	public static void main(String[] args) {
		new WindowFrame().setVisible(true);
	}
}

class WindowFrame extends JFrame implements ActionListener {
	String[] name = { "이름", "국어", "영어", "수학", "평균" };
	String[][] index;
	DefaultTableModel model = new DefaultTableModel(index, name);
	JTable jt;
	JScrollPane js = new JScrollPane(jt);
	JTextField[] jf = new JTextField[4];
	JButton insert = new JButton("추가");
	JLabel[] jl = new JLabel[5];
	String[] str = { "이름", "국어", "영어", "수학", "" };

	public WindowFrame() {
		jt = new JTable(model);
		JScrollPane scroll = new JScrollPane(jt);
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp2 = new JPanel();

		jp2.setLayout(new GridLayout(2, 5));

		for (int i = 0; i < jl.length; i++) {
			jl[i] = new JLabel(str[i], JLabel.CENTER);
			jp2.add(jl[i]);
		}
		for (int i = 0; i < jf.length; i++) {
			jf[i] = new JTextField("");
			jp2.add(jf[i]);
		}
		jp2.add(insert);

		con.add(scroll, BorderLayout.CENTER);
		con.add(jp2, BorderLayout.SOUTH);

		insert.addActionListener(this);
		setTitle("점수 관리 프로그램");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String name = jf[0].getText();
		String korea = jf[1].getText();
		String english = jf[2].getText();
		String math = jf[3].getText();

		String avg = String.valueOf((Integer.parseInt(korea) + Integer.parseInt(english) + Integer.parseInt(math)) / 3);
		//
		// DefaultTableModel m = (DefaultTableModel) jt.getModel();
		//
		// m.insertRow(0, new Object[] { jf[0].getText(), jf[1].getText(),
		// jf[2].getText(), jf[3].getText(), avg });
		for (int i = 0; i < jf.length; i++) {
			jf[i].setText("");
		}

		String[] data = new String[] { name, korea, english, math, avg };
		model.addRow(data);
		for (int i = 0; i < jf.length; i++) {
			jf[i].setText("");
		}

	}
}