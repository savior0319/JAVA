package _Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JLabel jl = new JLabel("", JLabel.CENTER);
	private JMenuBar jmb = new JMenuBar();
	private JMenuItem item1, item2;
	private JMenu m1 = new JMenu("�޴�1");

	public Menu() {
		setTitle("�޴���");
		setSize(300, 300);
		setResizable(false);
		setLocation(800, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jl.setFont(new Font("�������", Font.BOLD, 20));
		ct.add(jl, BorderLayout.CENTER);

		jmb.add(m1);
		item1 = new JMenuItem("Ȯ��");
		item2 = new JMenuItem("����");
		m1.add(item1);
		m1.addSeparator();
		m1.add(item2);
		setJMenuBar(jmb);

		item1.addActionListener(this);
		item2.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu().setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand() == "Ȯ��") {
			jl.setText("Ȯ��");
		}

		else if (arg0.getActionCommand() == "����") {
			System.exit(0);
		}
	}

}
