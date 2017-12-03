package _Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JLabel jl = new JLabel("", JLabel.CENTER);
	private JMenuBar jmb = new JMenuBar();
	private JMenuItem item1, item2;
	private JMenu m1 = new JMenu("메뉴1");

	public Menu() {
		setTitle("메뉴바");
		setSize(300, 300);
		setResizable(false);
		setLocation(800, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jl.setFont(new Font("맑은고딕", Font.BOLD, 20));
		ct.add(jl, BorderLayout.CENTER);

		jmb.add(m1);
		item1 = new JMenuItem("확인");
		item2 = new JMenuItem("종료");
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
		if (arg0.getActionCommand() == "확인") {
			jl.setText("확인");
		}

		else if (arg0.getActionCommand() == "종료") {
			System.exit(0);
		}
	}

}
