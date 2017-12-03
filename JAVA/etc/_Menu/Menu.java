/*
 * �ڹ� Swing �޴��� ����
 * 17-12-03
 */
package _Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JLabel jl = new JLabel(" ", JLabel.CENTER);
	private JMenuBar jmb = new JMenuBar(); // �޴��� �߰�
	private JMenu m1 = new JMenu("�޴� (A)"); // �޴� ��� �߰�
	private JMenuItem item1, item2; // m1(�޴�) ����� ������ �߰�
	private JLabel jl1 = new JLabel("����ǥ����");

	public Menu() {
		setTitle("�޴���");
		setSize(300, 200);
		setResizable(false);
		setLocation(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jl.setOpaque(true); // JLabel ���� �����ϱ� ���� ������ �� true�� ����
		jl.setBackground(Color.WHITE);
		jl.setFont(new Font("�������", Font.BOLD, 20));

		ct.add(jl, BorderLayout.CENTER);
		jl1.setFont(new Font("�������", Font.PLAIN, 13));
		ct.add(jl1, BorderLayout.SOUTH);

		jmb.add(m1); // �޴��ٿ� m1 �޴� ����
		m1.setMnemonic(KeyEvent.VK_A); // ����Ű ���� ALT + A
		item1 = new JMenuItem("Ȯ ��");
		item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // item1 ����Ű ����
		m1.add(item1); // m1 �� ������1 ����
		m1.addSeparator();
		item2 = new JMenuItem("�� ��");
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK)); // item2 ����Ű ����
		m1.add(item2); // m1 �� ������2 ����
		setJMenuBar(jmb); // �޴��ٸ� �����ӿ� �߰�

		item1.addActionListener(this);
		item2.addActionListener(this);
	}

	public static void main(String[] args) {
		new Menu().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "Ȯ ��") {
			jl.setText("Ȯ��");
			jl1.setText("Ȯ���� ���õǾ����ϴ�.");
		} else if (arg0.getActionCommand() == "�� ��") {
			System.exit(0); // ���α׷� ����
		}
	}
}
