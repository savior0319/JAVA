package _11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class _1_Bio extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JLabel jl1 = new JLabel("생년월일", JLabel.CENTER);
	private JLabel jl2 = new JLabel("신체지수", JLabel.CENTER);
	private JLabel jl3 = new JLabel("감성지수", JLabel.CENTER);
	private JLabel jl4 = new JLabel("지성지수", JLabel.CENTER);
	private JLabel jl5 = new JLabel("", JLabel.CENTER);
	private JLabel jl6 = new JLabel("", JLabel.CENTER);
	private JLabel jl7 = new JLabel("", JLabel.CENTER);
	private JTextField jtf = new JTextField();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();

	private JButton jbt = new JButton("실행");

	public _1_Bio() {
		setTitle("바이오리듬 : 멀티 스레드");
		setSize(300, 120);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ct.setLayout(new BorderLayout());
		jp1.setLayout(new GridLayout(2, 3));
		jp2.setLayout(new GridLayout(1, 3));
		jp3.setLayout(new GridLayout(1, 3));

		jp1.add(jl1);
		jp1.add(jtf);
		jp1.add(jbt);

		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);

		jp3.add(jl5);
		jp3.add(jl6);
		jp3.add(jl7);

		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jp3, BorderLayout.CENTER);
		jbt.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _1_Bio().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		_1_BioThread bt1 = new _1_BioThread(jtf, jl5, jl6, jl7, "body");
		_1_BioThread bt2 = new _1_BioThread(jtf, jl5, jl6, jl7, "sensitivity");
		_1_BioThread bt3 = new _1_BioThread(jtf, jl5, jl6, jl7, "verstand");
		if (arg0.getSource() == jbt) {
			bt1.start();
			bt2.start();
			bt3.start();
		}
	}
}
