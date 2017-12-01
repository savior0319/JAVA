package BubbleSort;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class bubble extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JLabel jl1 = new JLabel("정렬할 숫자 입력  ( ,으로 구분해 입력)");
	private JLabel jl2 = new JLabel("정렬된 숫자");
	private JTextArea jta1 = new JTextArea();
	private JScrollPane jsp1 = new JScrollPane(jta1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JTextArea jta2 = new JTextArea();
	private JScrollPane jsp2 = new JScrollPane(jta2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private JButton jbt = new JButton("정렬");

	public bubble() {
		setTitle("버블정렬");
		setSize(400, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jl1.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jl2.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jta1.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jta2.setFont(new Font("맑은고딕", Font.BOLD, 20));
		ct.setLayout(new GridLayout(5, 1));
		ct.add(jsp2);
		ct.add(jl1);
		ct.add(jbt);
		ct.add(jl2);
		ct.add(jsp1);
		jta1.setLineWrap(true);
		jta2.setLineWrap(true);

		jbt.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new bubble().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand() == "정렬") {
			jta1.setText("");
			String get = jta2.getText();
			String[] get1 = get.split(",");

			int i, j;
			int temp = 0;
			int[] getnum = new int[get1.length];

			for (i = 0; i < get1.length; i++) {
				getnum[i] = Integer.parseInt(get1[i]);
			}

			for (i = 0; i < getnum.length - 1; i++) {
				for (j = 0; j < getnum.length - 1; j++) {
					if (getnum[j] > getnum[j + 1]) {
						temp = getnum[j];
						getnum[j] = getnum[j + 1];
						getnum[j + 1] = temp;
					}
				}
			}
			String[] outnum = new String[getnum.length];
			for (i = 0; i < getnum.length; i++) {
				outnum[i] = String.valueOf(getnum[i]);
			}

			for (i = 0; i < outnum.length; i++) {
				jta1.append(outnum[i]);
				if (i < outnum.length - 1) {
					jta1.append(",");
				}
			}
		}
	}
}
