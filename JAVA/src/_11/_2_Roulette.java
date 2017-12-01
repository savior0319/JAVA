package _11;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class _2_Roulette extends JFrame implements ActionListener {

	private Container ct = getContentPane();
	private JPanel jp1 = new JPanel();
	private JPanel jp2 = new JPanel();
	private JPanel jp3 = new JPanel();
	private JPanel jp4 = new JPanel();
	private JPanel jp5 = new JPanel();
	private JLabel jl1 = new JLabel("1번 숫자", JLabel.CENTER);
	private JLabel jl2 = new JLabel("2번 숫자", JLabel.CENTER);
	private JLabel jl3 = new JLabel("3번 숫자", JLabel.CENTER);
	private JLabel jl4 = new JLabel("4번 숫자", JLabel.CENTER);
	private JTextField jtf1 = new JTextField();
	private JTextField jtf2 = new JTextField();
	private JTextField jtf3 = new JTextField();
	private JTextField jtf4 = new JTextField();
	private String domain[] = { "회차", "1번 숫자", "2번 숫자", "3번 숫자", "4번 숫자", "당첨금액" };
	private String data[][] = new String[0][0];
	private DefaultTableModel model = new DefaultTableModel(data, domain);
	private JTable jtb = new JTable(model);
	private JScrollPane jsp = new JScrollPane(jtb);

	private JLabel jl5 = new JLabel("   금액 투입:   ");
	private JTextField jtf5 = new JTextField();
	private JButton jbt = new JButton("시작");
	private JLabel jl6 = new JLabel("투입 금액 ->   ");
	private JLabel jl7 = new JLabel("원이 남음", JLabel.CENTER);
	private JLabel jl8 = new JLabel("원을 획득 하셨습니다.", JLabel.CENTER);

	public _2_Roulette() {
		setTitle("룰렛 프로그램");
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		ct.setLayout(new BorderLayout());

		jp1.setLayout(new GridLayout(2, 4));
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jtf1);
		jp1.add(jtf2);
		jp1.add(jtf3);
		jp1.add(jtf4);

		jp2.setLayout(new BorderLayout());
		jp3.setLayout(new BorderLayout());
		jp3.add(jl5, BorderLayout.WEST);
		jp4.setLayout(new GridLayout(1, 2));
		jp4.add(jtf5);
		jp4.add(jbt);
		jp5.setLayout(new GridLayout(1, 2));
		jp5.add(jl6);
		jp5.add(jl7);

		jp3.add(jp4, BorderLayout.CENTER);
		jp3.add(jp5, BorderLayout.EAST);
		jp2.add(jp3, BorderLayout.NORTH);
		jp2.add(jl8, BorderLayout.SOUTH);
		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jp2, BorderLayout.SOUTH);

		jbt.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _2_Roulette().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == jbt) {
			_2_RouletteThread mt = new _2_RouletteThread(model, jtf1, jtf2, jtf3, jtf4, jtf5, jl7, jl8, jsp);
			mt.start();
		}
	}
}